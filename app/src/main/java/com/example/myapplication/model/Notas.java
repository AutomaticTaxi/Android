package com.example.myapplication.model;

public class Notas {
    private int Id;
    private String Nome;
    private Boolean Afazer;
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
        return "Notas{" +
                "Id=" + Id +
                ", Nome='" + Nome + '\'' +
                ", Afazer=" + Afazer +
                ", Conteudo='" + Conteudo + '\'' +
                '}';
    }


}
