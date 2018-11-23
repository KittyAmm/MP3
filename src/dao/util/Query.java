package dao.util;

public class Query {
    public static String select(String colonne, String table){
        return String.format("select %s from %s",colonne,table);
    }

    public static String select(String colone, String nameTable, String suite) {
        return select(colone, nameTable) + " " + suite;
    }
}
