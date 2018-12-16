package dao.util;

public class Query {

    public static String select(String colonne, String table) {
        return String.format("select %s from %s", colonne, table);
    }

    public static String select(String colone, String nameTable, String suite) {
        return select(colone, nameTable) + " " + suite;
    }

    public static String getQuerySec(String nomSec) throws Exception {
        if (DB.ORCL == ConfigDB.DB_TYPE) {
            return String.format("select %s.nextval from dual", nomSec);
        } else if (DB.PGSQL == ConfigDB.DB_TYPE || DB.MYSQL == ConfigDB.DB_TYPE) {
            return String.format("select nextval('%s')", nomSec);
        } else if (DB.SSQL == ConfigDB.DB_TYPE) {
            return String.format("select next value for %s", nomSec);
        } else {
            throw new Exception("Impossible de trouver la configuration : " + ConfigDB.class.getSimpleName());
        }
    }
}
