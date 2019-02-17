package com.comp1601.tipntax;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    private EditText nameInput;
    private Button mEnterNameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEnterNameButton = findViewById(R.id.enter_button);
        nameInput = findViewById(R.id.name_prompt);

        mEnterNameButton.setOnClickListener(v -> {

            if(!nameInput.getText().toString().equals("")){
                Intent i = new Intent(MainActivity.this, OptionMenu.class);
                i.putExtra("un", nameInput.getText().toString());
                startActivity(i);
            }else{
                nameInput.setHint("Please input your name");
                nameInput.setHintTextColor(Color.RED);
            }
        });





    }
}