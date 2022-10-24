package com.example.got_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcv;
    HouseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saludarUsuario();

        Toolbar toolbar = (Toolbar) findViewById(R.id.tbMain);

        setSupportActionBar(toolbar);
        rcv = (RecyclerView) findViewById(R.id.rvHouses);
        adapter = new HouseAdapter(dataqueue(),getApplicationContext());

        rcv.setAdapter(adapter);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        rcv.setLayoutManager(gridLayoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.iMore:
                Intent main_activity = new Intent(MainActivity.this, FavoritesActivity.class);
                startActivity(main_activity);
                return true;
            case R.id.iSingOff:
                SingOff();
                return true;
            case R.id.iBack:
                finish();
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saludarUsuario(){
        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            String usuario = bundle.getString(Constantes.USUARIO);
            Toast.makeText(MainActivity.this, "Bienvenido/a " + usuario, Toast.LENGTH_SHORT).show();
        }
    }

    private void SingOff(){

        SharedPreferences prefs = getApplicationContext().getSharedPreferences(Constantes.SP_CREDENCIALES, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString(Constantes.USUARIO, null);
        editor.putString(Constantes.PASSWORD, null);
        editor.apply();

        Intent login_activity = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(login_activity);
        finish();
    }

    public ArrayList<CardHouseModel> dataqueue()
    {
        ArrayList<CardHouseModel> houses = new ArrayList<>();

        CardHouseModel stark =new CardHouseModel();
        stark.setId("362");
        stark.setHeader("House Stark");
        stark.setDesc("\"Winter is Coming.\"");
        stark.setImage(R.drawable.stark);
        houses.add(stark);

        CardHouseModel targaryen=new CardHouseModel();
        targaryen.setId("378");
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
        arryn.setId("7");
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
