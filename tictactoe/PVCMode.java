package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PVCMode extends AppCompatActivity {

    EditText player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pvc_mode);

        player = findViewById(R.id.playerName);
    }

    // Save names buttons to save names and pvc mode for use later
    public void submitNameButtonClick(View view) {
        String playerName = player.getText().toString().trim();
        String computer = "Bot";

        Intent intent = new Intent(PVCMode.this, GameDisplay.class);
        intent.putExtra("source", "pvc");
        intent.putExtra("player_names", new String[] {playerName, computer});
        startActivity(intent);
    }
}
