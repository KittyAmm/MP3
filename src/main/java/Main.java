import dao.GenericDao;
import dao.HibernateDao;
import modele.Album;
import service.Fonction;

public class Main {
    public static void main(String[] arg) throws Exception {
        GenericDao   gdao         = new GenericDao();
        HibernateDao hibernateDao = new HibernateDao();
//        Personne  p    = new Personne("malala", "minou");
//        Produit   p1   = new Produit("kapa","23/07/1998",1000);
//        Produit   p2   = new Produit("kapa","23/07/1998",1000);
//        Produit   p3   = new Produit("kapa","23/07/1998",1000);
//        Produit   p4   = new Produit("kapa","23/07/1998",1000);
//        Produit   p5   = new Produit("kapa","23/07/1998",1000);
//        Produit   p6   = new Produit("kapa","23/07/1998",1000);
//        Produit   p7   = new Produit("kapa","23/07/1998",1000);
//        Produit   p8   = new Produit("kapa","23/07/1998",1000);
//        Produit p9 = new Produit("kapa","23/07/1998",1000);
//        Produit p10 = new Produit("kapa","23/07/1998",1000);
//        p.setId("6");
//        gdao.update(p);
        /*gdao.save(p2);
        gdao.save(p3);
        gdao.save(p4);
        gdao.save(p5);
        gdao.save(p6);
        gdao.save(p7);
        gdao.save(p8);
        gdao.save(p9);
        gdao.save(p10);*/
//       System.out.println(new GenericDao().queryPagination(new Produit(),3,5,5));
//       List<BaseModele> ba = gdao.findAll(new Album());
//        for(int i = 0; i < ba.size(); i++){
//            Album prod = (Album) ba.get(i);
//           System.out.println(String.valueOf(prod.getIdimage()));
        Album client = new Album();
//        client.setId("4");
//        client.setNomuser("mi");
//        client.setPswrd("425");
//        client.setEmail("and");
//        client.setBirth("20");
//        client.setSexe("fa");
//        gdao.findById(client, "1");
//        String           where = String.format("email='%s' and password='%s'", "and", "425");
//        List<BaseModele> ba    = hibernateDao.findAll(new Utilisateur(),where);
//        for(int i = 0; i < ba.size(); i++){
//            Utilisateur prod = (Utilisateur) ba.get(i);
//            System.out.println(String.valueOf(prod.getEmail()));
//        }
        String titre = new Fonction().readArtist("D:\\ITU\\S5\\Naina\\MP3\\src\\main\\java\\media\\Mandy Moore - Cry (A Walk To Remember).mp3");
        System.out.println(titre);
    }
}

