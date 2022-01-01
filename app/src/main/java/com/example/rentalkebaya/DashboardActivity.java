package com.example.rentalkebaya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    @SuppressLint("StaticFieldLeak")
    public static TextView totalHarga;
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        viewFlipper = findViewById(R.id.viewFlipper);
        int[] image = {
                R.drawable.atas2pdf,
                R.drawable.kebaya,
                R.drawable.kebaya2,
                R.drawable.kebaya3
        };
        for (int images : image) {
            viewFlipperr(images);
        }

        totalHarga = findViewById(R.id.totalHarga);
        totalHarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String harga = totalHarga.getText().toString();
                Intent i = new Intent(getApplicationContext(), detailActivity.class);
                i.putExtra("total", harga);
                startActivity(i);
            }
        });

        ArrayList<dagangan> list = new ArrayList<>();
        list.add(new dagangan(R.drawable.kebaya, "Kebaya putih berkat", "Kebaya Putih Berkat", 18000));
        list.add(new dagangan(R.drawable.kebaya2, "Kebaya putih aselole", "Kebaya Putih Polos", 20000));
        list.add(new dagangan(R.drawable.kebaya3, "Kebaya Putih Full Polos Hijab untuk Ijab Qobul", "Kebaya Putih Full Polos Hijab", 20000));
        list.add(new dagangan(R.drawable.kebaya4, "Kebaya Putih Buat Salaman Polos", "Kebaya Putih Salmanan Polos", 18000));


        AdapterDagangan adapter = new AdapterDagangan(this, list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);
    }

    private void viewFlipperr(int images) {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(images);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);
    }


    @Override
        public boolean onCreateOptionsMenu (Menu menu){
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return super.onCreateOptionsMenu(menu);
        }
        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            setMode(item.getItemId());
            return super.onOptionsItemSelected(item);
        }
        public void setMode ( int selectedMode){
            switch (selectedMode) {
                case R.id.action_call:
                    String phone = "+6285211000002";
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                    startActivity(intent);
                    break;
                case R.id.action_sms:
                    Uri uri = Uri.parse("smsto:08511000002");
                    Intent it = new Intent(Intent.ACTION_SENDTO, uri);
                    it.putExtra("sms_body", "Hallo kak, saya ......");
                    startActivity(it);
                    break;
                case R.id.action_maps:
                    Intent intentt = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse("https://www.google.com/maps/place/Ayam+Geprek+Prasmanan+Pak+Yadi/@-7.1882208,110.4562348,11z/data=!4m8!1m2!2m1!1sAyam+geprek+pak!3m4!1s0x2e7085fac947a6c1:0xdb53b37758ed23f4!8m2!3d-7.1797063!4d110.4300977"));
                    startActivity(intentt);
                    break;
                case R.id.action_update:
                    Preferences.clearAll(getBaseContext());
                    Intent i = new Intent(DashboardActivity.this, registerActivity.class);
                    startActivity(i);
                    break;
                case R.id.action_logout:
                    Preferences.clearAll(getBaseContext());
                    startActivity(new Intent(getBaseContext(), loginActivity.class));
                    finish();
                    break;

                case R.id.action_logoutGoogle:
                    Preferences.clearAll(getBaseContext());
                    Intent is = new Intent(DashboardActivity.this, GoogleActivity.class);
                    startActivity(is);
                    break;

            }
    }
}