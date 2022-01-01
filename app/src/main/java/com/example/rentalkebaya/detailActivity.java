package com.example.rentalkebaya;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class detailActivity extends AppCompatActivity {

    TextView total, kembali;
    Button bayarr, nota;
    EditText jumlahuang;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent i = getIntent();
        String totalBayar = i.getStringExtra("total");

        kembali = findViewById(R.id.kembalian);
        total = findViewById(R.id.totalBayar);
        total.setText(totalBayar);
        jumlahuang = findViewById(R.id.edJumlahUang);

        nota = findViewById(R.id.buttonNota);
        nota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cetaknota = new Intent(detailActivity.this, NotaActivity.class);
                startActivity(cetaknota);
            }
        });


        bayarr = findViewById(R.id.btnBayar);
        bayarr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double jumlahBayar = Double.valueOf(totalBayar);
                double jumlahPembayaran = Double.valueOf(jumlahuang.getText().toString());
                double kembalian = jumlahPembayaran-jumlahBayar;

                kembali.setText(String.valueOf(kembalian));
                dialog = new Dialog(view.getContext());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_bayar);
                dialog.getWindow().setGravity(Gravity.CENTER);
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                TextView kembaliaan = dialog.findViewById(R.id.textJumlahKembalian);
                kembaliaan.setText("Kembalian anda : Rp. "+String.valueOf(kembalian));
                Button button = dialog.findViewById(R.id.buttonYa);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                        startActivity(new Intent(dialog.getContext(), DashboardActivity.class));
                    }
                });
            }
        });
    }
}