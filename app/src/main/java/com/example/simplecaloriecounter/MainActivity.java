package com.example.simplecaloriecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Date;



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
                addHistory();

            }
        });

        settings_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "setting was press", Toast.LENGTH_SHORT).show();
            }
        });


    }

     void addHistory(){
         String foodName = input_food_name.getText().toString();
         String calories = input_calories.getText().toString();
         String fat = input_fat.getText().toString();
         String protein = input_protein.getText().toString();

         // Create a new LinearLayout for the log entry
         LinearLayout logEntryContainer = new LinearLayout(MainActivity.this);
         logEntryContainer.setOrientation(LinearLayout.HORIZONTAL);

         // Create a TextView for the log entry content
         TextView logEntry = new TextView(MainActivity.this);
         logEntry.setText(String.format(" Food: %s Cal: %s Fat: %s Protein: %s", foodName, calories, fat, protein));
         // Customize the appearance if desired

         // Create a TextView for the date
         TextView dateText = new TextView(MainActivity.this);
         SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
         dateText.setText(dateFormat.format(new Date())); // Get and format current date

         // Add views to the container LinearLayout
         logEntryContainer.addView(dateText);
         logEntryContainer.addView(logEntry);


         // Remove the bottom border
         // logEntryContainer.setBackgroundColor(Color.WHITE); // Uncomment if you want white background
         logEntryContainer.setPadding(16, 8, 16, 8); // Add some padding
         logEntryContainer.setBackground(null); // Set background to null to remove default border

         // Add the container to the log view
         log.addView(logEntryContainer);

         // Clear input fields for the next entry
         input_food_name.setText("");
         input_calories.setText("");
         input_fat.setText("");
         input_protein.setText("");
     }
}