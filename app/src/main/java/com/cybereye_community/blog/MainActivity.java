package com.cybereye_community.blog;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView judul1, tgl1, pengarang1, harga1, judul2, tgl2, pengarang2, harga2;

    Button tombol1, tombol2;



    private String jud1, peng1, hargaA, jud2, peng2, hargaB;

    int har1, har2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        judul1 = (TextView)findViewById(R.id.judul_1);
        tgl1 = (TextView)findViewById(R.id.tgl_1);
        pengarang1 = (TextView)findViewById(R.id.pengarang_1);
        harga1 = (TextView)findViewById(R.id.harga_1);

        judul2 = (TextView)findViewById(R.id.judul_2);
        tgl2 = (TextView)findViewById(R.id.tgl_2);
        pengarang2 = (TextView)findViewById(R.id.pengarang_2);
        harga2 = (TextView)findViewById(R.id.harga_2);



        tombol1 = (Button)findViewById(R.id.beli1);
        tombol1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jud1 = judul1.getText().toString();
                peng1 = pengarang1.getText().toString();
                hargaA = harga1.getText().toString();

                har1 = Integer.parseInt(hargaA);

                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                i.putExtra("judul", jud1);
                i.putExtra("pengarang", peng1);
                i.putExtra("harga", har1);
                startActivity(i);

            }
        });

        tombol2 = (Button)findViewById(R.id.beli2);
        tombol2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jud2 = judul2.getText().toString();
                peng2 = pengarang2.getText().toString();
                hargaB = harga2.getText().toString();

                har2 = Integer.parseInt(hargaB);

                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                i.putExtra("judul", jud2);
                i.putExtra("pengarang", peng2);
                i.putExtra("harga", har2);
                startActivity(i);
            }
        });
    }
}
