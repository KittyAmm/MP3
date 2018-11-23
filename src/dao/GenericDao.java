package dao;

import dao.connex.Connexion;
import dao.util.ParametresDB;
import dao.util.Query;
import dao.util.TypesDB;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GenericDao implements InterfaceDao {
   /* private String paginationORCL(int min, int offset) {
        String sql1 = "SELECT  * from %s WHERE rownum <= " + offset;
        return "SELECT * FROM(" + sql1 + ") WHERE rownum >= " + min + " ORDER BY rownum ";
    }*/

    private String paginationORCL(int min, int max) {
        return String.format("SELECT * FROM (SELECT %%s.*, ROWNUM ROW_NUM from %%s) WHERE ROW_NUM BETWEEN %d AND %d", min, max);
    }

    private String paginationPGSQL(int nombre, int offset) {
        return "offset" + offset + "fetch next" + nombre + "rows only";
    }

    public String queryPagination(BaseModele bm, int index, int nombre, int offset) throws Exception {
        int min = offset * index - offset + 1;
        int max = offset * index;

        if (ParametresDB.DB_TYPE == TypesDB.ORCL) {
            String req      = paginationORCL(min, max);
            String nomTable = bm.table();
            return String.format(req, nomTable, nomTable);
        } else if (ParametresDB.DB_TYPE == TypesDB.PGSQL) {
            String page = paginationPGSQL(nombre, offset);
            return Query.select("*", bm.table(), page);
        } else {
            throw new Exception("Votre base des données n'est pas configuré");
        }
    }

    public String queryInsert(BaseModele baseModele) {
        Field[]       fields  = baseModele.getClass().getDeclaredFields();
        String        insert  = "insert into %s (%s) values(%s)";
        StringBuilder colonne = new StringBuilder("id, ");
        StringBuilder values  = new StringBuilder("?, ");
        for (Field field : fields) {
            field.setAccessible(true);
            colonne.append(field.getName()).append(", ");
            values.append("?, ");
        }
        colonne.delete(colonne.length() - 2, colonne.length());
        values.delete(values.length() - 2, values.length());
        return String.format(insert, baseModele.table(), colonne.toString(), values.toString());
    }

    public String queryUpdate(BaseModele bm) {
        Field[]       fields = bm.getClass().getDeclaredFields();
        String        update = "update %s setData %s where id='%s'";
        StringBuilder values = new StringBuilder();
        for (Field field : fields) {
            field.setAccessible(true);
            values.append(field.getName()).append(" = ?, ");
        }
        values.deleteCharAt(values.length() - 2);
        return String.format(update, bm.table(), values, bm.getId());
    }

    public String queryDelete(BaseModele bm) {
        return String.format("delete %s where id= '%s'", bm.table(), bm.getId());
    }

    public String queryFindById(BaseModele bm, String id) {
        Field[]       fields  = bm.getClass().getDeclaredFields();
        String        findAll = "select * from %s where id= '%s'";
        StringBuilder values  = new StringBuilder();
        for (Field field : fields) {
            field.setAccessible(true);
            values.append(field.getName().concat("?"));
        }
        values.deleteCharAt(values.length() - 2);
        return String.format(findAll, bm.table(), values);
    }

    public String queryFindAll(BaseModele bm) {
        Field[]       fields  = bm.getClass().getDeclaredFields();
        String        findAll = "select * from %s";
        StringBuilder values  = new StringBuilder();
        for (Field field : fields) {
            field.setAccessible(true);
            values.append(field.getName().concat("?"));
        }
        values.deleteCharAt(values.length() - 2);
        return String.format(findAll, bm.table(), values);
    }

    public void save(BaseModele bm, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(queryInsert(bm));
            ps.setObject(1, bm.getId(conn, bm.getNomSequence()));
            Field[] fields = bm.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                ps.setObject(i + 2, fields[i].get(bm));
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
            Field[] fields = bm.getClass().getDeclaredFields();
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
        } catch (Exception e) {
            throw e;
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
    public ArrayList<BaseModele> findAll(BaseModele bm, Connection conn) throws Exception {
        PreparedStatement     ps  = null;
        ResultSet             res = null;
        ArrayList<BaseModele> val = new ArrayList<>();
        try {
            ps = conn.prepareStatement(queryFindAll(bm));
            res = ps.executeQuery();
            Field[] fields = bm.getClass().getDeclaredFields();
            setData(bm, res, val, fields);
        } finally {
            if (ps != null)
                ps.close();
            if (res != null)
                res.close();
        }
        return val;
    }

    @Override
    public void findById(BaseModele bm, String id) throws Exception {
        Connection            conn = null;
        try {
            conn = Connexion.getConnexion();
             findById(bm,id,conn);
            conn.commit();

        } catch (Exception e) {
            if (conn != null)
                conn.rollback();
            throw e;
        } finally {
            Connexion.fermerRessource(conn, null, null);
        }
    }

    public void findById(BaseModele bm, String id,Connection conn) throws Exception {
        PreparedStatement     ps  = null;
        ResultSet             res = null;
        ArrayList<BaseModele> val = new ArrayList<>();
        try {
            ps = conn.prepareStatement(queryFindById(bm,id));
            res = ps.executeQuery();
            Field[] fields = bm.getClass().getDeclaredFields();
            setData(bm, res, val, fields);
        }  catch (Exception e) {
            if (conn != null)
                conn.rollback();
            throw e;
        } finally {
            Connexion.fermerRessource(conn, null, null);
        }
    }

    private void setData(BaseModele bm, ResultSet res, ArrayList<BaseModele> modeles, Field[] fields) throws Exception {
        while (res.next()) {
            BaseModele modele = bm.getClass().newInstance();
            modele.setId(res.getString("id"));
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(modele, res.getObject(field.getName()));
            }
            modeles.add(modele);
        }
    }

    @Override
    public ArrayList<BaseModele> findAll(BaseModele bm) throws Exception {
        Connection            conn = null;
        ArrayList<BaseModele> ab;
        try {
            conn = Connexion.getConnexion();
            ab = findAll(bm, conn);
            conn.commit();

        } catch (Exception e) {
            if (conn != null)
                conn.rollback();
            throw e;
        } finally {
            Connexion.fermerRessource(conn, null, null);
        }
        return ab;
    }

    @Override
    public List<BaseModele> findAll(BaseModele bm, int nombre, int index, int offset) throws Exception {
        Connection            conn    = null;
        PreparedStatement     ps      = null;
        ResultSet             res     = null;
        ArrayList<BaseModele> modeles = new ArrayList<>();
        try {
            conn = Connexion.getConnexion();
            ps = conn.prepareStatement(queryPagination(bm, index, nombre, offset));
            res = ps.executeQuery();
            Field[] fields = bm.getClass().getDeclaredFields();
            setData(bm, res, modeles, fields);
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
