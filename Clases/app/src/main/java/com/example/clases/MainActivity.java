package com.example.clases;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView rv_examenes;
    ExamenAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_promedio);

        setupAdapter();
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

    private List<Examen> getExamenes() {
        return new ArrayList<Examen>() {{
            add(new Examen(1, "Ingenieria de Software 1", "2022-04-05"));
            add(new Examen(2, "Algoritmos y Estructuras de Datos", "2022-04-07"));
            add(new Examen(3, "Prueba de Software", "2022-04-08"));
            add(new Examen(4, "Matematica", "2022-04-10"));
        }};
    }

    private void saludarUsuario(){
        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            String usuario = bundle.getString("usuario");
            Toast.makeText(MainActivity.this, "Bienvenido/a" + usuario, Toast.LENGTH_SHORT).show();
        }
    }
}

