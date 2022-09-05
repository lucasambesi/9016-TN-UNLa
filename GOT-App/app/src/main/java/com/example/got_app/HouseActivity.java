package com.example.got_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class HouseActivity extends AppCompatActivity {

    RecyclerView rcv;
    CharacterAdapter adapter;

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

        rcv = (RecyclerView) findViewById(R.id.recview);
        adapter = new CharacterAdapter(dataqueue(), getApplicationContext());

        rcv.setAdapter(adapter);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,1);
        rcv.setLayoutManager(gridLayoutManager);
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

    public ArrayList<CardCharacterModel> dataqueue()
    {
        ArrayList<CardCharacterModel> houses = new ArrayList<>();

        CardCharacterModel stark =new CardCharacterModel();
        stark.setHeader("Jon Snow");
        stark.setDesc("\"description.\"");
        houses.add(stark);

        CardCharacterModel sansa=new CardCharacterModel();
        sansa.setHeader("Sansa Stark");
        sansa.setDesc("\"description.\"");
        houses.add(sansa);

        CardCharacterModel tst =new CardCharacterModel();
        tst.setHeader("Catelyn Stark");
        tst.setDesc("\"description.\"");
        houses.add(tst);

        CardCharacterModel tst2 =new CardCharacterModel();
        tst2.setHeader("Robb Stark");
        tst2.setDesc("\"description.\"");
        houses.add(tst2);

        CardCharacterModel tst3 =new CardCharacterModel();
        tst3.setHeader("Arya Stark");
        tst3.setDesc("\"description.\"");
        houses.add(tst3);

        CardCharacterModel tst4 =new CardCharacterModel();
        tst4.setHeader("Bran Stark");
        tst4.setDesc("\"description.\"");
        houses.add(tst4);

        CardCharacterModel tst5 =new CardCharacterModel();
        tst5.setHeader("Ned Stark");
        tst5.setDesc("\"description.\"");
        houses.add(tst5);

        CardCharacterModel tst6 =new CardCharacterModel();
        tst6.setHeader("Rickon Stark");
        tst6.setDesc("\"description.\"");
        houses.add(tst6);

        CardCharacterModel tst7 =new CardCharacterModel();
        tst7.setHeader("Benjen Stark");
        tst7.setDesc("\"description.\"");
        houses.add(tst7);


        CardCharacterModel tst8 =new CardCharacterModel();
        tst8.setHeader("Lyanna Stark");
        tst8.setDesc("\"description.\"");
        houses.add(tst8);

        CardCharacterModel tst9 =new CardCharacterModel();
        tst9.setHeader("test");
        tst9.setDesc("\"description.\"");
        houses.add(tst9);

        CardCharacterModel tst10 =new CardCharacterModel();
        tst10.setHeader("test");
        tst10.setDesc("\"description.\"");
        houses.add(tst10);

        return houses;
    }
}