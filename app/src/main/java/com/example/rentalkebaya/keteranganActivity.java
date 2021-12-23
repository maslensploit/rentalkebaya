package com.example.rentalkebaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class keteranganActivity extends AppCompatActivity {
    TextView namaa, kett;
    ImageView gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keterangan);

        Intent i = getIntent();
        String nama = i.getStringExtra("nama");
        int urlImage = i.getIntExtra("gambar",0);
        String ket = i.getStringExtra("keterangan");

        gambar = findViewById(R.id.imageKet);
        gambar.setImageResource(urlImage);
        kett = findViewById(R.id.ket);
        kett.setText(ket);
        namaa = findViewById(R.id.nama);
        namaa.setText(nama);
    }
}