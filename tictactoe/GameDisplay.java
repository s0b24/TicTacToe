package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameDisplay extends AppCompatActivity {

    // Array of buttons 3x3
    protected final Button[][] buttons = new Button[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_display);

        // Get the launch source (pvp or pvc)
        String source = getIntent().getStringExtra("source");
        // Player turn
        TextView playerTurn = findViewById(R.id.playerDisplay);
        // Get the Player names
        String[] playerNames = getIntent().getStringArrayExtra("player_names");

        // Buttons
        buttons[0][0] = findViewById(R.id.button00);
        buttons[0][1] = findViewById(R.id.button01);
        buttons[0][2] = findViewById(R.id.button02);

        buttons[1][0] = findViewById(R.id.button10);
        buttons[1][1] = findViewById(R.id.button11);
        buttons[1][2] = findViewById(R.id.button12);

        buttons[2][0] = findViewById(R.id.button20);
        buttons[2][1] = findViewById(R.id.button21);
        buttons[2][2] = findViewById(R.id.button22);

        // Selecting game logic depending on the source (pvp or pvc)
        if ("pvp".equals(source)) {
            PVPGameLogic gameLogic = new PVPGameLogic();
            gameLogic.setupLogic(playerTurn, playerNames, buttons);
        } else if ("pvc".equals(source)) {
            PVCGameLogic gameLogic = new PVCGameLogic();
            gameLogic.setupLogic(playerTurn, playerNames, buttons);
        }
    }

    // Play again button to reset the game
    public void playAgainButtonClick(View view) {
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }

        // Set player 1's turn
        PVPGameLogic.player1_X_turn = true;

        TextView playerTurn = findViewById(R.id.playerDisplay);
        String[] playerNames = getIntent().getStringArrayExtra("player_names");

        if (playerNames != null) {
            playerTurn.setText(playerNames[0] + "'s Turn");
        }
    }

    // Home button to return to the main activity
    public void homeButtonClick(View view) {
        Intent intent = new Intent(GameDisplay.this, MainActivity.class);
        startActivity(intent);
    }
}