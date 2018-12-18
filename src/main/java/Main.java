import dao.BaseModele;
import modele.Album;

public class Main {
    public static void main(String[] arg) throws Exception {
       GenericDao gdao = new GenericDao();
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

        gdao.findById(client,"1");
        System.out.println(client.getIdartiste());
        System.out.println(client.getIdimage());
//        }
    }
}

