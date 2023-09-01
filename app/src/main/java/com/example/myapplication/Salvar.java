package com.example.myapplication;

import static com.example.myapplication.R.id.Text_Nota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.model.Notas;
import com.example.myapplication.persistense.NotasDAO;
import com.example.myapplication.persistense.NotasimpBD;

public class Salvar extends AppCompatActivity {
   private EditText Nome_Nota;
   private CheckBox check_Nota;





    //Checkable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salvar);




    }



    NotasDAO dao;
    public void Sair(View view){
        onBackPressed();
    }
    public void Salvar_bt(View view){
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        dao = new NotasimpBD(this);
        Notas n = new Notas();
        if(b!=null)
        {
            String j =(String) b.get("Conteudo_da_nota");
            n.setConteudo(j);
        }
        Nome_Nota = findViewById(R.id.Text_Nome_Nota);
        check_Nota = findViewById(R.id.checkBox_Nota);
        n.setNome(Nome_Nota.getText().toString());
        n.setAfazer(check_Nota.isChecked());
        //dao.salvar(n);


    }
}
