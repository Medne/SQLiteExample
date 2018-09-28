package com.example.medine.ogrencikayt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class Liste extends AppCompatActivity {


    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        listView=(ListView)findViewById(R.id.veriler);


        Database veritabanı=new Database(Liste.this);
        List<String> vVeriler =veritabanı.veriListele();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, vVeriler);

        listView.setAdapter(adapter);


    }
}
