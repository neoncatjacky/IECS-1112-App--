package fcu.app.breakfast;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView restaurantImageView;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        restaurantImageView = findViewById(R.id.iv_restaurant_image);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_restaurant_list);
    }
}