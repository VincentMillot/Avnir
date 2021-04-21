package com.example.projetandroid;

public class machine{
    private int _idmachines;
    public int _totalS;
    public int _totalM;
    public String _nom;

    public machine(String nom){ //constructeur
        _idmachines += 1;
        this._nom = nom;
    }

    public int GetTotalSeconde(){
        return _totalS;
    }
    public int GetTotalMinutes(){
        return _totalM;
    }
    public String GetNom(){
        return _nom;
    }

    public String GetTotalTemps(){
        String temps = Integer.toString(_totalS)+ ":" + Integer.toString(_totalM);
        return temps;
    }
    //setter
    public void SetNom(String Newnom){this._nom = Newnom;}

    public void SetTotalTemps(int Seconde, int Minute){ //Permet de comptabilisé le temps total
        this._totalS += Seconde;
        this._totalM += Minute;
    }



}
