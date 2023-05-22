package fcu.app.breakfast;

import java.util.List;
import java.util.Vector;

import android.content.res.Resources;

public class ShoppingCartHelper {

  public static final String PRODUCT_INDEX1 = "PRODUCT_INDEX1";
  public static final String PRODUCT_INDEX2 = "PRODUCT_INDEX2";
  public static final String PRODUCT_INDEX3 = "PRODUCT_INDEX3";


  private static List<Product> maincatalog;
  private static List<Product> drinkcatalog;
  private static List<Product> dessertcatalog;
  private static List<Product> cart;

  public static List<Product> getMainCatalog(Resources res){
    if(maincatalog == null) {
      maincatalog = new Vector<Product>();
      maincatalog.add(new Product("主食一號", res.getDrawable(R.drawable.p1),
        "主食一號，一百塊", 100));
      maincatalog.add(new Product("主食二號", res.getDrawable(R.drawable.p2),
        "主食二號，兩百塊", 200));
      maincatalog.add(new Product("主食三號", res.getDrawable(R.drawable.p3),
        "主食三號，三百塊", 300));
    }

    return maincatalog;
  }

  public static List<Product> getDrinkCatalog(Resources res){
    if(drinkcatalog == null) {
      drinkcatalog = new Vector<Product>();
      drinkcatalog.add(new Product("飲料一號", res.getDrawable(R.drawable.p4),
        "飲料一號，十塊", 10));
      drinkcatalog.add(new Product("飲料二號", res.getDrawable(R.drawable.p5),
        "飲料二號，二十塊", 20));
      drinkcatalog.add(new Product("飲料三號", res.getDrawable(R.drawable.p6),
        "飲料三號，三十塊", 30));
    }

    return drinkcatalog;
  }

  public static List<Product> getDessertCatalog(Resources res){
    if(dessertcatalog == null) {
      dessertcatalog = new Vector<Product>();
      dessertcatalog.add(new Product("甜點一號", res.getDrawable(R.drawable.p7),
        "甜點一號，一百塊", 100));
      dessertcatalog.add(new Product("甜點二號", res.getDrawable(R.drawable.p8),
        "甜點二號，兩百塊", 200));
      dessertcatalog.add(new Product("甜點三號", res.getDrawable(R.drawable.p9),
        "甜點三號，三百塊", 300));
    }

    return dessertcatalog;
  }

  public static List<Product> getCart() {
    if(cart == null) {
      cart = new Vector<Product>();
    }

    return cart;
  }

}