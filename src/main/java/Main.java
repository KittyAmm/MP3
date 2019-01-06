import dao.GenericDao;
import modele.Chanson;
import modele.Mp3Info;
import service.Fonction;

public class Main {
    public static void main(String[] arg) throws Exception {
        GenericDao   gdao         = new GenericDao();
//        HibernateDao hibernateDao = new HibernateDao();
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
//        Utilisateur client = new Utilisateur();
//        client.setId("8");
//        client.setNomuser("min");
//        client.setPswrd("min");
//        client.setEmail("min");
//        client.setBirth("28-07-1998");
//        client.setSexe("f");
//       hibernateDao.update(client);
        Mp3Info mp3Info = new Mp3Info().extractMP3("D:\\ITU\\S5\\Naina\\MP3\\out\\artifacts\\MP3\\resources\\media\\MELKY ft. PRINCIO - TE HANARAKA ANAO.mp3");
        gdao.save(mp3Info);
        Chanson[] song = new Fonction().getSongs();
        System.out.println(song[0].getTitle());
//        new GenericDao().queryPagination(client, 4, 5);

    }

}

