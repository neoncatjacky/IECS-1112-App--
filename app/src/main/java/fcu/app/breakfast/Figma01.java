package fcu.app.breakfast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Figma01 extends AppCompatActivity {

  private TextView tvRestaurantName;
  private ImageView ivMainLogo;
  private Button btnStart;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_figma01);

    tvRestaurantName = findViewById(R.id.tv_restaurant_name);
    ivMainLogo = findViewById(R.id.iv_main_logo);
    btnStart = findViewById(R.id.btn_start);

    View.OnClickListener listener = new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        if(v.getId() == R.id.btn_start) {
          Intent intent = new Intent(Figma01.this, MainActivity.class);
          startActivity(intent);
        }
      }
    };
    btnStart.setOnClickListener(listener);
  }
}