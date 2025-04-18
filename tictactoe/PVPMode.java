package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PVPMode extends AppCompatActivity {

    EditText player1;
    EditText player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pvp_mode);

        player1 = findViewById(R.id.player1Name);
        player2 = findViewById(R.id.player2Name);
    }

    // Save names buttons to save names and pvp mode for use later
    public void submitNamesButtonClick(View view) {
        String player1Name = player1.getText().toString().trim();
        String player2Name = player2.getText().toString().trim();

        Intent intent = new Intent(PVPMode.this, GameDisplay.class);
        intent.putExtra("source", "pvp");
        intent.putExtra("player_names", new String[] {player1Name, player2Name});
        startActivity(intent);
    }
}