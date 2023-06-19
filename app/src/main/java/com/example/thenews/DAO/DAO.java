package com.example.thenews.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DAO extends SQLiteOpenHelper {

    public DAO(Context context) {
        super(context, "name", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_Login = "CREATE TABLE Login (id INTEGER PRIMARY KEY AUTOINCREMENT,usuario TEXT, senha TEXT);";

        db.execSQL(sql_Login);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql_Login = "DROP TABLE IF EXISTS Login;";

        db.execSQL(sql_Login);
        onCreate(db);
    }

    public String CriaLoginNovo(String usuario_novo, String senha_novo){
        SQLiteDatabase db = getWritableDatabase();

        if(usuario_novo.equals("")){
            return "Erro ao cadastrar usuário";
        }

        if(senha_novo.equals("")) {
            return "Erro ao cadastrar usuário";
        }

        try {
            ContentValues dados = new ContentValues();
            dados.put("usuario", usuario_novo);
            dados.put("senha", senha_novo);
            db.insert("Login", null, dados);
            db.close();
        } catch (SQLiteConstraintException erro) {
            return "Erro ao cadastrar usuário";
        }
        return "Sucesso ao Cadastrar Usuário";
    }

    @SuppressLint("Range")
    public String autenticaLogin(String usuario_colocado, String senha_colocado){
        String sql_buscaLogin = "SELECT usuario, senha FROM Login WHERE usuario = '" + usuario_colocado + "';";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql_buscaLogin, null);

        while(c.moveToNext()){
            if(usuario_colocado.equals(c.getString(c.getColumnIndex("usuario")))) {
                if(senha_colocado.equals(c.getString(c.getColumnIndex("senha")))){
                    return "Sucesso ao realizar o login !!";
                }
            }
        }

        db.close();
        c.close();

        return "Login Falhou !!";
    }
}
