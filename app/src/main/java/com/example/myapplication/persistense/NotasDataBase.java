package com.example.myapplication.persistense;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.myapplication.model.Notas;

@Database(entities = Notas.class,version = 1)
public abstract class NotasDataBase extends RoomDatabase {
    public abstract NotasDAO notasDAO();
    private static volatile NotasDataBase INSTANCE;
    static NotasDataBase getInstance(Context context){
        if (INSTANCE == null){
            synchronized (NotasDataBase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext()
                            ,NotasDataBase.class,"DBNotas").build();
                }
            }
        }
        return INSTANCE;
    }


}
