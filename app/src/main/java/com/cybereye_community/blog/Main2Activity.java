package com.cybereye_community.blog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    TextView judulB, pengarangB, hargaB, quan, totalPrice, totalKirim, total_Semua;

    RadioButton jnee, tikii, ninjaa;

    private String judulL, pengarangG;

    int hargaA, total, harkirim, totalSem;

    int quantity = 0;

    Button plus, minus, submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        jnee = (RadioButton) findViewById(R.id.jne);
        tikii = (RadioButton)findViewById(R.id.tiki);
        ninjaa = (RadioButton)findViewById(R.id.ninja);

        jnee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jnee.isChecked()){
                    harkirim = 15000;
                    totalKirim.setText("Harga Pengiriman : Rp. "+harkirim);
                }
            }
        });

        tikii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tikii.isChecked()){
                    harkirim = 8000;
                    totalKirim.setText("Harga Pengiriman : Rp. "+harkirim);
                }
            }
        });

        ninjaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ninjaa.isChecked()){
                    harkirim = 10500;
                    totalKirim.setText("Harga Pengiriman : Rp. "+harkirim);
                }
            }
        });
        quan = (TextView)findViewById(R.id.qty);
        totalPrice = (TextView)findViewById(R.id.total);

        totalKirim = (TextView)findViewById(R.id.totalPengiriman);
        total_Semua = (TextView)findViewById(R.id.totalSemua);

        judulB = (TextView)findViewById(R.id.judul);
        pengarangB = (TextView)findViewById(R.id.pengarang);
        hargaB = (TextView)findViewById(R.id.harga);

        judulL = getIntent().getStringExtra("judul");
        pengarangG = getIntent().getStringExtra("pengarang");
        hargaA = getIntent().getIntExtra("harga",0);

        judulB.setText("Judul Buku: "+judulL);
        pengarangB.setText("Pengarang: "+pengarangG);
        hargaB.setText("Harga: Rp. "+hargaA);

        plus = (Button)findViewById(R.id.tambah);
        minus = (Button)findViewById(R.id.kurang);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity >= 10){
                    Toast.makeText(getApplicationContext(), "Maaf Produk tidak bisa lebih dari 10",
                            Toast.LENGTH_SHORT).show();
                }else{

                    quantity = quantity + 1;
                    quan.setText(""+quantity);
                    total = quantity * hargaA;
                    totalPrice.setText("Harga Barang : Rp. "+total);


                }


            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity <= 0){
                    Toast.makeText(getApplicationContext(), "Quantity tidak bisa kurang dari 0",
                            Toast.LENGTH_SHORT).show();

                }else{

                    quantity = quantity - 1;
                    quan.setText(""+quantity);
                    total = quantity * hargaA;
                    totalPrice.setText("Harga Barang : Rp. "+total);

                }

            }
        });

        submit = (Button)findViewById(R.id.order);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalSem = total + harkirim;
                total_Semua.setText("Total Harga : Rp. "+totalSem);
            }
        });



    }
}
