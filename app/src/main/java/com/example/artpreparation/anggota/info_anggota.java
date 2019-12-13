package com.example.artpreparation.anggota;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.artpreparation.R;

import java.util.ArrayList;

public class info_anggota extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView recyclerView;
    private AnggotaAdapter adapter;
    private ArrayList<anggota> mahasiswaArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anggotalist);

        getSupportActionBar().setTitle("Info Anggota");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addData();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        adapter = new AnggotaAdapter(mahasiswaArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(info_anggota.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void addData() {
        mahasiswaArrayList = new ArrayList<>();
        mahasiswaArrayList.add(new anggota("Daniel Eka Wijaya", "1718129", "2017"));
        mahasiswaArrayList.add(new anggota("Farhandi Ardi Wibowo", "1718131", "2017"));
        mahasiswaArrayList.add(new anggota("Yosep Armindo Putra", "1718132", "2017"));
    }

    @Override
    public void onClick(View v) {

    }
}
