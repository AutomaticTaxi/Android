package com.example.myapplication.iu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.DialogInterface;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.model.Notas;
import com.example.myapplication.persistense.NotasDataBase;
import com.example.myapplication.persistense.RepositoryNotas;

import java.util.List;

public class TelaNotas extends AppCompatActivity {
    private static final String TAG = "TelaNotas";
    private ListView ListaAfazer;
    private List<Notas>dados;
    private Notas n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);
        mapeamentoXML();
        atualizadados();
        acoes();

    }
    void mapeamentoXML(){
        ListaAfazer = findViewById(R.id.idLista);
    }
    public void Sair (View view){
        onBackPressed();
    }

    public void atualizadados(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                dados = new RepositoryNotas(getApplicationContext()).GetAll();
                ListaAfazer.setAdapter(
                        new ArrayAdapter(getApplicationContext(),
                                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                                dados)// cria o adapter
                );
            }
        });
        thread.start();
    }
    void acoes() {
        ListaAfazer.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int indice, long l) {
                new AlertDialog.Builder(ListaAfazer.getContext())
                        .setTitle("Deseja Excluir ?")
                        .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                      new RepositoryNotas(getApplicationContext())
                                              .delete(dados.get(indice).getId());
                                        dados = new RepositoryNotas(getApplicationContext()).GetAll();


                                    }
                                }).start();
                            }
                        }).create().show();
                return false;
            }
        });

    }

}