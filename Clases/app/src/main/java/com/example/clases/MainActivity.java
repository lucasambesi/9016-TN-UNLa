package com.example.clases;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    Toolbar mi_toolbar;
    RecyclerView rv_examenes;
    ExamenAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mi_toolbar = findViewById(R.id.tbMain);
        setSupportActionBar(mi_toolbar);
        getSupportActionBar().setTitle("Examenes...");

        //setupAdapter();
        saludarUsuario();
    }

    private void setupAdapter(){
        rv_examenes.findViewById(R.id.rv_examenes);

        adapter = new ExamenAdapter(this.getExamenes(), new ExamenAdapter.OnItemClickListener(){
            @Override
            public void onItemClickListener(Examen examen) {
                //Funcionalidad
                Toast.makeText(MainActivity.this, examen.getMateria(), Toast.LENGTH_SHORT).show();
            }
        });

        rv_examenes.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.iAdd:
                Intent main_activity = new Intent(MainActivity.this, AgregarExamenActivity.class);
                startActivity(main_activity);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saludarUsuario(){
        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            String usuario = bundle.getString("usuario");
            Toast.makeText(MainActivity.this, "Bienvenido/a" + usuario, Toast.LENGTH_SHORT).show();
        }
    }

    private List<Examen> getExamenes() {
        return new ArrayList<Examen>() {{
            add(new Examen(1, "Ingenieria de Software 1", "2022-04-05"));
            add(new Examen(2, "Algoritmos y Estructuras de Datos", "2022-04-07"));
            add(new Examen(3, "Prueba de Software", "2022-04-08"));
            add(new Examen(4, "Matematica", "2022-04-10"));
        }};
    }
}