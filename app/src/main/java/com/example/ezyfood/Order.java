package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Order extends AppCompatActivity {
    public static final String list = "Menu";
    public String order;
    public String airMineral = "0", jusApel = "0", jusMangga = "0", jusAlpuk = "0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


        Intent i = getIntent();
        order = i.getStringExtra(Drinks.list);

        final TextView menuName = findViewById(R.id.textview);
        menuName.setText(order);
        airMineral = i.getStringExtra("jumlahair");
        jusApel = i.getStringExtra("jumlahapel");
        jusMangga = i.getStringExtra("jumlahmangga");
        jusAlpuk = i.getStringExtra("jumlahalpukat");

        Button b = findViewById(R.id.orderButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Order.this, Drinks.class);
                EditText et = findViewById(R.id.editText);
                String qty = et.getText().toString();
                Toast toast = Toast.makeText(getApplicationContext(), "Order Success", Toast.LENGTH_SHORT);
                toast.show();

                if (order.equals("Air Mineral")) {
                    i.putExtra("jumlahair", qty);
                    i.putExtra("jumlahapel", jusApel);
                    i.putExtra("jumlahmangga", jusMangga);
                    i.putExtra("jumlahalpukat", jusAlpuk);
                } else if (order.equals("Jus Apel")) {
                    i.putExtra("jumlahair", airMineral);
                    i.putExtra("jumlahapel", qty);
                    i.putExtra("jumlahmangga", jusMangga);
                    i.putExtra("jumlahalpukat", jusAlpuk);
                } else if (order.equals("Jus Mangga")) {
                    i.putExtra("jumlahair", airMineral);
                    i.putExtra("jumlahapel", jusApel);
                    i.putExtra("jumlahmangga", qty);
                    i.putExtra("jumlahalpukat", jusAlpuk);
                } else if (order.equals("Jus Alpukat")) {
                    i.putExtra("jumlahair", airMineral);
                    i.putExtra("jumlahapel", jusApel);
                    i.putExtra("jumlahmangga", jusMangga);
                    i.putExtra("jumlahalpukat", qty);
                }
                startActivity(i);
            }
        });
        Button orderM = findViewById(R.id.orderMore);
        orderM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Order.this, Drinks.class);
                startActivity(i);
            }
        });
        Button myOrder = findViewById(R.id.myOrder);
        myOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Order.this, myOrder.class);
                i.putExtra("airMineral", airMineral);
                i.putExtra("jusApel", jusApel);
                i.putExtra("jusMangga", jusMangga);
                i.putExtra("jusAlpukat", jusAlpuk);
                startActivity(i);
            }
        });
    }
}