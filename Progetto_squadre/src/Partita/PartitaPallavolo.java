package Partita;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PartitaPallavolo extends Partita implements InterfacciaPallavolo{
    private int setInCorso;
    private int setVintiCasa;
    private int setVintiOspite;
    private int timeoutCasa;
    private int timeoutOspite;


    public PartitaPallavolo(String nomeSquadraCasa,String nomeSquadraOspite){
        super(nomeSquadraCasa,nomeSquadraOspite);
        setVintiCasa=0;
        setVintiOspite=0;
        timeoutCasa=0;
        timeoutOspite=0;
    }

    public void fineSet(){
        if(puntiCasa>puntiOspite){
            setVintiCasa++;
        }else{
            setVintiOspite++;
        }
    }
    public void nuovoSet(){
        setInCorso++;
        puntiOspite=0;
        puntiCasa=0;
    }
    public void incrementaTimeoutCasa() {
        timeoutCasa++;
    }
    public void incrementaTimeoutOspite(){
        timeoutOspite++;
    }

    public int getSetInCorso() {
        return setInCorso;
    }
    public int getSetVintiCasa() {
        return setVintiCasa;
    }
    public int getSetVintiOspite() {
        return setVintiOspite;
    }
    public int getTimeoutCasa() {
        return timeoutCasa;
    }
    public int getTimeoutOspite() {
        return timeoutOspite;
    }



    public void gestioneCodici(String cod){
        switch(cod){
            case "V-00":

                break;
            case "V-01":
                nuovoSet();
                break;
            case "V-02":
                fineSet();
                break;
            case "V-03":
                incrementaPuntiCasa();
                break;
            case "V-04":
                incrementaPuntiOspiti();
                break;
            case "V-05":
                incrementaTimeoutCasa();
                break;
            case "V-06":
                incrementaTimeoutOspite();
                break;
            case "V-98":
                break;
            case "V-99":
                break;
        }

    }


}
