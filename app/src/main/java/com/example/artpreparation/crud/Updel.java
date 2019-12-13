package com.example.artpreparation.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.artpreparation.R;

public class Updel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Sjenis, Sfungsi;
    private EditText Enama, Ejenis, Efungsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updel);
        db = new MyDatabase(this);

        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Sjenis= i.getStringExtra("Ijenis");
        Sfungsi= i.getStringExtra("Ifungsi");

        Enama = (EditText) findViewById(R.id.updel_nama);
        Ejenis = (EditText) findViewById(R.id.updel_jenis);
        Efungsi = (EditText) findViewById(R.id.updel_fungsi);

        Enama.setText(Snama);
        Ejenis.setText(Sjenis);
        Efungsi.setText(Sfungsi);

        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sjenis= String.valueOf(Ejenis.getText());
                Sfungsi= String.valueOf(Efungsi.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(Updel.this, "Silahkan isi nama alat/ bahan", Toast.LENGTH_SHORT).show();
                } else if (Sjenis.equals("")){
                    Ejenis.requestFocus();
                    Toast.makeText(Updel.this, "Silahkan isi jenis alat/ bahan", Toast.LENGTH_SHORT).show();
                } else if (Sfungsi.equals("")){
                    Efungsi.requestFocus();
                    Toast.makeText(Updel.this, "Silahkan isi fungsi", Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateDesainer(new Alat(Sid, Snama, Sjenis, Sfungsi));
                    Toast.makeText(Updel.this, "Data telah diupdate", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }         });

        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteDesainer(new Alat(Sid, Snama, Sjenis,Sfungsi));
                Toast.makeText(Updel.this, "Data telah dihapus", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}