package com.example.projetandroid;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class menu extends AppCompatActivity {
    private Button chronometre;
    private Button machines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pmenu);

        chronometre = (Button) findViewById(R.id.chrono);
        chronometre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openchrono();
            }
        });

        machines = (Button) findViewById(R.id.machine);
        machines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmachines();
            }
        });
    }
    public void openchrono() {
        Intent intent = new Intent(this, chrono.class);
        startActivity(intent);
    }
    public void openmachines() {
        Intent intent = new Intent(this, menumachines.class);
        startActivity(intent);
    }
}
