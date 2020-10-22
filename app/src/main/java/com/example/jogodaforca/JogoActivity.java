package com.example.jogodaforca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class JogoActivity extends AppCompatActivity {

    ArrayList<String> arr = new ArrayList<>(); // Para armazenar as letras e palavras tentadas


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        // Pegar variáveis da outra atividade
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;

        TextView textView = findViewById(R.id.restante);
        TextView textView1 = findViewById(R.id.palavraMisteriosa);
        TextView textView2 = findViewById(R.id.display);

        String restante = bundle.getString("Chances");
        String palavra = bundle.getString("Misterio");
        // Censurar a palavra digitada
        String incognito = "";
        for(int i=0; i<palavra.length(); i++) {
            incognito += "_ ";
        }

        textView.setText(restante);
        textView1.setText(palavra);
        textView2.setText(incognito);
    }

    // Adicionar as letras inseridas a uma lista de tentativas
    // e imprimir item a item em seguida
    public void onClickEnviarLetra(View view) {
        // Adicionar a letra a lista de tentativas
        EditText editText = findViewById(R.id.editTextLetra);
        TextView textView = findViewById(R.id.palavras);
        TextView textView1 = findViewById(R.id.palavraMisteriosa);
        TextView textView2 = findViewById(R.id.restante);
        TextView textView3 = findViewById(R.id.display);

        String letra = editText.getText().toString();
        String palavra = textView1.getText().toString();
        String substituto = "";
        String adivinhacao = "";
        int restante = Integer.parseInt(textView2.getText().toString());

        arr.add(letra);
        for(int i = 0; i < arr.size(); i++) {
            adivinhacao += arr.get(i) + " ";
        }

        textView.setText(adivinhacao);

        // Ver se a letra digitada aparece na
        // palavra e revelar a posição da letra
        if(palavra.contains(letra)) {
            for(int i=0; i<palavra.length(); i++) {
                if(letra.equals(Character.toString(palavra.charAt(i)))) {
                    substituto += letra + " ";
                } else {
                    substituto += "_ ";
                }
            }

            textView3.setText(substituto);

        } else {
            restante--;
            textView2.setText(Integer.toString(restante));
        }

        // Se suas chances acabaram o jogo (atividade) é encerrado
        if(restante == 0) {
            CharSequence texto = "Fim de Jogo";
            int duracao = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, texto, duracao);
            toast.show();
            finish();
        }
    }

    // Adicionar as palavras inseridas a uma lista de tentativas
    // e imprimir item a item em seguida
    public void onClickEnviarPalavra(View view) {
        EditText editText = findViewById(R.id.editTextPalavra);
        TextView textView = findViewById(R.id.palavras);
        TextView textView1 = findViewById(R.id.palavraMisteriosa);
        TextView textView2 = findViewById(R.id.restante);
        TextView textView3 = findViewById(R.id.display);

        int restante = Integer.parseInt(textView2.getText().toString());
        String resposta = textView1.getText().toString();
        String palavra = editText.getText().toString();
        String adivinhacao = "";

        arr.add(palavra);
        for(int i = 0; i < arr.size(); i++) {
            adivinhacao += arr.get(i) + " ";
        }

        textView.setText(adivinhacao);

        // Ver se você acertou a palavra
        if(palavra.equals(resposta)) {
            textView3.setText(resposta);
            CharSequence texto = "Parabéns, Você Acertou!";
            int duracao = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, texto, duracao);
            toast.show();
            finish();
        } else {
            restante--;
            textView2.setText(Integer.toString(restante));
        }

        // Se suas chances acabaram o jogo (atividade) é encerrado
        if(restante == 0) {
            CharSequence texto = "Fim de Jogo";
            int duracao = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, texto, duracao);
            toast.show();
            finish();
        }
    }
}