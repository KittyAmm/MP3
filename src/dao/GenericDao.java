package dao;

import dao.connex.Connexion;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class GenericDao implements InterfaceDao {
    @Override
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
        return String.format(insert, baseModele.getNomTable(), colonne.toString(), values.toString());
    }

    @Override
    public String queryUpdate(BaseModele bm) throws Exception {
        Field[]       fields = bm.getClass().getDeclaredFields();
        String        update = "update %s set %s where id='%s'";
        StringBuilder values = new StringBuilder();
        for (Field field : fields) {
            field.setAccessible(true);
            values.append(field.getName()).append(" = ?, ");
        }
        values.deleteCharAt(values.length() - 2);
        return String.format(update, bm.getNomTable(), values, bm.getId());
    }

    @Override
    public String queryDelete(BaseModele bm) throws Exception {
        return String.format("delete %s where id= '%s'", bm.getNomTable(), bm.getId());
    }

    @Override
    public String queryFindAll(BaseModele bm) throws Exception {
        Field[]       fields = bm.getClass().getDeclaredFields();
        String        findAll   = "select * from %s";
        StringBuilder values = new StringBuilder();
        for(Field field : fields) {
            field.setAccessible(true);
            values.append(field.getName().concat("?"));
        }
        values.deleteCharAt(values.length() - 2);
        return String.format(findAll, bm.getNomTable(), values);
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
    public ArrayList<BaseModele> findAll(BaseModele bm, Connection conn) throws Exception {
        PreparedStatement ps = null;
        ArrayList<BaseModele> val = new ArrayList<>();
        try{
            ps = conn.prepareStatement(queryFindAll(bm));
            ps.execute();
            Field[] fields = bm.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                val.add(bm);
            }
        }catch (Exception e){
            throw e;
        }finally {
            if(ps != null)
            ps.close();
        }
        return val;
    }

    @Override
    public ArrayList<BaseModele> findAll(BaseModele bm) throws Exception {
        Connection conn =null;
        ArrayList<BaseModele> ab = new ArrayList<>();
        try {
            conn=Connexion.getConnexion();
           ab =findAll(bm,conn);
            conn.commit();

        }catch (Exception e){
            if (conn != null)
                conn.rollback();
            throw e;
        } finally {
            Connexion.fermerRessource(conn, null, null);
        }
        return ab;
    }
}
