package com.example.myapplication.persistense;

import android.content.Context;

import com.example.myapplication.model.Notas;

import java.util.List;

public class RepositoryNotas {
    private NotasDAO nnotasDAO;
    public RepositoryNotas(Context context){
        NotasDataBase db = NotasDataBase.getInstance(context);
        this.nnotasDAO = db.notasDAO();
    }
    public boolean insert(Notas n){
        return this.nnotasDAO.inserirNota(n) >0;
    }
    public boolean update(Notas n){
        return this.nnotasDAO.atualiza(n)>0;
    }
    public Notas FindByid(int id){
        return this.nnotasDAO.FindById(id);
    }
    public boolean delete (int id){
        Notas notas = this.FindByid(id);
        return this.nnotasDAO.deletar(notas)>0;
    }
    public List<Notas> GetAll(){
        return this.nnotasDAO.buscartodasnotas();
    }
}
