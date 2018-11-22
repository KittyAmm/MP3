package dao;

import java.util.List;

public interface InterfaceDao {

    void save(BaseModele bm) throws Exception;

    void update(BaseModele bm) throws Exception;

    void delete(BaseModele bm) throws Exception;

    void findById(BaseModele modele, String id) throws Exception;

    List<BaseModele> findAll(BaseModele bm) throws Exception;

    List<BaseModele> findAll(BaseModele bm,int nombre,int index,int offset) throws Exception;

}
