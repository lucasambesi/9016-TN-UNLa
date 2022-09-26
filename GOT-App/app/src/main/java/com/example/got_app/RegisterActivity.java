package com.example.got_app;

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

public class RegisterActivity extends AppCompatActivity {
    EditText etUser, etPassword, etConfirmPass;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUser = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPass = findViewById(R.id.etConfirmPass);
        btnRegister = findViewById(R.id.btnRegister);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tbRegister);
        setSupportActionBar(toolbar);

        btnRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String name= etUser.getText().toString();
                String password= etPassword.getText().toString();
                String confirmPass= etConfirmPass.getText().toString();

                try {
                    registrarUsuario(name, password, confirmPass);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void registrarUsuario(String name, String password, String confirmPass) throws Exception {
        if(name.isEmpty() || password.isEmpty() || confirmPass.isEmpty()){
            Toast.makeText(RegisterActivity.this, "Completar Datos", Toast.LENGTH_SHORT).show();
        }else if(!password.equals(confirmPass)){
            Toast.makeText(RegisterActivity.this, "Los passwords no coinciden!", Toast.LENGTH_SHORT).show();
        }else if(validarName(name)){
            Toast.makeText(RegisterActivity.this, "El usuario ya existe!", Toast.LENGTH_SHORT).show();
        }else{
            try {
                User user = new User(name, password);
                UserManager.getInstancia(RegisterActivity.this).addUser(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Toast.makeText(RegisterActivity.this, "Usuario registrado!", Toast.LENGTH_SHORT).show();
            iniciarLoginActivity();
        }
    }

    private boolean validarName(String name){
        boolean response = false;
        User user = null;
        try{
            user = UserManager.getInstancia(RegisterActivity.this).getUserByName(name);
            if(user != null)
                response = true;
        }catch (Exception e){
            e.fillInStackTrace();
        }
        return response;
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_house, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.iBack:
                Intent main_activity = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(main_activity);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void iniciarLoginActivity() {
        Intent main_activity = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(main_activity);
        finish();
    }
}