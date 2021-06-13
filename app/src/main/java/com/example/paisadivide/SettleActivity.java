package com.example.paisadivide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SettleActivity extends AppCompatActivity {

    TextView amount_owed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settle);

        amount_owed = findViewById(R.id.amount_owed);

        Intent intent = getIntent();

        String Name = intent.getStringExtra("Name");
        String Amount = intent.getStringExtra("Amount");

        amount_owed.setText("You Owed " + Name + " Rs." + Amount );

    }

    public void paymentSettled(View v) {
        amount_owed.setText("Payment Settled");
        amount_owed.setTextSize(24);
    }

    public void onBack(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}