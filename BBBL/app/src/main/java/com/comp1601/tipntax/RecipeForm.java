package com.comp1601.tipntax;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import static java.lang.Double.NaN;

public class RecipeForm extends AppCompatActivity {

    private EditText nameField;
    private EditText caloriesField;

    private Button doneButton;
    private LinearLayout linearLayout;
    private EditText defaultIngField;
    private Button addIngButton;

    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("Recepie form creating");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_form);

        nameField = findViewById(R.id.nameField);

        linearLayout = findViewById(R.id.scrollView);
        defaultIngField = findViewById(R.id.IngredientsField);

        addIngButton = findViewById(R.id.addIngField);
        addIngButton.setOnClickListener(v -> {
            EditText e = new EditText(RecipeForm.this);
            e.setHint("ingredient...");
            e.setLayoutParams(defaultIngField.getLayoutParams());
            linearLayout.addView(e);
        });

        caloriesField = findViewById(R.id.caloriesField);

        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(v -> {

            boolean flag = false;
            boolean flag2 = false;
            boolean flag3 = false;

            Ingredient[] ingredients = new Ingredient[0];

            if (nameField.getText().toString().equals("")){
                flag = true;
            }
            flag2 = true;
            for (int i = 0; i<linearLayout.getChildCount(); i++){
                if (!((EditText) linearLayout.getChildAt(i)).getText().toString().equals("")){
                    flag2 = false;
                    String[] s = ((EditText) linearLayout.getChildAt(i)).getText().toString().split(",");
                    Ingredient[] temp = new Ingredient[ingredients.length+1];
                    for (int j = 0; j<ingredients.length; j++){
                        temp[j] = ingredients[j];
                    }
                    temp[temp.length-1] = new Ingredient(s[0], Integer.parseInt(s[1]));
                    ingredients = temp;
                }
            }
            if (caloriesField.getText().toString().equals("")){
                flag3 = true;
            }

            if (!(flag || flag2 || flag3)){

                Recipe newRecipe = new Recipe(nameField.getText().toString(), ingredients, Integer.parseInt(caloriesField.getText().toString()));

                Cookbook newCookbook = (Cookbook) getIntent().getSerializableExtra("cookbook");

                newCookbook.addRecipe(newRecipe);

                Intent intent = getIntent();
                intent.putExtra("cookbook", newCookbook);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}