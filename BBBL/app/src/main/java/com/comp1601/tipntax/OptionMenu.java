package com.comp1601.tipntax;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class OptionMenu extends AppCompatActivity {

    private Button cookbookButton;
    private Button pantryButton;
    private Button mealplanButton;

    private Cookbook cookbook = new Cookbook();

    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu);

        title = findViewById(R.id.Title);

        cookbookButton = findViewById(R.id.cookbookButton);
        pantryButton   = findViewById(R.id.pantryButton);
        mealplanButton = findViewById(R.id.mealplanButton);

        title.setText("Hi, " + getIntent().getStringExtra("un") + " where are we going?");

        cookbookButton.setOnClickListener(v -> {
            Intent intent = new Intent(OptionMenu.this, CookbookAct.class);
            intent.putExtra("cookbook", this.cookbook);
            startActivity(intent);
        });
        pantryButton.setOnClickListener(v -> {
            Intent intent = new Intent(OptionMenu.this, PantryAct.class);
            startActivity(intent);
        });
        mealplanButton.setOnClickListener(v -> {
            Intent intent = new Intent(OptionMenu.this, MealplanAct.class);
            startActivity(intent);
        });
    }
}
