package Partita;

abstract public class Partita implements InterfacciaPartita{
    protected String squadraCasa;
    protected String squadraOspite;
    protected int puntiCasa;
    protected int puntiOspite;

    public Partita(String nomeSquadraCasa, String nomeSquadraOspite){
        squadraCasa=nomeSquadraCasa;
        squadraOspite=nomeSquadraOspite;
        puntiCasa=0;
        puntiOspite=0;

    }

    public void incrementaPuntiCasa(){
        puntiCasa++;

    }
    public void incrementaPuntiOspiti(){
        puntiOspite++;
    }
    public String getSquadraCasa() {
        return squadraCasa;
    }
    public String getSquadraOspite() {
        return squadraOspite;
    }
    public int getPuntiCasa() {
        return puntiCasa;
    }
    public int getPuntiOspite() {
        return puntiOspite;
    }

}
