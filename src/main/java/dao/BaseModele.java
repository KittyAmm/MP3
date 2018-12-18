package dao;

import dao.annotation.Table;
import dao.util.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//ts azo instanciena
public abstract class BaseModele {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomTable() {
        Table table = getClass().getAnnotation(Table.class);
        if (table != null){
            return table.name();
        }
        return getClass().getSimpleName();
    }


    public String getNomSequence() {
        return "id" + getNomTable().toLowerCase();
    }

    public String getId(Connection c, String seq) throws Exception {
        ResultSet         rs = null;
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(Query.getQuerySec(seq));
            rs = ps.executeQuery();
            if (rs.next()) {
                setId(String.valueOf(rs.getInt(1)));
            }
            return id;

        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
    }
}