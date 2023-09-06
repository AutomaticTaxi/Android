package com.example.myapplication.persistense;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.model.Notas;

import java.util.List;

@Dao
public interface NotasDAO {
    @Insert
    void inserirNota(Notas nota);
    @Query("SELECT * FROM Notas")

    List<Notas> buscartodasnotas();
}
