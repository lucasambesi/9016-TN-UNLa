package com.example.clases;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarExamenActivity extends AppCompatActivity {

    Toolbar mi_toolbar;
    EditText etMateria, etFecha;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_examen);

        etMateria = findViewById(R.id.etMateria);
        etFecha = findViewById(R.id.etFecha);
        btnGuardar = findViewById(R.id.btnGuardar);
        mi_toolbar = findViewById(R.id.tbAddExamen);

        setSupportActionBar(mi_toolbar);
        getSupportActionBar().setTitle("Nuevo Examen");


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //funcionalidad

                Examen examen = new Examen();
                examen.setMateria(etMateria.getText().toString());
                examen.setFecha(etFecha.getText().toString());

                etMateria.setText("");
                etFecha.setText("");

                Toast.makeText(AgregarExamenActivity.this, "El examen se agrego correcametne", Toast.LENGTH_SHORT).show();
                
                try{
                    ExamenManager.getInstancia(AgregarExamenActivity.this).agregarExamen(examen);
                }catch (Exception e){
                    e.fillInStackTrace();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_agegarexamen, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.iBack:
                Intent main_activity = new Intent(AgregarExamenActivity.this, MainActivity.class);
                startActivity(main_activity);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}