package fcu.app.breakfast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewMenuActivity extends AppCompatActivity {

  private Button btnFood1;
  private Button btnFood2;
  private Button btnFood3;
  private Button btnCheckCart;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_view_menu);
    btnFood1 = findViewById(R.id.btn_food1);
    btnFood2 = findViewById(R.id.btn_food2);
    btnFood3 = findViewById(R.id.btn_food3);
    btnCheckCart = findViewById(R.id.btn_checkcart);

    View.OnClickListener btnListener = new View.OnClickListener() {
      String message = "3項球類中最喜歡的是";
      @Override
      public void onClick(View v) {
        if(v.getId() == R.id.btn_food1)
        {
          message += " 棒球";
        }
        else if(v.getId() == R.id.btn_food2)
        {
          message += " 棒球";
        }
        else if(v.getId() == R.id.btn_food3)
        {
          message += " 棒球";
        }
          else if(v.getId() == R.id.btn_checkcart)
        {
          message += " 棒球";
        }
      }
    };
    btnFood1.setOnClickListener(btnListener);
    btnFood2.setOnClickListener(btnListener);
    btnFood3.setOnClickListener(btnListener);
    btnCheckCart.setOnClickListener(btnListener);
  }
}