package com.example.myapplication.persistense;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.model.Notas;

import java.util.List;

@Dao
public interface NotasDAO {
    @Insert
    long inserirNota(Notas notas);
    @Update
    int atualiza(Notas notas);
    @Delete
   int deletar(Notas notas);

    @Query("SELECT * FROM Notas ")
    List<Notas> buscartodasnotas();
    @Query("SELECT * FROM Notas WHERE Id =:id")
    Notas FindById (int id);
}
