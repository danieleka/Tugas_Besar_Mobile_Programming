package com.example.artpreparation.anggota;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.artpreparation.R;

import java.util.ArrayList;

public class AnggotaAdapter extends RecyclerView.Adapter<AnggotaAdapter.MahasiswaViewHolder> {
    private ArrayList<anggota> dataList;

    public AnggotaAdapter(ArrayList<anggota> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public AnggotaAdapter.MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_anggota, parent, false);
        return new MahasiswaViewHolder(view);
    }

    public void onBindViewHolder(MahasiswaViewHolder holder, int position) {
        holder.txtNama.setText(dataList.get(position).getNama());
        holder.txtNpm.setText(dataList.get(position).getNim());
        holder.txtNoHp.setText(dataList.get(position).getAngkatan());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama, txtNpm, txtNoHp;

        public MahasiswaViewHolder(View itemView) {
            super(itemView);
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama_mahasiswa);
            txtNpm = (TextView) itemView.findViewById(R.id.txt_nim_mahasiswa);
            txtNoHp = (TextView) itemView.findViewById(R.id.txt_angkatan_mahasiswa);
        }
    }
}
