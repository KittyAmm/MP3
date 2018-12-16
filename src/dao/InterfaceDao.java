package dao;

import java.util.ArrayList;

public interface InterfaceDao {
    String queryInsert(BaseModele baseModele) throws IllegalAccessException;

    String queryUpdate(BaseModele bm) throws Exception;

    String queryDelete(BaseModele bm) throws Exception;

    String queryFindAll(BaseModele bm) throws Exception;

    String queryFindAll(BaseModele bm, String where) throws Exception;

    void save(BaseModele bm) throws Exception;

    void update(BaseModele bm) throws Exception;

    void delete(BaseModele bm) throws Exception;

    ArrayList<BaseModele> findAll(BaseModele bm) throws Exception;

    ArrayList<BaseModele> findAll(BaseModele bm, String where) throws Exception;

    void findById(BaseModele modele, String id) throws Exception;


}
