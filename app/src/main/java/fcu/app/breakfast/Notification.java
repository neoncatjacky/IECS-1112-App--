package fcu.app.breakfast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Notification extends AppCompatActivity {

  private TextView tvNotice1;
  private TextView tvNotice2;
  private Button btnReturnHome;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_notification);

    tvNotice1 = findViewById(R.id.tv_notice1);
    tvNotice2 = findViewById(R.id.tv_notice2);
    btnReturnHome = findViewById(R.id.btn_return_home);

    btnReturnHome.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), MainActivity.class);
        startActivityForResult(intent, 0);
      }
    });

  }
}