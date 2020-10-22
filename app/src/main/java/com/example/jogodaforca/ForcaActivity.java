// ANDRÉ MOBAIER DE OLIVEIRA RA:00101025
// CIÊNCIA DA COMPUTAÇÃO - QUARTO SEMESTRE
// EXERCÍCIO JOGO DA FORCA - DATA: 20/10/2020

// Essa atividade é apenas a tela de início do jogo

package com.example.jogodaforca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ForcaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forca);
    }

    // Botão para iniciar o jogo e enviar os dados
    // de configuração
    public void onClickStartGame(View view) {
        // Pegar os valores dos EditTexts
        EditText editTextMisterio = findViewById(R.id.misterio);
        EditText editTextChances = findViewById(R.id.chances);

        // Atribuí-los a variáveis para envio
        String misterio = editTextMisterio.getText().toString();
        String chances = editTextChances.getText().toString();

        // Configurar intenção para enviar os dados
        Intent intent = new Intent(this, JogoActivity.class);
        intent.putExtra("Chances", chances);
        intent.putExtra("Misterio", misterio);
        startActivity(intent);
    }
}