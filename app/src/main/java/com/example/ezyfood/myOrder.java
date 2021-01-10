package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class myOrder extends AppCompatActivity {
    public String dataAir, dataApel, dataMangga, dataAlpuk;
    public int QtyAir, QtyApel, QtyMangga, QtyAlpukat,  totalprice,grandtotal;
    public String removeair, removeapell, removemangga, removealpukat;

    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        Intent i = getIntent();
        String menu;
        TextView tv = findViewById(R.id.qtyair);
        dataAir = i.getStringExtra("airMineral");
        if (dataAir != null){
            QtyAir = Integer.parseInt(dataAir);
            QtyAir = QtyAir * 5000;
            tv.setText(dataAir);
        }else{
            tv.setText("0");
        }

        TextView tv2 = findViewById(R.id.qtyapel);
        dataApel = i.getStringExtra("jusApel");
        if (dataApel != null){
            QtyApel = Integer.parseInt(dataApel);
            QtyApel = QtyApel * 12000;
            tv2.setText(dataApel);
        }else{
            tv2.setText("0");
        }

        TextView tv3 = findViewById(R.id.qtymangga);
        dataMangga = i.getStringExtra("jusMangga");
        if (dataMangga != null){
            QtyMangga = Integer.parseInt(dataMangga);
            QtyMangga = QtyMangga * 15000;
            tv3.setText(dataMangga);
        }else{
            tv3.setText("0");
        }

        TextView tv4 = findViewById(R.id.qtyalpu);
        dataAlpuk = i.getStringExtra("jusAlpukat");
        if(dataAlpuk != null){
            QtyAlpukat = Integer.parseInt(dataAlpuk);
            QtyAlpukat = QtyAlpukat * 13000;
            tv4.setText(dataAlpuk);
        }else{
            tv4.setText("0");
        }
        TextView tv5 = findViewById(R.id.tPrice);
        totalprice = QtyAir+QtyApel+QtyMangga+QtyAlpukat;
        grandtotal = totalprice;
        tv5.setText("" +grandtotal);

        Button payNow = findViewById(R.id.buttonPay);
        payNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payNow();
            }
        });

    }
        public void removeaer (View v){
            Intent i = new Intent(this, myOrder.class);
            dataAir = getIntent().getStringExtra("airMineral");
            dataApel = getIntent().getStringExtra("jusApel");
            dataMangga = getIntent().getStringExtra("jusMangga");
            dataAlpuk = getIntent().getStringExtra("jusAlpukat");

            QtyAir = 0;
            removeair = String.valueOf(QtyAir);

            i.putExtra("airMineral", removeair);
            i.putExtra("jusApel", dataApel );
            i.putExtra("jusMangga", dataMangga);
            i.putExtra("jusAlpukat", dataAlpuk);
            startActivity(i);

        }
        public void removeApel (View v){
            Intent i = new Intent(this, myOrder.class);
            dataAir = getIntent().getStringExtra("airMineral");
            dataApel = getIntent().getStringExtra("jusApel");
            dataMangga = getIntent().getStringExtra("jusMangga");
            dataAlpuk = getIntent().getStringExtra("jusAlpukat");

            QtyApel = 0;
            removeapell = String.valueOf(QtyApel);

            i.putExtra("airMineral", dataAir);
            i.putExtra("jusApel", removeapell );
            i.putExtra("jusMangga", dataMangga);
            i.putExtra("jusAlpukat", dataAlpuk);
            startActivity(i);
        }

        public void removeMangga (View v){
        Intent i = new Intent(this, myOrder.class);
        dataAir = getIntent().getStringExtra("airMineral");
        dataApel = getIntent().getStringExtra("jusApel");
        dataMangga = getIntent().getStringExtra("jusMangga");
        dataAlpuk = getIntent().getStringExtra("jusAlpukat");

        QtyMangga = 0;
        removemangga = String.valueOf(QtyMangga);

        i.putExtra("airMineral", dataAir);
        i.putExtra("jusApel", dataApel);
        i.putExtra("jusMangga", removemangga);
        i.putExtra("jusAlpukat", dataAlpuk);
        startActivity(i);
    }

        public void removeAlpukat (View v){
        Intent i = new Intent(this, myOrder.class);
        dataAir = getIntent().getStringExtra("airMineral");
        dataApel = getIntent().getStringExtra("jusApel");
        dataMangga = getIntent().getStringExtra("jusMangga");
        dataAlpuk = getIntent().getStringExtra("jusAlpukat");

        QtyAlpukat = 0;
        removealpukat = String.valueOf(QtyAlpukat);

        i.putExtra("airMineral", dataAir);
        i.putExtra("jusApel", dataApel);
        i.putExtra("jusMangga", dataMangga);
        i.putExtra("jusAlpukat", removealpukat);
        startActivity(i);
    }

    public void payNow (){
        Intent i = new Intent(this, Pay.class);
        i.putExtra("airpay", QtyAir);
        i.putExtra("apelpay", QtyApel);
        i.putExtra("manggapay", QtyMangga);
        i.putExtra("alpupay", QtyAlpukat);
        startActivity(i);
    }

}



