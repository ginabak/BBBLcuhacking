package com.comp1601.tipntax;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RecipeDisplayAct extends AppCompatActivity {

    private TextView title;

    private LinearLayout linearLayout;
    private TextView defaultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_display);

        title = findViewById(R.id.title);

        title.setText(getIntent().getStringExtra("title"));

        linearLayout = findViewById(R.id.innerLayout);
        defaultText = findViewById(R.id.defaultIngredient);

        Cookbook cookbook = (Cookbook) getIntent().getSerializableExtra("cookbook");
        int i = Integer.parseInt(getIntent().getStringExtra("ing"));

        if (cookbook.getRecipes()[i].getIngredients().length!=0) {
            linearLayout.removeAllViews();
            for (Ingredient ing : cookbook.getRecipes()[i].getIngredients()) {
                TextView t = new TextView(RecipeDisplayAct.this);
                t.setText(ing.getQty() + " arbitrary units of " + ing.getName());
                t.setLayoutParams(defaultText.getLayoutParams());
                linearLayout.addView(t);
            }
        }
    }
}
