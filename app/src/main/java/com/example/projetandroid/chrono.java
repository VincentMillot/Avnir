package com.example.projetandroid;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class chrono extends AppCompatActivity {
    machine machine1 = new machine("Foreuse");
    machine machine2 = new machine("Scie circulaire");

    ArrayList<machine> ListeMachinesObjet = new ArrayList<>();
    ArrayList<String> ListeMachines = new ArrayList<>();

    int secondes = 0;
    int minutes = 0;
    int totalM = 0;
    int totalS = 0;
    Timer T;
    boolean contrition;
    private Button retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pchrono);

//Spinner
        final Spinner spinner = (Spinner) findViewById(R.id.spinchrono);

        ListeMachinesObjet.add(machine1);
        ListeMachinesObjet.add(machine2);
        ListeMachines.add(machine1.GetNom());
        ListeMachines.add(machine2.GetNom());
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ListeMachines);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String choixmachines = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected: " + choixmachines, Toast.LENGTH_LONG).show();
//Recuperation de l'item choisie
                int index = spinner.getSelectedItemPosition ();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });



//Timer
        final TextView asecondes= (TextView)findViewById(R.id.sec);
        final TextView aminutes= (TextView)findViewById(R.id.mn);
        final TextView total= (TextView)findViewById(R.id.total);
        final Timer T = new Timer();
        T.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable()
                {
                        @Override
                        public void run ()
                        {
                            if (contrition)//Verifie si on a appuyer sur play ou pause.
                            {
                                secondes++;
                                if (secondes >= 60) //Verifie les secondes sont > a 60 pour passer la minutes
                                {
                                    minutes++;
                                    secondes = 0;
                                    if (minutes == 0){
                                        aminutes.setText("00");
                                        asecondes.setText("00");
                                    }
                                    else if (minutes < 10) //Verifie si on est à + ou = à 10 minutes
                                    {
                                        aminutes.setText("0"+minutes);
                                        asecondes.setText("00");
                                    }
                                    else
                                    {
                                        aminutes.setText(""+minutes);
                                        asecondes.setText(""+secondes);
                                    }
                                }
                                else //Sinon on continue d'imcrémenter les secondes.
                                {
                                    if (secondes < 10) //Verifie si on est à + ou = à 10 secondes
                                    {
                                        asecondes.setText("0" + secondes);
                                    }
                                    else
                                    {
                                        asecondes.setText("" + secondes);
                                    }
                                }
                            }
                        }
                });
            }
        }, 1000, 1000);

        //Lancer le chrono
        Button lancer = (Button) findViewById(R.id.lancer);
        lancer.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                contrition = true;
            }
        });

        //Mettre ne pause le chrono
        Button pause = (Button) findViewById(R.id.pause);
        pause.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                contrition = false;
                //total.setText(machine1._totalM + ":" + machine1._totalS);
            }
        });

        //Reset le chrono
        Button reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                contrition = false;
                ListeMachinesObjet.get(0).SetTotalTemps(secondes, minutes);
                total.setText(machine1._totalM + ":" + machine1._totalS);
                minutes = 0;
                secondes = 0;
                aminutes.setText("00");
                asecondes.setText("00");

            }
        });

//RETOUR
            retour = (Button) findViewById(R.id.retour);
            retour.setOnClickListener(new View.OnClickListener() {
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
