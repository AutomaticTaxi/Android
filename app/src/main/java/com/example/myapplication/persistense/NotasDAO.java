package com.example.myapplication.persistense;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.model.Notas;

import java.util.List;

@Dao
public interface NotasDAO {
    @Insert
    void inserirNota(Notas nota);
    @Query("SELECT * FROM notas")
    List<Notas> buscartodasnotas();
}
