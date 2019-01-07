package dao;

import dao.annotation.Id;
import dao.annotation.Table;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import javax.persistence.MappedSuperclass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//ts azo instanciena
@MappedSuperclass
public abstract class BaseModele {
    @javax.persistence.Id
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomTable() {
        Table table = getClass().getAnnotation(Table.class);
        if (table != null) {
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
            ps = c.prepareStatement(dao.util.Query.getQuerySec(seq));
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

    public String getId(Session session) throws Exception {
        String      seq   = getNomSequence();
        NativeQuery query = session.createSQLQuery(dao.util.Query.getQuerySec(seq));
        id = query.uniqueResult().toString();
        return id;
    }
}
