package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private EditText conteudo = findViewById(R.id.Text_Nota);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Sair(View view){
        onBackPressed();
    }
    public void Abrir_Salvar(View view){
        Intent intent = new Intent(MainActivity.this, Salvar.class);
        startActivity(intent);
        intent.putExtra("Conteudo_da_nota",conteudo.getText().toString());
    }
    public void Abrir_Notas(View view){
        Intent intent = new Intent(MainActivity.this, Notas.class);
        startActivity(intent);
    }
}