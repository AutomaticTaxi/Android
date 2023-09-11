package com.example.myapplication.iu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.R;


public class MainActivity extends AppCompatActivity {
    private EditText conteudo;
    private String stringconteudo;
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
        conteudo = findViewById(R.id.Text_Nota);
        stringconteudo = conteudo.getText().toString();
       intent.putExtra("ContNota",stringconteudo);
       startActivity(intent);
    }
    public void Abrir_Notas(View view){
        Intent intent = new Intent(MainActivity.this, TelaNotas.class);
        startActivity(intent);
    }
}