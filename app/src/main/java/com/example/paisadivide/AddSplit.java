package com.example.paisadivide;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.chip.Chip;

public class AddSplit extends AppCompatActivity {

    EditText et_amount;
    EditText et_persons;
    EditText et_description;
    TextView perPerson;

    Chip chip1,chip2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_split);

        et_amount = findViewById(R.id.et_amount);
        et_persons = findViewById(R.id.et_persons);
        et_description = findViewById(R.id.et_description);
        perPerson = findViewById(R.id.perPerson);
        chip1 = findViewById(R.id.chip_1);
        chip2 = findViewById(R.id.chip_2);

//
        chip1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                chip1.setBackgroundColor(R.color.Dark_background);

            }
        });

        chip2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @SuppressLint("ResourceAsColor")
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                chip2.setBackgroundColor(R.color.Dark_background);
            }
        });

    }

    public void divideEqually(View v){
        int amount = Integer.parseInt(et_amount.getText().toString());
        int persons = Integer.parseInt(et_persons.getText().toString());

        perPerson.setText("Rs. " + amount/persons + "/per person");

    }

    public void onBack(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}