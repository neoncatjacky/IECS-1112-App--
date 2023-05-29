package fcu.app.breakfast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Notification extends AppCompatActivity {

  private TextView tvNotice1;
  private TextView tvNotice2;
  private Button btnReturnHome;
  private List<Product> mCartList;
  private ProductAdapter mProductAdapter;
  private TextView tvTotalPrice;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_notification);

    tvNotice1 = findViewById(R.id.tv_notice1);
    tvNotice2 = findViewById(R.id.tv_notice2);
    btnReturnHome = findViewById(R.id.btn_return_home);
    tvTotalPrice = findViewById(R.id.tv_final_price);
    mCartList = ShoppingCartHelper.getCartList();
    for(int i=0; i<mCartList.size(); i++) {
      mCartList.get(i).selected = false;
    }

    final ListView listViewCatalog = (ListView) findViewById(R.id.lv_final_catalog);
    mProductAdapter = new ProductAdapter(mCartList, getLayoutInflater(), true,true,true);
    listViewCatalog.setAdapter(mProductAdapter);

    Intent mIntent = getIntent();
    tvTotalPrice.setText("總金額: " + mIntent.getIntExtra("finaltotalprice", 0));

    btnReturnHome.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), MainActivity.class);
        startActivityForResult(intent, 0);
      }
    });

  }
}