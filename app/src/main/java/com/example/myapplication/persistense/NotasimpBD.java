package com.example.myapplication.persistense;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.model.Notas;

import java.util.List;

public class NotasimpBD implements NotasDAO{
    DBHelper db;
    SQLiteDatabase le;

    @Override
    public void salvar(Notas n) {
        ContentValues dados = new ContentValues();
        dados.put("nome",n.getNome().toString());
        dados.put("conteudo",n.getConteudo().toString());
        dados.put("afazer",n.getAfazer().booleanValue());
        db.getWritableDatabase().insertOrThrow("dbNotas",null,dados);


    }
    public NotasimpBD(Context context){
        this.db=new DBHelper(context);
    }

    @Override
    public List listar (){return null;}
}
