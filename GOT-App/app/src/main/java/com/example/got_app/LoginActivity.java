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

        btnLogin = findViewById(R.id.btnLogin);
        btnSingUp = findViewById(R.id.btnSingUp);

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.i("TODO","Se apreto el boton iniciar sesion");

                String usuario= etUser.getText().toString();
                String passsword= etPassword.getText().toString();

                if(usuario.isEmpty() || passsword.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Completar Datos", Toast.LENGTH_SHORT).show();
                }else{
                    Intent main_activity = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(main_activity);
                }
            }
        });

        btnSingUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent main_activity = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(main_activity);
            }
        });
    }
}