package com.example.myapplication.iu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
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
    private RepositoryNotas repositoryNotas;
    public EditText nome_Nota;
    public CheckBox check_Nota;
    public ListView listagem;
    public List<Notas>dados;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salvar);
        mapeamentoXML();
        this.repositoryNotas = new RepositoryNotas(getApplicationContext());




    }
    public void mapeamentoXML(){
        nome_Nota = findViewById(R.id.Text_Nome_Nota);
        check_Nota = findViewById(R.id.checkBox_Nota);

    }

    public void Sair(View view){
        onBackPressed();
    }
    public void Salvar_bt(View view) {
        Intent iin = getIntent();
        Bundle b = iin.getExtras();
        Notas n = new Notas();
        if (b != null) {
            String j = (String) b.get("Conteudo_da_nota");
            n.setConteudo(j);
        }
        n.setNome(nome_Nota.toString());
        n.setAfazer(check_Nota.isChecked());
        repositoryNotas.insert(n);

    }
}
