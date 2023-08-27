package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Sair(View view){
        finish();
    }
    public void Abrir_Salvar(View view){
        Intent intent = new Intent(MainActivity.this, Salvar.class);
        startActivity(intent);
    }
    public void Abrir_Notas(View view){
        Intent intent = new Intent(MainActivity.this, Notas.class);
        startActivity(intent);
    }
}