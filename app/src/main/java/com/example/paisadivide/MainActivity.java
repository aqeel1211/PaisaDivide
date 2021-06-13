package com.example.paisadivide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainAdapter.ManageTimeAdapterListen {

    RecyclerView rv;
    //Button add;


    List<Data> contacts;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        contacts = new ArrayList<>();

        contacts.add(new Data(R.drawable.ic_launcher_foreground, "Usama Rasheed" , "350"));
        contacts.add(new Data(R.drawable.ic_launcher_foreground, "Aqeel Ijaz" , "700"));


        rv = findViewById(R.id.rv);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        adapter = new MainAdapter(contacts, this);
        rv.setAdapter(adapter);
    }

    @Override
    public void onItemDeleteClick(Data deletItem) {

    }

    @Override
    public void onItemEditClick(Data editItem) {

    }

    public void addSplit(View v){
        Intent intent = new Intent(this, AddSplit.class);
        startActivity(intent);
    }
}