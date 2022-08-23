package com.example.clases;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNota1, etNota2;
    Button btnPromedio;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNota1 = findViewById(R.id.etNota1);
        etNota2 = findViewById(R.id.etNota2);
        btnPromedio = findViewById(R.id.btnPromedio);
        tvResultado = findViewById(R.id.tvResultado);

        btnPromedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nota1 = Integer.valueOf(etNota1.getText().toString());
                int nota2 = Integer.valueOf(etNota2.getText().toString());

                Toast.makeText(MainActivity.this, "Boton Calcular Promedio", Toast.LENGTH_LONG).show();
                calcularpromedio(nota1, nota2);
            }
        });
    }

    private void calcularpromedio(int nota1, int nota2) {
        int promedio = (nota1 + nota2) / 2;
        tvResultado.setText("Resultado: " + promedio);
    }
}