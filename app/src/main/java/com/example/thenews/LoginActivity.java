package com.example.thenews;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thenews.DAO.DAO;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        getSupportActionBar().hide();

    }

    public void onNovo(View view) {
        Intent in = new Intent(LoginActivity.this, Cadastro_loginActivity.class);
        startActivity(in);
    }

    public void onEntrar(View view) {
        EditText edtUser = (EditText) findViewById(R.id.campo_usuario);
        EditText edtSenha = (EditText) findViewById(R.id.campo_senha);

        DAO dao = new DAO(this);
        String Autenticacao = dao.autenticaLogin(edtUser.getText().toString(), edtSenha.getText().toString());
        if(Autenticacao == "Sucesso ao realizar o login !!"){
            Toast.makeText(LoginActivity.this, Autenticacao, Toast.LENGTH_LONG).show();
            Intent in = new Intent(LoginActivity.this, MenuActivity.class);
            startActivity(in);
        }else {
            Toast.makeText(LoginActivity.this, Autenticacao, Toast.LENGTH_LONG).show();
        }
    }

}