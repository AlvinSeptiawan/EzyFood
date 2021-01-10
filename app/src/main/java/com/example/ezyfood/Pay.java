package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pay extends AppCompatActivity {
    public String airPay, dataApel, dataMangga, dataAlpuk;
    public int QtyAir, QtyApel, QtyMangga, QtyAlpukat, totalprice, grandtotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);


        TextView tv5 = findViewById(R.id.tPrice);
        totalprice = QtyAir+QtyApel+QtyMangga+QtyAlpukat;
        grandtotal = totalprice;
        tv5.setText("" +grandtotal);

        Button home = findViewById(R.id.homeB);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Pay.this, MainActivity.class);
                startActivity(i);
            }
        });
    }


}