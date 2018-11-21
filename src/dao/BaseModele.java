package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//ts azo instanciena
public abstract class BaseModele {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String table() {
        return getClass().getSimpleName();
    }

    public String getNomSequence() {
        return "sec_" + table().toLowerCase();
    }

    public String getId(Connection c, String seq) throws Exception {
        ResultSet         rs = null;
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement("select " + seq + ".nextval from dual");
            rs = ps.executeQuery();
            if (rs.next()) {
                setId(String.valueOf(rs.getInt("NEXTVAL")));
            }
            return id;

        } catch (SQLException e) {
            throw e;
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
    }
}
