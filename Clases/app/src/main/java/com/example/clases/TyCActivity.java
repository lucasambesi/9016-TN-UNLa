package com.example.clases;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TyCActivity extends AppCompatActivity {

    Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ty_cactivity);

        btnAceptar = findViewById(R.id.btnAceptarTerminos);

        btnAceptar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(TyCActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}