package com.example.got_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etUsuario, etPassword;
    Button btnIniciarSesion, btnRegistrarUsuario;
    CheckBox cbRecordarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etPassword);

        cbRecordarUsuario = findViewById(R.id.cbRecordarUsuario);

        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        btnRegistrarUsuario = findViewById(R.id.btnRegistrarUsuario);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.i("TODO","Se apreto el boton iniciar sesion");

                String usuario= etUsuario.getText().toString();
                String passsword= etPassword.getText().toString();

                if(usuario.isEmpty() || passsword.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Completar Datos", Toast.LENGTH_SHORT).show();
                }else{
                    Intent main_activity = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(main_activity);
                }
            }
        });

        btnRegistrarUsuario.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent main_activity = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(main_activity);
            }
        });
    }
}