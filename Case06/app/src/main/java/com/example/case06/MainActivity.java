package com.example.case06;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    // Thumbnail
    Spinner spnThumbnail;
    ThumbnailAdapter thumbnailAdapter;
    ArrayList<Thumbnail> thumbnails;

    // Dish
    EditText edtName;
    CheckBox cbISPromotion;
    Button btnAdd;
    GridView gvDishes;
    DishAdapter dishAdapter;
    ArrayList<Dish> dishes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Thumbnail
        thumbnails = new ArrayList<>();
        Collections.addAll(thumbnails, Thumbnail.values());
        thumbnailAdapter = new ThumbnailAdapter(this, R.layout.item_thumbnail, thumbnails);
        spnThumbnail = findViewById(R.id.spnThumbnail);
        spnThumbnail.setAdapter(thumbnailAdapter);

        // Dish
        dishes = new ArrayList<>();
        dishAdapter = new DishAdapter(this, R.layout.item_dish, dishes);
        gvDishes = findViewById(R.id.gvDishes);
        gvDishes.setAdapter(dishAdapter);

        edtName = findViewById(R.id.edtName);
        cbISPromotion = findViewById(R.id.cbIsPromotion);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dishes.add(new Dish(
                        edtName.getText().toString(),
                        (Thumbnail) spnThumbnail.getSelectedItem(),
                        cbISPromotion.isChecked()
                ));

                dishAdapter.notifyDataSetChanged();

                edtName.setText("");
                spnThumbnail.setSelection(0);
                cbISPromotion.setActivated(false);

                Toast.makeText(MainActivity.this, "Added successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}