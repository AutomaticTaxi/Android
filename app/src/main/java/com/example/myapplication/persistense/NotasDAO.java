package com.example.myapplication.persistense;

import com.example.myapplication.model.Notas;

import java.util.List;

public interface NotasDAO {
    public void salvar(Notas n);



    public List listar();
}
