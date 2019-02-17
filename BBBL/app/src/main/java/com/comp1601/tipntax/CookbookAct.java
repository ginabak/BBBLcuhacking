package com.comp1601.tipntax;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;

import java.io.Serializable;

public class CookbookAct extends AppCompatActivity {

    private LinearLayout linearLayout;
    private Button defaultButton;
    private Button addRecipeButton;

    private Intent in = getIntent();

    private Cookbook cookbook;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent dataIntent){
        this.in = dataIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.in = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookbook);

        linearLayout = findViewById(R.id.innerLayout);
        defaultButton = findViewById(R.id.defaultButton);
        addRecipeButton = findViewById(R.id.addRecipeButton);

        this.cookbook = (Cookbook) this.in.getSerializableExtra("cookbook");

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
            intent.putExtra("cookbook", this.cookbook);
            startActivityForResult(intent, 1);
        });
    }
}
