package fcu.app.breakfast;

public class ShoppingCartEntry {

  private Product mProduct;
  private int mQuantity;
  private int mPrice;

  public ShoppingCartEntry(Product product, int quantity, int price) {
    mProduct = product;
    mQuantity = quantity;
    mPrice = mProduct.getPrice();
  }

  public Product getProduct() {
    return mProduct;
  }

  public int getQuantity() {
    return mQuantity;
  }

  public void setQuantity(int quantity) {
    mQuantity = quantity;
  }

  public int getPrice() {
    return mPrice;
  }

  public void setPrice(int mPrice) {
    this.mPrice = mPrice;
  }
}