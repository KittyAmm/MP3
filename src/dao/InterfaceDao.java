package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface InterfaceDao {
    String queryInsert(BaseModele baseModele) throws IllegalAccessException;

    String queryUpdate(BaseModele bm) throws Exception;

    String queryDelete(BaseModele bm) throws Exception;

    String queryFindAll(BaseModele bm) throws Exception;

    void save(BaseModele bm, Connection conn) throws Exception;

    void save(BaseModele bm) throws Exception;

    void update(BaseModele bm, Connection connection) throws Exception;

    void update(BaseModele bm) throws Exception;

    void delete(BaseModele bm, Connection conn) throws Exception;

    void delete(BaseModele bm) throws Exception;

    ArrayList<BaseModele> findAll(BaseModele bm, Connection conn) throws Exception;

    ArrayList<BaseModele> findAll(BaseModele bm) throws Exception;
}
