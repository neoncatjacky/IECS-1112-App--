package fcu.app.breakfast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Checkout extends AppCompatActivity {


    private TextView tvCheckout;
    private TextView tvCashOnly;
    private Button btnFinishOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFinishOrder = findViewById(R.id.btn_start_order);

        btnFinishOrder.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ViewMenu.class);
                startActivityForResult(intent,0);
            }
        });
    }


    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        tvCheckout = findViewById(R.id.tv_checkout);
        tvCheckout = findViewById(R.id.tv_cash_only);
        btnFinishOrder = findViewById(R.id.btn_finish_order);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainPage.class);
                //Intent intent = new Intent(Checkout.this, MainPage.class);
                startActivity(intent);
            }
        };
        btnFinishOrder.setOnClickListener(onClickListener);
    }
    */
}