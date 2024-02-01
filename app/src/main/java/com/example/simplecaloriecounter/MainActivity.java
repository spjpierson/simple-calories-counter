package com.example.simplecaloriecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView settings_button;

    EditText input_food_name;
    EditText input_calories;
    EditText input_fat;

    EditText input_protein;

    Button enter_button;
    LinearLayout log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settings_button = findViewById(R.id.setting_image_view);

        input_food_name = findViewById(R.id.entry_food_name_edit_view);
        input_calories = findViewById(R.id.entry_calories_amout_edit_text);
        input_fat = findViewById(R.id.entry_fat_amout_edit_text);
        input_protein = findViewById(R.id.entry_protein_amout_edit_text);


        enter_button = findViewById(R.id.enter_button);

        log = findViewById(R.id.counter_linear_layout);

        enter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "food: " +input_food_name.getText().toString()+ " cal: " + input_calories.getText().toString()
                        + "fat: " + input_fat.getText().toString() + "protein:" +input_protein.getText().toString();
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });

        settings_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "setting was press", Toast.LENGTH_SHORT).show();
            }
        });


    }
}