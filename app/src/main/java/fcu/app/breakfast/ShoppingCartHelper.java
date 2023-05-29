package fcu.app.breakfast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import android.content.res.Resources;

public class ShoppingCartHelper {

  public static final String PRODUCT_INDEX1 = "PRODUCT_INDEX1";
  public static final String PRODUCT_INDEX2 = "PRODUCT_INDEX2";
  public static final String PRODUCT_INDEX3 = "PRODUCT_INDEX3";


  private static List<Product> maincatalog;
  private static List<Product> drinkcatalog;
  private static List<Product> dessertcatalog;

  private static Map<Product, ShoppingCartEntry> cartMap = new HashMap<Product, ShoppingCartEntry>();

  public static List<Product> getMainCatalog(Resources res){
    if(maincatalog == null) {
      maincatalog = new Vector<Product>();
      maincatalog.add(new Product("主食一號", res.getDrawable(R.drawable.p1),
        "主食一號，一百塊", 100,1));
      maincatalog.add(new Product("主食二號", res.getDrawable(R.drawable.p2),
        "主食二號，兩百塊", 200,2));
      maincatalog.add(new Product("主食三號", res.getDrawable(R.drawable.p3),
        "主食三號，三百塊", 300,3));
    }

    return maincatalog;
  }

  public static List<Product> getDrinkCatalog(Resources res){
    if(drinkcatalog == null) {
      drinkcatalog = new Vector<Product>();
      drinkcatalog.add(new Product("飲料一號", res.getDrawable(R.drawable.p4),
        "飲料一號，十塊", 10,4));
      drinkcatalog.add(new Product("飲料二號", res.getDrawable(R.drawable.p5),
        "飲料二號，二十塊", 20,5));
      drinkcatalog.add(new Product("飲料三號", res.getDrawable(R.drawable.p6),
        "飲料三號，三十塊", 30,6));
    }

    return drinkcatalog;
  }

  public static List<Product> getDessertCatalog(Resources res){
    if(dessertcatalog == null) {
      dessertcatalog = new Vector<Product>();
      dessertcatalog.add(new Product("甜點一號", res.getDrawable(R.drawable.p7),
        "甜點一號，一百塊", 100,7));
      dessertcatalog.add(new Product("甜點二號", res.getDrawable(R.drawable.p8),
        "甜點二號，兩百塊", 200,8));
      dessertcatalog.add(new Product("甜點三號", res.getDrawable(R.drawable.p9),
        "甜點三號，三百塊", 300,9));
    }

    return dessertcatalog;
  }

  public static void setQuantity(Product product, int quantity) {
    // Get the current cart entry
    ShoppingCartEntry curEntry = cartMap.get(product);

    // If the quantity is zero or less, remove the products
    if(quantity <= 0) {
      if(curEntry != null)
        removeProduct(product);
      return;
    }

    // If a current cart entry doesn't exist, create one
    if(curEntry == null) {
      curEntry = new ShoppingCartEntry(product, quantity,0);
      cartMap.put(product, curEntry);
      return;
    }

    // Update the quantity
    curEntry.setQuantity(quantity);
  }

  public static int getProductQuantity(Product product) {
    // Get the current cart entry
    ShoppingCartEntry curEntry = cartMap.get(product);

    if(curEntry != null)
      return curEntry.getQuantity();

    return 0;
  }

  public static int getProductPrice(Product product) {
    // Get the current cart entry
    ShoppingCartEntry curEntry = cartMap.get(product);

    if(curEntry != null)
      return curEntry.getPrice() * curEntry.getQuantity() ;

    return 0;
  }

  public static void removeProduct(Product product) {
    cartMap.remove(product);
  }

  public static List<Product> getCartList() {
    List<Product> cartList = new Vector<Product>(cartMap.keySet().size());
    for(Product p : cartMap.keySet()) {
      cartList.add(p);
    }
    return cartList;
  }



}