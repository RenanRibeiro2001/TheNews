package com.example.thenews;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        ImageButton logoutButton = findViewById(R.id.botaologout);

        logoutButton.setOnClickListener(v -> showLogoutConfirmationDialog());

        ImageButton button = findViewById(R.id.button_news);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inicie a nova Activity aqui
                Intent intent = new Intent(MenuActivity.this,NewsActivity.class);
                startActivity(intent);
            }
        });

    }

    private void showLogoutConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmação");
        builder.setMessage("Tem certeza que deseja sair da conta?");
        builder.setPositiveButton("Sim", (dialog, which) -> logout());
        builder.setNegativeButton("Não", null);
        builder.show();
    }

    private void logout() {
        Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}