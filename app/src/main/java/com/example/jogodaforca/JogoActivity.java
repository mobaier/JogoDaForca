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
        TextView textView = findViewById(R.id.restante);
        assert bundle != null;
        String restante = bundle.getString("Chances");
        textView.setText(restante);
        TextView textView2 = findViewById(R.id.palavraMisteriosa);
        String palavra = bundle.getString("Misterio");
        textView2.setText(palavra);
    }

    // Adicionar as letras inseridas a uma lista de tentativas
    // e imprimir item a item em seguida
    public void onClickEnviarLetra(View view) {
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
        TextView textView1 = findViewById(R.id.palavraMisteriosa);
        TextView textView2 = findViewById(R.id.restante);
        int restante = Integer.parseInt(textView2.getText().toString());
        String resposta = textView1.getText().toString();
        String palavra = editText.getText().toString();
        arr.add(palavra);
        String adv = "";
        for(int i = 0; i < arr.size(); i++) {
            adv += arr.get(i) + " ";
        }
        textView.setText(adv);

        if(palavra.equals(resposta)) {
            CharSequence texto = "Parabéns, Você Acertou!";
            int duracao = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, texto, duracao);
            toast.show();
        } else {
            restante--;
            textView2.setText(Integer.toString(restante));
        }
    }
}