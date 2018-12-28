package service;

import dao.BaseModele;
import dao.HibernateDao;
import modele.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Fonction {
    @Autowired
    private HibernateDao dao;
    public boolean login(String username, String password ){
        boolean               isValidUser  = false;
        try {
            ArrayList<BaseModele> utilisateurs =dao.findAll(new Utilisateur(), "email='%s' and password='%s'");
            if(utilisateurs != null && utilisateurs.size() > 0) {
                isValidUser = true;
            }
        } catch(Exception e) {
            isValidUser = false;
        }

       return isValidUser;
    }
}
