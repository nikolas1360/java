package Partita;

import java.io.BufferedReader;
import java.io.IOException;

public class PartitaCalcio extends Partita {
    private int tempoInCorso;

    public PartitaCalcio(String nomeSquadraCasa, String nomeSquadraOspite) {
        super(nomeSquadraCasa, nomeSquadraOspite);
        tempoInCorso=0;
    }

    public void iniziaPartita(){
        tempoInCorso=1;
    }
    public void nuovoTempo(){
        tempoInCorso++;
    }
    public int getTempoInCorso() {
        return tempoInCorso;
    }


}
