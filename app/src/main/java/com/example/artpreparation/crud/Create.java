package com.example.artpreparation.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.artpreparation.Main3Activity;
import com.example.artpreparation.R;

public class Create extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Ejenis, Efungsi;
    private String Snama, Sjenis, Sfungsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create);
        db = new MyDatabase(this);

        getSupportActionBar().setTitle("Tambah Data Alat");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Enama = (EditText) findViewById(R.id.create_nama);
        Ejenis = (EditText) findViewById(R.id.create_jenis);
        Efungsi= (EditText) findViewById(R.id.create_fungsi);

        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snama = String.valueOf(Enama.getText());
                Sjenis= String.valueOf(Ejenis.getText());
                Sfungsi= String.valueOf(Efungsi.getText());

                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(Create.this, "Silahkan isi nama alat/ bahan", Toast.LENGTH_SHORT).show();
                } else if (Sjenis.equals("")){
                    Ejenis.requestFocus();
                    Toast.makeText(Create.this, "Silahkan isi jenis alat/ bahan", Toast.LENGTH_SHORT).show();
                } else if (Sfungsi.equals("")){
                    Efungsi.requestFocus();
                    Toast.makeText(Create.this, "Silahkan isi fungsi", Toast.LENGTH_SHORT).show();
                } else {
                    Enama.setText("");
                    Ejenis.setText("");
                    Efungsi.setText("");
                    Toast.makeText(Create.this, "Data telah ditambah", Toast.LENGTH_SHORT).show();
                    db.CreateDesainer(new Alat(null, Snama, Sjenis, Sfungsi));

                    Intent a = new Intent(Create.this, Main3Activity.class);
                    startActivity(a);
                }

            }
        });
    }

}

