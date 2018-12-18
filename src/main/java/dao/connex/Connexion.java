
package dao.connex;

import dao.util.ConfigDB;

import java.sql.*;

public class Connexion {
    public static Connection getConnexion() throws Exception {
        Connection conn;
        try {
            Class.forName(ConfigDB.DRIVER_PSQL);
            conn = DriverManager.getConnection(ConfigDB.URL, ConfigDB.USER, ConfigDB.PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new Exception(e);
        }
        return conn;
    }

    public static void fermerRessource(Connection conn, Statement state, ResultSet rs) throws Exception {
        if(rs!= null) rs.close();
        if(state != null) state.close();
        if(conn!= null){ conn.close();}
    }
}
