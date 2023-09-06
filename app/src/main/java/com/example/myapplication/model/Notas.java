package com.example.myapplication.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notas")

public class Notas {

    @PrimaryKey(autoGenerate = true)
    private int Id;
    @ColumnInfo(name = "nome")
    private String Nome;
    @ColumnInfo(name = "afazer")
    private Boolean Afazer;
    @ColumnInfo(name = "conteudo")
    private String Conteudo;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Boolean getAfazer() {
        return Afazer;
    }

    public void setAfazer(Boolean afazer) {
        Afazer = afazer;
    }

    public String getConteudo() {
        return Conteudo;
    }

    public void setConteudo(String conteudo) {
        Conteudo = conteudo;
    }

    @Override
    public String toString() {
        return Id +" " + Nome +" " + Afazer + " " + Conteudo;
    }


}
