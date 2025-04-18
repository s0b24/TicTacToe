package com.example.tictactoe;

import android.graphics.Color;
import android.widget.Button;
import android.widget.TextView;

public class PVPGameLogic {

    public static boolean player1_X_turn = true; // true = X, false = O

    // Game logic
    public void setupLogic(TextView playerTurn, String[] playerNames, Button[][] buttons) {
        player1_X_turn = true;

        // Player1's turn
        if (playerNames != null) {
            playerTurn.setText(playerNames[0] + "'s Turn");
        }

        // Buttons click
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3 ; j++) {

                int final_i = i;
                int final_j = j;

                // I used information from chatGPT on how to use .setOnClickListener
                buttons[i][j].setOnClickListener(v -> {
                    if (buttons[final_i][final_j].getText().toString().isEmpty()) {
                        if (player1_X_turn) {
                            buttons[final_i][final_j].setText("X");
                            buttons[final_i][final_j].setTextColor(Color.RED);
                            player1_X_turn = false;
                        } else {
                            buttons[final_i][final_j].setText("O");
                            buttons[final_i][final_j].setTextColor(Color.BLUE);
                            player1_X_turn = true;
                        }

                        if (playerNames != null) {
                            if (player1_X_turn) {
                                playerTurn.setText(playerNames[0] + "'s Turn");
                            } else {
                                playerTurn.setText(playerNames[1] + "'s Turn");
                            }
                        }

                        winnerCheck(playerTurn, playerNames, buttons);
                    }
                });
            }
        }
    }

    // Winner check
    public void winnerCheck(TextView playerTurn, String[] playerNames, Button[][] buttons) {
        boolean isWinner = false;
        String winnerSymbol = "";

        // Check rows
        for (int i = 0; i < 3; i++) {
            String i1 = buttons[i][0].getText().toString();
            String i2 = buttons[i][1].getText().toString();
            String i3 = buttons[i][2].getText().toString();

            if (!i1.isEmpty() && i1.equals(i2) && i2.equals(i3)) {
                isWinner = true;
                winnerSymbol = i1;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            String j1 = buttons[0][j].getText().toString();
            String j2 = buttons[1][j].getText().toString();
            String j3 = buttons[2][j].getText().toString();

            if (!j1.isEmpty() && j1.equals(j2) && j2.equals(j3)) {
                isWinner = true;
                winnerSymbol = j1;
            }
        }

        // Check diagonals
        String d1 = buttons[0][0].getText().toString();
        String d2 = buttons[1][1].getText().toString();
        String d3 = buttons[2][2].getText().toString();
        if (!d1.isEmpty() && d1.equals(d2) && d2.equals(d3)) {
            isWinner = true;
            winnerSymbol = d1;
        }

        String d4 = buttons[0][2].getText().toString();
        String d5 = buttons[1][1].getText().toString();
        String d6 = buttons[2][0].getText().toString();
        if (!d4.isEmpty() && d4.equals(d5) && d5.equals(d6)) {
            isWinner = true;
            winnerSymbol = d4;
        }

        // Check who is winner and who is loser
        if (isWinner) {
            String winnerName = "";
            String loserName = "";

            if (winnerSymbol.equals("X")) {
                winnerName = playerNames[0];
                loserName = playerNames[1];
            } else if (winnerSymbol.equals("O")) {
                winnerName = playerNames[1];
                loserName = playerNames[0];
            }

            playerTurn.setText(winnerName + " Win!!!" + " | " + loserName + " Lose!!!");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // I used information from chatGPT on how to use .setEnabled
                    buttons[i][j].setEnabled(false);

                }
            }
            return;

        // Check when is draw
        } else {
            boolean isDraw = false;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (buttons[i][j].getText().toString().isEmpty()) {
                        isDraw = true;
                    }
                }
            }
            if (!isDraw) {
                playerTurn.setText("Draw!!!");
            }
        }
    }
}
