package com.example.artpreparation;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.artpreparation.anggota.info_anggota;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener{

    private static final int REQUEST_CODE = 100;
    private Button btn_main, btn_home, btn_alat, btn_akun, btn_ubahbio;

    TextView tvHasil;

//    public static final String kata_kunci = "artpreparation.com.senddata";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.akun);

        Button home = (Button)findViewById(R.id.btn_home);
        home.setOnClickListener(this);

        Button akun = (Button)findViewById(R.id.btn_akun);
        akun.setOnClickListener(this);

        Button alat = (Button)findViewById(R.id.btn_alat);
        alat.setOnClickListener(this);

        Button ubahbio = (Button)findViewById(R.id.btn_ubahbio);
        ubahbio.setOnClickListener(this);

        tvHasil=findViewById(R.id.tvHasil);

        getSupportActionBar().setTitle("My Profile");


//        Intent ubah = getIntent();
//        String isipesan = ubah.getStringExtra(kata_kunci);
//        tvHasil = new TextView(this);
//        tvHasil.setText(isipesan);
//        tvHasil.setTextSize(100);
//        setContentView(tvHasil);
    }

    //implementasi action bar untuk melihat info anggota pada activity baru
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_info,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_info:
                Intent i = new Intent(Main4Activity.this, info_anggota.class);
                startActivity(i);
                return true;
        }
        return false;
    }

    //implementasi ketika navigation bar di klik akan berpindah halaaman
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_home:
                Intent a = new Intent(Main4Activity.this, Main2Activity.class);
                startActivity(a);
                break;
            case R.id.btn_alat:
                Intent b = new Intent(Main4Activity.this, Main3Activity.class);
                startActivity(b);
                break;
            case R.id.btn_akun:
                Intent c = new Intent(Main4Activity.this, Main4Activity.class);
                startActivity(c);
                break;
            case R.id.btn_ubahbio:
                Intent d = new Intent(Main4Activity.this, UbahSkor.class);
                startActivityForResult(d, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == UbahSkor.RESULT_CODE) {
                float resultNumber = data.getIntExtra(UbahSkor.RESULT_NUMBER, 0);
                tvHasil.setText(String.format("%s", resultNumber));
            }
        }
    }
}
