package Sensori;

import java.util.concurrent.ThreadLocalRandom;

public class SensoreA extends Sensore{
    private  String marcaSensore;
    private String grandezzaMisurata;
    private String unitaMisura;
    private double valoreMinimoRange;
    private double valoreMassimoRange;
    private double valoreMisurato=0;

    public SensoreA(String marca, String grandezza, String unita, double min, double max){
        this.marcaSensore=marca;
        this.grandezzaMisurata=grandezza;
        this.unitaMisura=unita;
        this.valoreMinimoRange=min;
        this.valoreMassimoRange=max;


    }

    public Boolean leggiValore(){
        int randomNum = ThreadLocalRandom.current().nextInt(0, 210);
        valoreMisurato=randomNum;
        return (valoreMisurato>valoreMinimoRange && valoreMisurato<valoreMassimoRange);
    }



    public String toString(){
        return marcaSensore+" "+grandezzaMisurata+" "+unitaMisura+" "+valoreMinimoRange+" "+valoreMassimoRange;
    }
    public double getValoreMisurato() {
        return valoreMisurato;
    }
    public String getMarcaSensore() {
        return marcaSensore;
    }
    public String getGrandezzaMisurata() {
        return grandezzaMisurata;
    }
    public String getUnitaMisura() {
        return unitaMisura;
    }
    public double getValoreMinimoRange() {
        return valoreMinimoRange;
    }
    public double getValoreMassimoRange() {
        return valoreMassimoRange;
    }
}
