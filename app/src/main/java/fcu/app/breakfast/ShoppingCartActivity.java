package fcu.app.breakfast;

import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class ShoppingCartActivity extends Activity {

  private List<Product> mCartList;
  private ProductAdapter mProductAdapter;
  private Button checkout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.cart_activity);

    if(mProductAdapter != null) {
      mProductAdapter.notifyDataSetChanged();
    }


    mCartList = ShoppingCartHelper.getCartList();
    checkout = findViewById(R.id.btn_checkout);

    // Make sure to clear the selections
    for(int i=0; i<mCartList.size(); i++) {
      mCartList.get(i).selected = false;
    }

    // Create the list
    final ListView listViewCatalog = (ListView) findViewById(R.id.lv_final_catalog);
    mProductAdapter = new ProductAdapter(mCartList, getLayoutInflater(), true,true,true);
    listViewCatalog.setAdapter(mProductAdapter);

    listViewCatalog.setOnItemClickListener(new OnItemClickListener() {

      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position,
                              long id) {

        int mealId = mCartList.get(position).getMeal_id();

        Intent productDetailsIntent = new Intent(getBaseContext(),ProductDetailsActivity.class);

        if(mealId == 1 || mealId == 2 || mealId == 3)
        {
          if(mealId % 3 == 0)
          {
            productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX1, 2);
            productDetailsIntent.putExtra("fragId", 1);
          }
          else if(mealId % 3 == 1)
          {
            productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX1, 0);
            productDetailsIntent.putExtra("fragId", 1);
          }
          else if(mealId % 3 == 2)
          {
            productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX1, 1);
            productDetailsIntent.putExtra("fragId", 1);
          }
        }
        else if(mealId == 4 || mealId == 5 || mealId == 6)
        {
          if(mealId % 3 == 0)
          {
            productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX2, 2);
            productDetailsIntent.putExtra("fragId", 2);
          }
          else if(mealId % 3 == 1)
          {
            productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX2, 0);
            productDetailsIntent.putExtra("fragId", 2);
          }
          else if(mealId % 3 == 2)
          {
            productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX2, 1);
            productDetailsIntent.putExtra("fragId", 2);
          }
        }
        else if(mealId == 7 || mealId == 8 || mealId == 9)
        {
          if(mealId % 3 == 0)
          {
            productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX3, 2);
            productDetailsIntent.putExtra("fragId", 3);
          }
          else if(mealId % 3 == 1)
          {
            productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX3, 0);
            productDetailsIntent.putExtra("fragId", 3);
          }
          else if(mealId % 3 == 2)
          {
            productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX3, 1);
            productDetailsIntent.putExtra("fragId", 3);
          }
        }
        startActivity(productDetailsIntent);

      }
    });

    checkout.setOnClickListener(new OnClickListener() {
      public void onClick(View v) {

        int subTotal = 0;
        for(Product p : mCartList) {
          int quantity = ShoppingCartHelper.getProductQuantity(p);
          subTotal += p.price * quantity;
        }
        Intent intent = new Intent(v.getContext(), Checkout.class);
        intent.putExtra("finaltotalprice", subTotal);
        startActivityForResult(intent,0);
      }
    });

    //Button removeButton = (Button) findViewById(R.id.btn_remove);
//    removeButton.setOnClickListener(new OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        // Loop through and remove all the products that are selected
//        // Loop backwards so that the remove works correctly
//        for(int i=mCartList.size()-1; i>=0; i--) {
//
//          if(mCartList.get(i).selected) {
//            mCartList.remove(i);
//          }
//        }
//        mProductAdapter.notifyDataSetChanged();
//      }
//    });

  }
  @Override
  protected void onResume() {
    super.onResume();

    // Refresh the data
    if(mProductAdapter != null) {
      mProductAdapter.notifyDataSetChanged();
    }

    int subTotal = 0;
    for(Product p : mCartList) {
      int quantity = ShoppingCartHelper.getProductQuantity(p);
      subTotal += p.price * quantity;
    }

    TextView productPriceTextView = (TextView) findViewById(R.id.TextViewSubtotal);
    productPriceTextView.setText("總金額: $" + subTotal);
  }

}