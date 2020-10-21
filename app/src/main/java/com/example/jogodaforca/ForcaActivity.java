// ANDRÉ MOBAIER DE OLIVEIRA RA:00101025
// CIÊNCIA DA COMPUTAÇÃO - QUARTO SEMESTRE
// EXERCÍCIO JOGO DA FORCA - DATA: 20/10/2020

// Essa atividade é apenas a tela de início do jogo

package com.example.jogodaforca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ForcaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forca);
    }

    // Ir para a activity do Jogo
    public void onClickStartGame(View view) {
        Intent intent = new Intent(this, JogoActivity.class);
        startActivity(intent);
    }
}