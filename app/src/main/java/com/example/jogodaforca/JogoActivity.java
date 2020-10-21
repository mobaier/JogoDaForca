package com.example.jogodaforca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class JogoActivity extends AppCompatActivity {

    // As letras e palavras tentadas são armazenadas
    // Em uma ArrayList de Strings
    ArrayList<String> arr = new ArrayList<>();
    String palavraMisteriosa = "araraasdfasdfasdffsd";
    int chances = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);
        // Pegar valores da outra atividade
        TextView textViewRestante = findViewById(R.id.restante);
        TextView textViewMisterio = findViewById(R.id.palavraMisteriosa);
        Bundle bundle = getIntent().getExtras();
        String chances = bundle.getString("Chances");
        String misterio = bundle.getString("Misterio");
        String incognito = "";

        // Esconder as letras da palavra
        for(int i=0; i<misterio.length(); i++) {
            incognito += "_ ";
        }

        textViewRestante.setText(chances);
        textViewMisterio.setText(incognito);
    }

    // Adicionar as letras inseridas a uma lista de tentativas
    // e imprimir item a item em seguida
    public void onClickEnviarLetra(View view) {
        // Ver se a letra existe
        // TODO
        for(int i=0; i<palavraMisteriosa.length(); i++) {

        }

        // Adicionar a letra a lista de tentativas
        EditText editText = findViewById(R.id.editTextLetra);
        TextView textView = findViewById(R.id.palavras);
        String letra = editText.getText().toString();
        arr.add(letra);
        String adv = "";
        for(int i = 0; i < arr.size(); i++) {
            adv += arr.get(i) + " ";
        }
        textView.setText(adv);
    }

    // Adicionar as palavras inseridas a uma lista de tentativas
    // e imprimir item a item em seguida
    public void onClickEnviarPalavra(View view) {
        EditText editText = findViewById(R.id.editTextPalavra);
        TextView textView = findViewById(R.id.palavras);
        String palavra = editText.getText().toString();
        arr.add(palavra);
        String adv = "";
        for(int i = 0; i < arr.size(); i++) {
            adv += arr.get(i) + " ";
        }
        textView.setText(adv);
    }
}