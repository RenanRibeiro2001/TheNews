package com.example.thenews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thenews.DAO.DAO;

public class Cadastro_loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_login);
    }

    public void onCadastro(View view){
        EditText edtUser = (EditText) findViewById(R.id.campo_usuario_cadastro);
        EditText editText = (EditText) findViewById(R.id.campo_senha_cadastro);

        DAO dao = new DAO(this);
        //dao.CriaLoginNovo(edtUser.getText().toString(), editText.getText().toString());
        Toast.makeText(Cadastro_loginActivity.this, dao.CriaLoginNovo(edtUser.getText().toString(), editText.getText().toString()), Toast.LENGTH_LONG).show();

        Intent in = new Intent(Cadastro_loginActivity.this, LoginActivity.class);
        startActivity(in);
    }
}