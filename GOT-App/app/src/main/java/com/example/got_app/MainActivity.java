package com.example.got_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcv;
    HouseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tbHouse);

        setSupportActionBar(toolbar);
        rcv = (RecyclerView) findViewById(R.id.recview);
        adapter = new HouseAdapter(dataqueue(),getApplicationContext());

        rcv.setAdapter(adapter);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        rcv.setLayoutManager(gridLayoutManager);
    }


    public ArrayList<CardHouseModel> dataqueue()
    {
        ArrayList<CardHouseModel> houses = new ArrayList<>();

        CardHouseModel stark =new CardHouseModel();
        stark.setHeader("House Stark");
        stark.setDesc("\"Winter is Coming.\"");
        stark.setImage(R.drawable.stark);
        houses.add(stark);

        CardHouseModel targaryen=new CardHouseModel();
        targaryen.setHeader("House Targaryen");
        targaryen.setDesc("\"Fire and Blood.\"");
        targaryen.setImage(R.drawable.targaryen);
        houses.add(targaryen);

        CardHouseModel greyjoy=new CardHouseModel();
        greyjoy.setHeader("House Greyjoy");
        greyjoy.setDesc("\"We Do Not Sow.\"");
        greyjoy.setImage(R.drawable.greyjoy);
        houses.add(greyjoy);

        CardHouseModel tully=new CardHouseModel();
        tully.setHeader("House Tully");
        tully.setDesc("\"Family, Duty, Honor.\"");
        tully.setImage(R.drawable.tully);
        houses.add(tully);

        CardHouseModel arryn=new CardHouseModel();
        arryn.setHeader("House Arryn");
        arryn.setDesc("\"As High as Honor.\"");
        arryn.setImage(R.drawable.arryn);
        houses.add(arryn);

        CardHouseModel lannister=new CardHouseModel();
        lannister.setHeader("House Lannister");
        lannister.setDesc("\"Hear Me Roar!\"");
        lannister.setImage(R.drawable.lannister);
        houses.add(lannister);

        CardHouseModel tyrell=new CardHouseModel();
        tyrell.setHeader("House Tyrell");
        tyrell.setDesc("\"Growing Strong.\"");
        tyrell.setImage(R.drawable.tyrell);
        houses.add(tyrell);

        CardHouseModel baratheon=new CardHouseModel();
        baratheon.setHeader("House Baratheon");
        baratheon.setDesc("\"Ours is the Fury.\"");
        baratheon.setImage(R.drawable.baratheon);
        houses.add(baratheon);

        CardHouseModel martell=new CardHouseModel();
        martell.setHeader("House Martell");
        martell.setDesc("\"Unbowed, Unbent, Unbroken.\"");
        martell.setImage(R.drawable.martell);
        houses.add(martell);

        return houses;
    }
}
