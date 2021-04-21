package com.example.projetandroid;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Timer;

public class menumachines extends AppCompatActivity {

    private Button retour2;
    ArrayList<String> ListeMachines = new ArrayList<>();
    ArrayList<machine> ListeMachinesObjet = new ArrayList<>();
    machine machine1 = new machine("Foreuse");
    machine machine2 = new machine("Scie circulaire");
    ImageView img= (ImageView) findViewById(R.id.imagemenumachine);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pmachines);
//Spinner
        final TextView nom= (TextView)findViewById(R.id.nommachineinput);
        final TextView temps= (TextView)findViewById(R.id.tempsmachineinput);

        final Spinner spinnermachines = (Spinner) findViewById(R.id.spinmachine);

        ListeMachinesObjet.add(machine1);
        ListeMachinesObjet.add(machine2);
        ListeMachines.add(machine1.GetNom());
        ListeMachines.add(machine2.GetNom());
        machine2.SetTotalTemps(5,10);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ListeMachines);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnermachines.setAdapter(arrayAdapter);
        spinnermachines.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String choixmachines = parent.getItemAtPosition(position).toString(); //detecte la machine que l'ont a choisi
                Toast.makeText(parent.getContext(), "Selected: " + choixmachines, Toast.LENGTH_LONG).show();
                //Recuperation de l'item choisi
                int index = spinnermachines.getSelectedItemPosition (); //recupere l'objet machine dans la variable index
                nom.setText(ListeMachines.get(index));
                temps.setText(ListeMachinesObjet.get(index).GetTotalTemps());
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });
        //Detail Machines

        img.setImageResource(R.drawable.scie);

        //Retour
        retour2 = (Button) findViewById(R.id.retour2);
        retour2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmenu();
            }
        });
    }
    private void openmenu() {
        Intent intent = new Intent(this, menu.class);
        startActivity(intent);
    }

}
