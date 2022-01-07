package com.example.smartgreenhouse.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartgreenhouse.R;
import com.example.smartgreenhouse.model.Usuario;

public class LoginActivity extends AppCompatActivity {

    Button bLogin;
    EditText edUser,edPass;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        bLogin = (Button) findViewById(R.id.buttonLogin);
        edUser = (EditText) findViewById(R.id.editTextUser);
        edPass = (EditText) findViewById(R.id.editTextPass);
        bLogin.setOnClickListener(view -> login());
    }
    public void login(){
        String username = edUser.getText().toString();
        String password = edPass.getText().toString();
        Usuario user = new Usuario(username,password);
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);


    }


}
