package com.example.myapplication.persistense;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context){
        super(context,"dbNotas",null,1);

    }
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        StringBuffer sql = new StringBuffer();
        sql.append("create table notas(\" +\n" +
                "                \"id integer primary key autoincrement,\" +\n" +
                "                \"nome varchar(100),\" +\n" +
                "                \"afazer BIT NOT NULL,\" +\n" +
                "                \"conteudo text\" +\n" +
                "                \");");
        sqLiteDatabase.execSQL(sql.toString());
    }
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int i, int i1){
        sqLiteDatabase.execSQL("alter table pessoa add column sexo integer;");
    }
}
