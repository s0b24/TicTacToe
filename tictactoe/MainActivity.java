package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Play button to select mode
    public void playButtonClick(View view) {
        Intent intent = new Intent(MainActivity.this, ModeSelect.class);
        startActivity(intent);
    }
}