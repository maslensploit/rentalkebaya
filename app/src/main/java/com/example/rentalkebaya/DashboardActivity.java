package com.example.rentalkebaya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);




       /* viewFlipper = findViewById(R.id.viewFlipper);
        int[] image = {
                R.drawable.,
                R.drawable.a2,
                R.drawable.a3
        };
        for (int images : image) {
            viewFlipperr(images);
        }*/

        /*totalHarga = findViewById(R.id.totalHarga);
        totalHarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String harga = totalHarga.getText().toString();
                Intent i = new Intent(getApplicationContext(), detailActivity.class);
                i.putExtra("total", harga);
                startActivity(i);
            }
        });*/

        ArrayList<dagangan> list = new ArrayList<>();
        list.add(new dagangan(R.drawable.kebaya, "Ayam Geprek dengan balutan Keju Mozarella yang nikmat", "Ayam Geprek Mozarella Tanpa Nasi", 18000));
        list.add(new dagangan(R.drawable.kebaya2, "Ayam Geprek dengan balutan Keju Mozarella yang nikmat dan ditambah nasi untuk kenyang maksimal", "Ayam Geprek Mozarella dan Nasi", 20000));
        list.add(new dagangan(R.drawable.kebaya3, "Ayam Geprek dengan Sambal yang terpisah cocok untuk penikmat sambal dengan sensasi mencolek", "Ayam Geprek Sambal Pisah", 20000));
        list.add(new dagangan(R.drawable.kebaya4, "Ayam Geprek dengan Sambal Bawang sangat cocok untuk bawang lover", "Ayam Geprek Sambal Bawang", 18000));


        AdapterDagangan adapter = new AdapterDagangan(this, list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);




    }
}