package dao;

import dao.annotation.Column;
import dao.annotation.NotColumn;
import dao.connex.Connexion;
import dao.util.ConfigDB;
import dao.util.DB;
import dao.util.Query;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GenericDao implements InterfaceDao {
    private String paginationORCL(int min, int max) {
        return String.format("SELECT * FROM (SELECT %%s.*, ROWNUM ROW_NUM from %%s) WHERE ROW_NUM BETWEEN %d AND %d", min, max);
    }

    private String paginationPGSQL(int offset, int nombre) {
        return "offset " + offset + " fetch next " + nombre + " rows only";
    }

    private String getNameColumn(Field field) {
        Column column = field.getAnnotation(Column.class);
        if (column != null) {
            return column.name();
        }
        return field.getName();
    }

    private Field[] getColumnTable(BaseModele bm) {
        ArrayList<Field> list   = new ArrayList<>();
        Field[]          fields = bm.getClass().getDeclaredFields();
        for (Field field : fields) {
            NotColumn notColumn = field.getAnnotation(NotColumn.class);
            if (notColumn == null) {
                list.add(field);
            }
        }
        return list.toArray(new Field[list.size()]);
    }

    public String queryPagination(BaseModele bm, int index, int nombre) throws Exception {
        int offset = nombre * (index - 1);
        int max    = nombre * index;

        if (ConfigDB.DB_TYPE == DB.ORCL) {
            String req      = paginationORCL(offset, max);
            String nomTable = bm.getNomTable();
            String query    = String.format(req, nomTable, nomTable);
            System.out.println(query);
            return query;
        } else if (ConfigDB.DB_TYPE == DB.PGSQL) {
            String page  = paginationPGSQL(offset, nombre);
            String query = Query.select("*", bm.getNomTable(), page);
            System.out.println(query);
            return query;
        } else {
            throw new Exception("Votre base des données n'est pas configuré");
        }
    }

    public String queryFindAll(BaseModele bm, String where) {
        String query;
        if (where.equals("")) {
            query = String.format("select * from %s", bm.getNomTable());
        } else {
            String select = "select * from %s where %s";
            query = String.format(select, bm.getNomTable(), where);
        }
        System.out.println(query);
        return query;
    }

    public String queryFind(String requette, BaseModele bm, String where) {
        String findquery = String.format(requette, bm.getNomTable(), where);
        System.out.println(findquery);
        return findquery;
    }


    public String queryCount(BaseModele bm, String where) {
        String requette = "select count(*) as nb from %s";
        if (!Query.isNullOrEmpty(where)) {
            requette = requette + " where " + where;
        }
        String findquery = String.format(requette, bm.getNomTable());
        System.out.println(findquery);
        return findquery;
    }

    public String queryFindById(BaseModele bm, String id) {
        String findAll = "select * from %s where id= '%s'";
        findAll = String.format(findAll, bm.getNomTable(), id);
        System.out.println(findAll);
        return findAll;
    }

    public String queryFindByIdColonne(BaseModele bm, String where, String id) {
        String findAll = "select * from %s where " + where + "= '%s'";
        findAll = String.format(findAll, bm.getNomTable(), id);
        System.out.println(findAll);
        return findAll;
    }


    public String queryInsert(BaseModele baseModele) {
        Field[]       fields  = getColumnTable(baseModele);
        String        insert  = "insert into %s (%s) values(%s)";
        StringBuilder colonne = new StringBuilder("id, ");
        StringBuilder values  = new StringBuilder("?, ");
        for (Field field : fields) {
            field.setAccessible(true);
            colonne.append(getNameColumn(field)).append(", ");
            values.append("?, ");
        }
        colonne.delete(colonne.length() - 2, colonne.length());
        values.delete(values.length() - 2, values.length());
        insert = String.format(insert, baseModele.getNomTable(), colonne.toString(), values.toString());
        System.out.println(insert);
        return insert;
    }


    public String queryUpdate(BaseModele bm) {
        Field[]       fields = getColumnTable(bm);
        String        update = "update %s set %s where id='%s'";
        StringBuilder values = new StringBuilder();
        for (Field field : fields) {
            field.setAccessible(true);
            values.append(getNameColumn(field)).append(" = ?, ");
        }
        values.deleteCharAt(values.length() - 2);
        update = String.format(update, bm.getNomTable(), values, bm.getId());
        System.out.println(update);
        return update;
    }

    public String queryDelete(BaseModele bm) {
        return String.format("delete from %s where id= '%s'", bm.getNomTable(), bm.getId());
    }

    public String queryDelete(BaseModele bm, String where) {
        String query;
        if (where.equals("")) {
            query = String.format("delete from %s", bm.getNomTable());
        } else {
            String delete = "delete from %s where %s";
            query = String.format(delete, bm.getNomTable(), where);
        }
        System.out.println(query);
        return query;
    }

    public String queryFindAll(BaseModele bm) {
        String findAll = "select * from %s";
        findAll = String.format(findAll, bm.getNomTable());
        System.out.println(findAll);
        return findAll;
    }

    public void save(BaseModele bm, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(queryInsert(bm));
            ps.setObject(1, bm.getId(conn, bm.getNomSequence()));
            Field[] fields = getColumnTable(bm);
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                ps.setObject(i + 2, fields[i].get(bm));
                System.out.println(fields[i].get(bm) + fields[i].getName());
            }
            ps.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) ps.close();
        }
    }

    @Override
    public void save(BaseModele bm) throws Exception {
        Connection conn = null;
        try {
            conn = Connexion.getConnexion();
            conn.setAutoCommit(false);
            save(bm, conn);
            conn.commit();
        } catch (Exception e) {
            if (conn != null)
                conn.rollback();
            throw e;
        } finally {
            Connexion.fermerRessource(conn, null, null);
        }
    }

    public void update(BaseModele bm, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(queryUpdate(bm));
            Field[] fields = getColumnTable(bm);
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                ps.setObject(i + 1, fields[i].get(bm));
            }
            ps.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) ps.close();
        }
    }

    @Override
    public void update(BaseModele bm) throws Exception {
        Connection conn = null;
        try {
            conn = Connexion.getConnexion();
            conn.setAutoCommit(false);
            update(bm, conn);
            conn.commit();
        } catch (Exception e) {
            if (conn != null)
                conn.rollback();
            throw e;
        } finally {
            Connexion.fermerRessource(conn, null, null);
        }
    }

    public void delete(BaseModele bm, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(queryDelete(bm));
            ps.execute();
        } finally {
            if (ps != null) ps.close();
        }
    }

    @Override
    public void delete(BaseModele bm) throws Exception {
        Connection conn = null;
        try {
            conn = Connexion.getConnexion();
            conn.setAutoCommit(false);
            delete(bm, conn);
            conn.commit();
        } catch (Exception e) {
            if (conn != null)
                conn.rollback();
            throw e;
        } finally {
            Connexion.fermerRessource(conn, null, null);
        }
    }

    public void delete(BaseModele bm, String where, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(queryDelete(bm, where));
            ps.execute();
        } finally {
            if (ps != null) ps.close();
        }
    }

    public void delete(BaseModele bm, String where) throws Exception {
        Connection conn = null;
        try {
            conn = Connexion.getConnexion();
            conn.setAutoCommit(false);
            delete(bm, where, conn);
            conn.commit();
        } catch (Exception e) {
            if (conn != null)
                conn.rollback();
            throw e;
        } finally {
            Connexion.fermerRessource(conn, null, null);
        }
    }


    private void setData(BaseModele bm, ResultSet res, ArrayList<BaseModele> modeles) throws Exception {
        Field[] fields = getColumnTable(bm);
        while (res.next()) {
            BaseModele modele = bm.getClass().newInstance();
            modele.setId(res.getString("id"));
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(modele, res.getObject(getNameColumn(field)));
            }
            modeles.add(modele);
        }
    }

    public ArrayList<BaseModele> findAll(BaseModele bm, String where, Connection conn) throws Exception {
        PreparedStatement     ps     = null;
        ResultSet             res    = null;
        ArrayList<BaseModele> models = new ArrayList<>();
        try {
            ps = conn.prepareStatement(queryFindAll(bm, where));
            res = ps.executeQuery();
            setData(bm, res, models);
        } finally {
            Connexion.fermerRessource(null, ps, res);
        }
        return models;
    }

    public ArrayList<BaseModele> findAll(BaseModele bm, Connection conn) throws Exception {
        PreparedStatement     ps     = null;
        ResultSet             res    = null;
        ArrayList<BaseModele> models = new ArrayList<>();
        try {
            ps = conn.prepareStatement(queryFindAll(bm));
            res = ps.executeQuery();
            setData(bm, res, models);
        } finally {
            Connexion.fermerRessource(null, ps, res);
        }
        return models;
    }

    @Override
    public ArrayList<BaseModele> findAll(BaseModele bm) throws Exception {
        Connection conn = null;
        try {
            conn = Connexion.getConnexion();
            return findAll(bm, conn);
        } finally {
            Connexion.fermerRessource(conn, null, null);
        }
    }

    public ArrayList<BaseModele> findQuery(String requette, BaseModele modele, String where, Connection con) throws Exception {
        PreparedStatement     ps     = null;
        ResultSet             res    = null;
        ArrayList<BaseModele> models = new ArrayList<>();
        try {
            ps = con.prepareStatement(queryFind(requette, modele, where));
            res = ps.executeQuery();
            setData(modele, res, models);
        } finally {
            Connexion.fermerRessource(null, ps, res);
        }
        return models;
    }

    public double GetSum(BaseModele modele, String nomColonne, String where, Connection conn) throws Exception {
        String            req    = "select sum(" + nomColonne + ") as total from " + modele.getNomTable();
        PreparedStatement reader = null;
        ResultSet         res    = null;
        try {
            reader = conn.prepareStatement(queryFind(req, modele, where));
            res = reader.executeQuery();
            if (res.next()) {
                res.getDouble(1);
            }
        } finally {
            Connexion.fermerRessource(conn, reader, res);
        }
        return 0;
    }

    public int GetCount(BaseModele modele, String where) throws Exception {
        Connection conn = null;
        try {
            conn = Connexion.getConnexion();
            return GetCount(modele, where, conn);
        } finally {
            Connexion.fermerRessource(conn, null, null);
        }
    }

    public int GetCount(BaseModele modele, String where, Connection conn) throws Exception {
        PreparedStatement reader = null;
        ResultSet         res    = null;
        try {
            reader = conn.prepareStatement(queryCount(modele, where));
            res = reader.executeQuery();
            if (res.next()) {
                return res.getInt(1);
            }
        } finally {
            Connexion.fermerRessource(conn, reader, res);
        }
        return 0;
    }

    public double GetSum(BaseModele modele, String nomColonne, String where) throws Exception {
        Connection conn = null;
        try {
            conn = Connexion.getConnexion();
            return GetSum(modele, nomColonne, where, conn);
        } finally {
            Connexion.fermerRessource(conn, null, null);
        }
    }

    public ArrayList<BaseModele> findQuery(String req, String where, BaseModele bm) throws Exception {
        Connection conn = null;
        try {
            conn = Connexion.getConnexion();
            return findQuery(req, bm, where, conn);
        } finally {
            Connexion.fermerRessource(conn, null, null);
        }
    }

    @Override
    public ArrayList<BaseModele> findAll(BaseModele bm, String where) throws Exception {
        Connection conn = null;
        try {
            conn = Connexion.getConnexion();
            return findAll(bm, where, conn);
        } finally {
            Connexion.fermerRessource(conn, null, null);
        }
    }


    @Override
    public void findById(BaseModele bm, String id) throws Exception {
        Connection conn = null;
        try {
            conn = Connexion.getConnexion();
            findById(bm, id, conn);
        } finally {
            Connexion.fermerRessource(conn, null, null);
        }
    }

    public void findById(BaseModele bm, String id, Connection conn) throws Exception {
        PreparedStatement     ps      = null;
        ResultSet             res     = null;
        ArrayList<BaseModele> modeles = new ArrayList<>();
        try {
            ps = conn.prepareStatement(queryFindById(bm, id));
            res = ps.executeQuery();
            Field[] fields = getColumnTable(bm);
            if (res.next()) {
                bm.setId(res.getString("id"));
                for (Field field : fields) {
                    field.setAccessible(true);
                    field.set(bm, res.getObject(getNameColumn(field)));
                }
            }
        } finally {
            Connexion.fermerRessource(conn, ps, res);
        }
    }

    public void findByColonne(BaseModele bm, String where, String id) throws Exception {
        Connection conn = null;
        try {
            conn = Connexion.getConnexion();
            findByColonne(bm, where, id, conn);
        } finally {
            Connexion.fermerRessource(conn, null, null);
        }
    }

    public void findByColonne(BaseModele bm, String where, String id, Connection conn) throws Exception {
        PreparedStatement     ps      = null;
        ResultSet             res     = null;
        ArrayList<BaseModele> modeles = new ArrayList<>();
        try {
            ps = conn.prepareStatement(queryFindByIdColonne(bm, where, id));
            res = ps.executeQuery();
            Field[] fields = getColumnTable(bm);
            if (res.next()) {
                bm.setId(res.getString("id"));
                for (Field field : fields) {
                    field.setAccessible(true);
                    field.set(bm, res.getObject(getNameColumn(field)));
                }
            }
        } finally {
            Connexion.fermerRessource(conn, ps, res);
        }
    }


    public void saveList(ArrayList<BaseModele> modeles) throws Exception {
        Connection conn = null;
        try {
            conn = Connexion.getConnexion();
            conn.setAutoCommit(false);
            saveList(modeles, conn);
            conn.commit();
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void saveList(ArrayList<BaseModele> modeles, Connection conn) throws Exception {
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(queryInsert(modeles.get(0)));
            for (BaseModele bm : modeles) {
                pst.setObject(1, bm.getId(conn, bm.getNomSequence()));
                Field[] fields = getColumnTable(bm);
                for (int i = 0; i < fields.length; i++) {
                    fields[i].setAccessible(true);
                    pst.setObject(i + 2, fields[i].get(bm));
                }
                pst.execute();
            }
        } finally {
            if (pst != null) pst.close();
        }
    }

    public ArrayList<BaseModele> findAll(BaseModele bm, int nombre, int index) throws Exception {
        Connection            conn    = null;
        PreparedStatement     ps      = null;
        ResultSet             res     = null;
        ArrayList<BaseModele> modeles = new ArrayList<>();
        try {
            conn = Connexion.getConnexion();
            ps = conn.prepareStatement(queryPagination(bm, index, nombre));
            res = ps.executeQuery();
            Field[] fields = getColumnTable(bm);
            setData(bm, res, modeles);
        } catch (Exception e) {
            if (conn != null)
                conn.rollback();
            throw e;
        } finally {
            if (ps != null)
                ps.close();
            if (res != null)
                res.close();
        }
        return modeles;
    }
}
