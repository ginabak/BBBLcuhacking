package com.comp1601.tipntax;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;

public class CookbookAct extends AppCompatActivity {

    private LinearLayout linearLayout;
    private Button defaultButton;
    private Button addRecipeButton;

    private Cookbook cookbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookbook);

        linearLayout = findViewById(R.id.innerLayout);
        defaultButton = findViewById(R.id.defaultButton);

        this.cookbook = (Cookbook) getIntent().getSerializableExtra("cookbook");

        if (this.cookbook.getRecipes().length!=0){
            linearLayout.removeAllViews();
            for (int i = 0; i<this.cookbook.getRecipes().length; i++) {
                Button b = new Button(CookbookAct.this);
                b.setText(cookbook.getRecipes()[i].getName());
                b.setLayoutParams(defaultButton.getLayoutParams());
                b.setHint("" + i);
                b.setOnClickListener(v -> {
                    Intent intent = new Intent(CookbookAct.this, RecipeDisplayAct.class);
                    intent.putExtra("title", b.getText());
                    intent.putExtra("ing", b.getHint());
                    intent.putExtra("cookbook", this.cookbook);
                    startActivity(intent);
                });
                linearLayout.addView(b);
            }
        }

        addRecipeButton.setOnClickListener(v -> {
            Intent intent = new Intent(CookbookAct.this, RecipeForm.class);
            startActivity(intent);
        });
    }
}
