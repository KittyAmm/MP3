
package dao.connex;

import java.sql.*;

public class Connexion implements Database {
    public static Connection getConnexion() {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("connexion etablie");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return conn;
    }

    public static void fermerRessource(Connection conn, Statement state, ResultSet rs) throws Exception {
        if(rs!= null) rs.close();
        if(state != null) state.close();
        if(conn!= null){ conn.close();}

    }
}
/*
    Class.forName("org.postgresql.Driver");
     Class.forName("com.mysql.jdbc.Driver");
 */