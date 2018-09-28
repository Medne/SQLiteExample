package com.example.medine.ogrencikayt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView adSoyad,email,adres;
    Button btnKayit,btnListele;





    public void init(){
        adSoyad=(EditText)findViewById(R.id.etAdSoyad);
        email=(EditText)findViewById(R.id.etMail);
        adres=(EditText)findViewById(R.id.etAdres);
        btnKayit=(Button)findViewById(R.id.BTnKAyit);
        btnListele=(Button)findViewById(R.id.BtnListele);


    }



    public void btn_Click(){
        btnKayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db =new Database(MainActivity.this);
                db.ogrenciEkle(adSoyad.getText().toString(),email.getText().toString(),adres.getText().toString());

            }
        });

        btnListele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),Liste.class);
                startActivity(intent);






            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        btn_Click();




    }





}