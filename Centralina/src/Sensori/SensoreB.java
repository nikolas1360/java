package Sensori;

import java.util.concurrent.ThreadLocalRandom;

public class SensoreB extends Sensore {
    private String marcaSensore;
    private int statoRilevato;

    public SensoreB(String marca){
        this.marcaSensore=marca;
        this.statoRilevato=0;
    }

    public Boolean leggiValore(){
        int randomNum = ThreadLocalRandom.current().nextInt(0, 2);
        statoRilevato=randomNum;
        if(statoRilevato==0){
            return true;
        }else{
            return false;
        }
    }

    public String getMarcaSensore() {
        return marcaSensore;
    }
    public int getStatoRilevato() {
        return statoRilevato;
    }
}
