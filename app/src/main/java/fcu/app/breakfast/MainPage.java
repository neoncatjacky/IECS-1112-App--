package fcu.app.breakfast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {

    private TextView tvRestaurantName;
    private ImageView ivRestaurantLogo;
    private Button btnStartOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartOrder = findViewById(R.id.btn_start_order);

        btnStartOrder.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ViewMenu.class);
                startActivityForResult(intent,0);
            }
        });
    }
}