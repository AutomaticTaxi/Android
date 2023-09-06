package com.example.myapplication.iu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.model.Notas;

import java.util.List;

public class TelaNotas extends AppCompatActivity {
    private ListView ListaAfazer;
    private List<Notas>dados;
    private Notas n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);
        mapeamentoXML();
    }
    void mapeamentoXML(){
        ListaAfazer = findViewById(R.id.idLista);
    }


    public void Sair (View view){
        onBackPressed();
    }

}