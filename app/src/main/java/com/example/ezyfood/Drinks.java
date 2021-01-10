package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Drinks extends AppCompatActivity implements View.OnClickListener{
    public static final String list= "Menu";
    public CardView cardAir, cardApel, cardMangga, cardAlpukat;
    public String airMineral = "0", jusApel = "0", jusMangga = "0", jusAlpuk = "0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
        cardAir = (CardView) findViewById(R.id.airmineral);
        cardAir.setOnClickListener(this);
        cardApel = (CardView) findViewById(R.id.jusApel);
        cardApel.setOnClickListener(this);
        cardMangga = (CardView) findViewById(R.id.jusMangga);
        cardMangga.setOnClickListener(this);
        cardAlpukat = (CardView) findViewById(R.id.jusAlpukat);
        cardAlpukat.setOnClickListener(this);

        Intent dataInput = getIntent();
        airMineral = dataInput.getStringExtra("jumlahair");
        jusApel = dataInput.getStringExtra("jumlahapel");
        jusMangga = dataInput.getStringExtra("jumlahmangga");
        jusAlpuk = dataInput.getStringExtra("jumlahalpukat");
    }


    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.airmineral :
                i = new Intent(this, Order.class);
                i.putExtra(list, "Air Mineral");
                i.putExtra("jumlahair", airMineral);
                i.putExtra("jumlahapel", jusApel);
                i.putExtra("jumlahmangga", jusMangga);
                i.putExtra("jumlahalpukat", jusAlpuk);
                startActivity(i);
                break;
        }
        switch (v.getId()){
            case R.id.jusApel :
                i = new Intent(this, Order.class);
                i.putExtra(list, "Jus Apel");
                i.putExtra("jumlahair", airMineral);
                i.putExtra("jumlahapel", jusApel);
                i.putExtra("jumlahmangga", jusMangga);
                i.putExtra("jumlahalpukat", jusAlpuk);
                startActivity(i);
                break;
        }
        switch (v.getId()){
            case R.id.jusMangga :
                i = new Intent(this, Order.class);
                i.putExtra(list, "Jus Mangga");
                i.putExtra("jumlahair", airMineral);
                i.putExtra("jumlahapel", jusApel);
                i.putExtra("jumlahmangga", jusMangga);
                i.putExtra("jumlahalpukat", jusAlpuk);
                startActivity(i);
                break;
        }
        switch (v.getId()){
            case R.id.jusAlpukat :
                i = new Intent(this, Order.class);
                i.putExtra(list, "Jus Alpukat");
                i.putExtra("jumlahair", airMineral);
                i.putExtra("jumlahapel", jusApel);
                i.putExtra("jumlahmangga", jusMangga);
                i.putExtra("jumlahalpukat", jusAlpuk);
                startActivity(i);
                break;
        }
        Button myOrder = findViewById(R.id.myOrder);
        myOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewMyOrder(v);
            }
        });
    }
    public void viewMyOrder(View v){
        Intent i = new Intent(this, myOrder.class);
        i.putExtra("airMineral", airMineral);
        i.putExtra("jusApel", jusApel);
        i.putExtra("jusMangga", jusMangga);
        i.putExtra("jusAlpukat", jusAlpuk);
        startActivity(i);
    }
    public void sendData(View v, String data){
        String order = data;
        Intent intent = new Intent(this, Order.class);
        intent.putExtra(list, order);
        startActivity(intent);
    }

}