package com.example.got_app;

import androidx.appcompat.app.AppCompatActivity;

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

    EditText etUser, etPassword;
    Button btnLogin, btnSingUp;
    CheckBox cbRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUser = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPassword);

        cbRemember = findViewById(R.id.cbRemember);

        SharedPreferences prefs = getApplicationContext().getSharedPreferences(Constantes.SP_CREDENCIALES, MODE_PRIVATE);
        String usuarioGuardado = prefs.getString(Constantes.USUARIO, null);
        String passGuadarda = prefs.getString(Constantes.PASSWORD, null);

        if(usuarioGuardado != null && passGuadarda != null){
            iniciarMainActivity(usuarioGuardado);
        }

        btnLogin = findViewById(R.id.btnLogin);
        btnSingUp = findViewById(R.id.btnSingUp);

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.i("TODO","Se apreto el boton iniciar sesion");

                String usuario= etUser.getText().toString();
                String password= etPassword.getText().toString();

                if(usuario.isEmpty() || password.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Completar Datos", Toast.LENGTH_SHORT).show();
                }else{
                    User user = new User(usuario, password);
                    validarUsuario(user);
                }
            }
        });

        btnSingUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.i("TODO","Se apreto el boton registrar usuario.");
                Intent main_activity = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(main_activity);
            }
        });
    }

    private void validarUsuario(User user) {
        User userAux = null;

        try{
            userAux = UserManager.getInstancia(LoginActivity.this).getUserByName(user.getName());
        }catch (Exception e){
            e.fillInStackTrace();
        }

        if(userAux == null){
            Toast.makeText(LoginActivity.this, "El usuario no coincide!", Toast.LENGTH_SHORT).show();
        }
        else if(!userAux.getPassword().equals(user.getPassword())){
            Toast.makeText(LoginActivity.this, "El password no coincide!", Toast.LENGTH_SHORT).show();
        }
        else{
            login(user);
        }
    }

    private void login(User user){
        if(cbRemember.isChecked()){
            SharedPreferences prefs = getApplicationContext().getSharedPreferences(Constantes.SP_CREDENCIALES, MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            editor.putString(Constantes.USUARIO, user.getName());
            editor.putString(Constantes.PASSWORD, user.getPassword());
            editor.apply();
        }

        iniciarMainActivity(user.getName());
    }

    private void iniciarMainActivity(String usuarioGuardado) {
        Intent main_activity = new Intent(LoginActivity.this, MainActivity.class);
        main_activity.putExtra(Constantes.USUARIO, usuarioGuardado);
        startActivity(main_activity);
        finish();
    }
}