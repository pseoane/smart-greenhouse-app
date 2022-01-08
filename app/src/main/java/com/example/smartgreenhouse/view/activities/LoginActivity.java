package com.example.smartgreenhouse.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.smartgreenhouse.R;
import com.example.smartgreenhouse.model.Usuario;
import com.example.smartgreenhouse.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    private Button bLogin;
    private EditText editTextUser, editTextPass;
    private LoginViewModel viewModel;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        bLogin = (Button) findViewById(R.id.buttonLogin);
        editTextUser = (EditText) findViewById(R.id.editTextUser);
        editTextPass = (EditText) findViewById(R.id.editTextPass);
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        viewModel.getLoginResult().observe(this, succeeded -> onLoginResult(succeeded));
        bLogin.setOnClickListener(view -> login());
    }

    public void login(){
        String username = editTextUser.getText().toString();
        String password = editTextPass.getText().toString();
        viewModel.performLogin(new Usuario(username, password));
    }

    private void onLoginResult(Boolean loginSucceeded) {
        if (loginSucceeded) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
        }
    }
}
