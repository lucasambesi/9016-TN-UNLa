package com.example.clases;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
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
    Toolbar mi_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_login);

        mi_toolbar = findViewById(R.id.tbLogin);
        setSupportActionBar(mi_toolbar);
        getSupportActionBar().setTitle("Login...");

        etUsuario = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etPassword);

        cbRecordarUsuario = findViewById(R.id.cbRecordarUsuario);

        SharedPreferences prefs = getApplicationContext().getSharedPreferences(Constantes.SP_CREDENCIALES, MODE_PRIVATE);
        String usuarioGuardado = prefs.getString(Constantes.USUARIO, null);
        String passGuadarda = prefs.getString(Constantes.PASSWORD, null);

        if(usuarioGuardado != null && passGuadarda != null){
            iniciarMainActivity(usuarioGuardado);
        }

        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        btnRegistrarUsuario = findViewById(R.id.btnRegistrarUsuario);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               Log.i("TODO","Se apreto el boton iniciar sesion");

               String usuario= etUsuario.getText().toString();
               String password= etPassword.getText().toString();

               if(usuario.isEmpty() || password.isEmpty()){
                   Toast.makeText(LoginActivity.this, "Completar Datos", Toast.LENGTH_SHORT).show();
               }else{
                   login(usuario,password);
               }
           }
        });

        btnRegistrarUsuario.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                    Intent main_activity = new Intent(LoginActivity.this, TyCActivity.class);
                    startActivity(main_activity);
            }
        });
    }

    private void login(String usuario, String password) {
        if(cbRecordarUsuario.isChecked()){
            SharedPreferences prefs = getApplicationContext().getSharedPreferences(Constantes.SP_CREDENCIALES, MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            editor.putString(Constantes.USUARIO, usuario);
            editor.putString(Constantes.PASSWORD, password);
            editor.apply();
        }

        iniciarMainActivity(usuario);
    }

    private void iniciarMainActivity(String usuarioGuardado) {
        Intent main_activity = new Intent(LoginActivity.this, MainActivity.class);
        main_activity.putExtra(Constantes.USUARIO, usuarioGuardado);
        startActivity(main_activity);
        finish();
    }

}