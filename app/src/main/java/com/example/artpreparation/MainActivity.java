package com.example.artpreparation;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_main, btn_home, btn_alat, btn_akun, btn_ubahbio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button main = (Button)findViewById(R.id.btn_main);
        main.setOnClickListener(this);
        getSupportActionBar().setTitle("Artknowledgo");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_main:
                Intent a = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(a);
                break;
        }
}
}
