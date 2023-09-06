package com.example.myapplication.persistense;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class DataBaseClient {
    private static NotasDataBase notasDataBase;
    public static NotasDataBase getNotasDataBase(Context context){
        if(notasDataBase == null){
            notasDataBase = Room.databaseBuilder(context,NotasDataBase.class,"NotasDataBase")
                    .addCallback(new RoomDatabase.Callback() {
                    })
                    .addMigrations(new Migration() {
                        @Override
                        public void migrate(@NonNull SupportSQLiteDatabase database) {

                        }
                    })
                    .build();
        }
        return notasDataBase;
    }
}
