package com.example.rentalkebaya;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDagangan extends RecyclerView.Adapter<AdapterDagangan.viewHolder> {
    Context context;
    ArrayList<dagangan> arrayList;
    double harga=0;

    public AdapterDagangan (Context context, ArrayList<dagangan> arrayList) {

        this.context = context;
        this.arrayList = arrayList;
    }
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_grid, parent, false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        dagangan dag = arrayList.get(position);

        holder.imageView.setImageResource(dag.getImageDagangan());
        holder.nama.setText(dag.getNamaGangan());
        holder.harga.setText(String.valueOf(dag.hargaDagangan));
        holder.imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                double hargaa = dag.getHargaDagangan();
                harga+=hargaa;
                DashboardActivity das = new DashboardActivity();
               // DashboardActivity.totalHarga.setText(String.valueOf(harga));
            }
        });
        holder.nama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, keteranganActivity.class);
                i.putExtra("keterangan", dag.getKeteranganDagangan());
                i.putExtra("gambar", dag.getImageDagangan());
                i.putExtra("nama", dag.getNamaGangan());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    public static class viewHolder extends  RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nama;
        TextView harga;
        TextView TotalHarga;

        public viewHolder(@NonNull View itemView) {

            super(itemView);

            imageView = itemView.findViewById(R.id.gambar);
            nama = itemView.findViewById(R.id.nama);
            harga = itemView.findViewById(R.id.harga);
            TotalHarga = itemView.findViewById(R.id.totalHarga);
        }
    }
}
