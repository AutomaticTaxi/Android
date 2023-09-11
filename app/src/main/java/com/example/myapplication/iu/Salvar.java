package com.example.myapplication.iu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.RoomDatabase;

import android.app.Application;
import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.model.Notas;
import com.example.myapplication.persistense.NotasDataBase;
import com.example.myapplication.persistense.NotasDataBase_Impl;
import com.example.myapplication.persistense.RepositoryNotas;

import java.util.List;

public class Salvar extends AppCompatActivity {

    public EditText nome_Nota;
    public CheckBox check_Nota;
    public Button BtSalvar;
    public EditText idparaeditnota;
    public Button EditButton;
    public ListView listagem;
    public List<Notas>dados;
    private String conteudo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_salvar);
        mapeamentoXML();
        acao();



    }
    public void mapeamentoXML(){
        nome_Nota = findViewById(R.id.Text_Nome_Nota);
        check_Nota = findViewById(R.id.checkBox_Nota);
        BtSalvar = findViewById(R.id.Salvar_Nota_BT);
        EditButton = findViewById(R.id.BtEditar);
        idparaeditnota = findViewById(R.id.idparaedit);
    }

    public void Sair(View view){
        onBackPressed();
    }

    public void acao () {
        BtSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Notas notas = new Notas();
                conteudo = getIntent().getStringExtra("ContNota");
                notas.setConteudo(conteudo);
                notas.setNome(nome_Nota.getText().toString());
                notas.setAfazer(check_Nota.isChecked());
                InsertAsyncTask insertAsyncTask = new InsertAsyncTask();
                insertAsyncTask.execute(notas);
            }
        });
        EditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Notas notas = new Notas();
                        conteudo = getIntent().getStringExtra("ContNota");
                        notas.setId(Integer.parseInt(idparaeditnota.getText().toString()));
                        notas.setConteudo(conteudo);
                        notas.setNome(nome_Nota.getText().toString());
                        notas.setAfazer(check_Nota.isChecked());
                        new RepositoryNotas(getApplicationContext()).update(notas);
                    }
                }).start();
            }
        });

    }
    class InsertAsyncTask extends AsyncTask<Notas,Void,Void>{

        @Override
        protected Void doInBackground(Notas... notas) {
            new RepositoryNotas(getApplicationContext()).insert(notas[0]);

            return null;
        }
    }
}
