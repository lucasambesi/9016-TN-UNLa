package com.example.got_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText etUser, etPassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUser = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tbRegister);
        setSupportActionBar(toolbar);

        btnRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String usuario= etUser.getText().toString();
                String passsword= etPassword.getText().toString();

                if(usuario.isEmpty() || passsword.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Completar Datos", Toast.LENGTH_SHORT).show();
                }else{
                    Intent main_activity = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(main_activity);
                }
            }
        });
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
}