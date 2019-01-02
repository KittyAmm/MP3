package dao;

import java.util.ArrayList;

public interface InterfaceDao {

    void save(BaseModele bm) throws Exception;

    void update(BaseModele bm) throws Exception;

    void delete(BaseModele bm) throws Exception;

    ArrayList<BaseModele> findAll(BaseModele bm) throws Exception;

    ArrayList<BaseModele> findAll(BaseModele bm, String where) throws Exception;

    void findById(BaseModele modele, String id) throws Exception;


}
