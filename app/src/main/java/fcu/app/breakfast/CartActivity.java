package fcu.app.breakfast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CartActivity extends AppCompatActivity {

  private Button btnCheckout;


  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.cart_activity);

    btnCheckout = findViewById(R.id.btn_checkout);

    btnCheckout.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
          Intent intent = new Intent(v.getContext(), Checkout.class);
          startActivityForResult(intent,0);
        }
    });

  }
}