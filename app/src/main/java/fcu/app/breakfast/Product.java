package fcu.app.breakfast;

import android.graphics.drawable.Drawable;

public class Product {

  public String title;
  public Drawable productImage;
  public String description;
  public double price;
  public boolean selected;
  public int meal_id;

  public Product(String title, Drawable productImage, String description,
                 double price, int meal_id) {
    this.title = title;
    this.productImage = productImage;
    this.description = description;
    this.price = price;
    this.meal_id = meal_id;
  }

  public int getMeal_id() {
    return meal_id;
  }
}
