package com.example.got_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class HouseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);

        Bundle bundle = getIntent().getExtras();
        Toolbar toolbar = (Toolbar) findViewById(R.id.tbHouse);
        String house ="";
        if (bundle != null){
            house = bundle.getString("header");
            Toast.makeText(HouseActivity.this, house, Toast.LENGTH_SHORT).show();
        }
        toolbar.setTitle(house);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.iBack:
                Intent main_activity = new Intent(HouseActivity.this, MainActivity.class);
                startActivity(main_activity);
                return true;

        }

        return super.onOptionsItemSelected(item);
    }
}