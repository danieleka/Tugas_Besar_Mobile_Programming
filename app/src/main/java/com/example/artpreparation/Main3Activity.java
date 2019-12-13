package com.example.artpreparation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.artpreparation.crud.Alat;
import com.example.artpreparation.crud.Create;
import com.example.artpreparation.crud.CustomListAdapter;
import com.example.artpreparation.crud.MyDatabase;
import com.example.artpreparation.crud.Updel;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener{

    private Button btn_main, btn_home, btn_alat, btn_akun, btn_ubahbio, btn_read;
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Alat> listDesainer = new ArrayList<Alat>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alat);

        Button home = (Button)findViewById(R.id.btn_home);
        home.setOnClickListener(this);

        Button akun = (Button)findViewById(R.id.btn_akun);
        akun.setOnClickListener(this);

        Button alat = (Button)findViewById(R.id.btn_alat);
        alat.setOnClickListener(this);

        getSupportActionBar().setTitle("List Alat");

        db = new MyDatabase(this);

        adapter_off = new CustomListAdapter(this, listDesainer);
        mListView = (ListView) findViewById(R.id.list_alat);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        listDesainer.clear();

        List<Alat> contacts = db.ReadDesainer();
        for (Alat cn : contacts) {
            Alat judulModel = new Alat();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_jenis(cn.get_jenis());
            judulModel.set_fungsi(cn.get_fungsi());
            listDesainer.add(judulModel);

            if ((listDesainer.isEmpty()))
                Toast.makeText(Main3Activity.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {

            }
        }
    }

    //implementasi action bar untuk melihat info anggota pada activity baru
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_add,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_info:
                Intent i = new Intent(Main3Activity.this, Create.class);
                startActivity(i);
                return true;
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_home:
                Intent a = new Intent(Main3Activity.this, Main2Activity.class);
                startActivity(a);
                break;
            case R.id.btn_alat:
                Intent b = new Intent(Main3Activity.this, Main3Activity.class);
                startActivity(b);
                break;
            case R.id.btn_akun:
                Intent c = new Intent(Main3Activity.this, Main4Activity.class);
                startActivity(c);
                break;
        }
    }


    //read

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Alat obj_itemDetails = (Alat) o;

        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_nama();
        String Sjenis= obj_itemDetails.get_jenis();
        String Sfungsi = obj_itemDetails.get_fungsi();

        Intent goUpdel = new Intent(Main3Activity.this, Updel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Ijenis", Sjenis);
        goUpdel.putExtra("Ifungsi", Sfungsi);
        startActivity(goUpdel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listDesainer.clear();
        mListView.setAdapter(adapter_off);

        List<Alat> contacts = db.ReadDesainer();
        for (Alat cn : contacts) {
            Alat judulModel = new Alat();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_jenis(cn.get_jenis());
            judulModel.set_fungsi(cn.get_fungsi());
            listDesainer.add(judulModel);

            if ((listDesainer.isEmpty()))
                Toast.makeText(Main3Activity.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {

            }
        }
    }
}
