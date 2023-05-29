package fcu.app.breakfast;

import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProductDetailsActivity extends Activity {

  private List<Product> mCartList;
  private ProductAdapter mProductAdapter;



  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.product_details);

    mCartList = ShoppingCartHelper.getCartList();
    mProductAdapter = new ProductAdapter(mCartList, getLayoutInflater(), true,true,true);
    List<Product> catalog = ShoppingCartHelper.getMainCatalog(getResources());
    int productIndex = getIntent().getExtras().getInt(ShoppingCartHelper.PRODUCT_INDEX1);
    final List<Product> cart = ShoppingCartHelper.getCartList();
    int fragId = getIntent().getExtras().getInt("fragId");
    Product temp = catalog.get(productIndex);
    if(fragId == 1)
    {
      catalog = ShoppingCartHelper.getMainCatalog(getResources());
      productIndex = getIntent().getExtras().getInt(ShoppingCartHelper.PRODUCT_INDEX1);
      temp = catalog.get(productIndex);
    }
    else if(fragId == 2)
    {
      catalog = ShoppingCartHelper.getDrinkCatalog(getResources());
      productIndex = getIntent().getExtras().getInt(ShoppingCartHelper.PRODUCT_INDEX2);
      temp = catalog.get(productIndex);
    }
    else if(fragId == 3)
    {
      catalog = ShoppingCartHelper.getDessertCatalog(getResources());
      productIndex = getIntent().getExtras().getInt(ShoppingCartHelper.PRODUCT_INDEX3);
      temp = catalog.get(productIndex);
    }

    final Product selectedProduct = temp;
    // Set the proper image and text
    ImageView productImageView = (ImageView) findViewById(R.id.ImageViewProduct);
    productImageView.setImageDrawable(selectedProduct.productImage);
    TextView productTitleTextView = (TextView) findViewById(R.id.TextViewProductTitle);
    productTitleTextView.setText(selectedProduct.title);
    TextView productDetailsTextView = (TextView) findViewById(R.id.TextViewProductDetails);
    productDetailsTextView.setText(selectedProduct.description);
    TextView productPriceTextView = (TextView) findViewById(R.id.TextViewProductPrice);
    productPriceTextView.setText("價格: " + selectedProduct.price);

    // Update the current quantity in the cart
    TextView textViewCurrentQuantity = (TextView) findViewById(R.id.textViewCurrentlyInCart);
    textViewCurrentQuantity.setText("購物車內目前有: "
      + ShoppingCartHelper.getProductQuantity(selectedProduct) + "個");

    // Save a reference to the quantity edit text
    final EditText editTextQuantity = (EditText) findViewById(R.id.editTextQuantity);

    Button addToCartButton = (Button) findViewById(R.id.ButtonAddToCart);
    addToCartButton.setOnClickListener(new OnClickListener() {

      @Override
      public void onClick(View v) {

        // Check to see that a valid quantity was entered
        int quantity = 0;
        try {
          quantity = Integer.parseInt(editTextQuantity.getText()
            .toString());

          if (quantity < 0) {
            Toast.makeText(getBaseContext(),
              "Please enter a quantity of 0 or higher",
              Toast.LENGTH_SHORT).show();
            return;
          }

        } catch (Exception e) {
          Toast.makeText(getBaseContext(),
            "Please enter a numeric quantity",
            Toast.LENGTH_SHORT).show();

          return;
        }

        // If we make it here, a valid quantity was entered
        ShoppingCartHelper.setQuantity(selectedProduct, quantity);

        if(quantity == 0)
        {
          for(int i = mCartList.size()-1; i>=0; i--) {

          if(mCartList.get(i).getMeal_id() == selectedProduct.getMeal_id()) {
            mCartList.remove(i);
          }
        }
        mProductAdapter.notifyDataSetChanged();
        }
        // Close the activity
        finish();
      }
    });

  }



}