package com.example.artpreparation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_main, btn_home, btn_alat, btn_akun, btn_ubahbio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Button home = (Button)findViewById(R.id.btn_home);
        home.setOnClickListener(this);

        Button akun = (Button)findViewById(R.id.btn_akun);
        akun.setOnClickListener(this);

        Button alat = (Button)findViewById(R.id.btn_alat);
        alat.setOnClickListener(this);

        getSupportActionBar().setTitle("Home");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_home:
                Intent a = new Intent(Main2Activity.this, Main2Activity.class);
                startActivity(a);
                break;
            case R.id.btn_alat:
                Intent b = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(b);
                break;
            case R.id.btn_akun:
                Intent c = new Intent(Main2Activity.this, Main4Activity.class);
                startActivity(c);
                break;
        }
    }
}



//            case R.id.btn_ubahbio:
//                Intent biointent = new Intent(MainActivity.this, UbahSkor.class);
//                startActivity(biointent);
//                break;
