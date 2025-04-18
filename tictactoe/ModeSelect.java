package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ModeSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mode_select);
    }

    // PVP mode button to open pvp mode
    public void pvpModeButtonClick(View view) {
        Intent intent = new Intent(ModeSelect.this, PVPMode.class);
        startActivity(intent);
    }

    // PVC mode button to open pvc mode
    public void pvcModeButtonClick(View view) {
        Intent intent = new Intent(ModeSelect.this, PVCMode.class);
        startActivity(intent);
    }
}