
import Sensori.SensoreA;
import Sensori.SensoreB;

import java.util.Map;

public class testerCentralina {
    public static void main(String[] args) {
        Centralina c=new Centralina();
        c.setNumeroDiTelefono("3342466917");

        SensoreA sA1=new SensoreA("Sony","velocità","m/s",0.1,200);
        SensoreA sA2=new SensoreA("Samsung","altezza","m",0.15,10);
        SensoreA sA3=new SensoreA("Marchetta","temperatura","K",0,450);
        SensoreA sA4=new SensoreA("LisantiMerda","velocità","m/s",0,115);
        SensoreA sA5=new SensoreA("Dario","lunghezza","m",0,25);

        SensoreB sB1=new SensoreB("Yota");
        SensoreB sB2=new SensoreB("Huawei");
        SensoreB sB3=new SensoreB("Intel");
        SensoreB sB4=new SensoreB("LisantinoMerdino");
        SensoreB sB5=new SensoreB("Nik");

        c.associaSensoreA(sA1);
        c.associaSensoreA(sA2);
        c.associaSensoreA(sA3);
        c.associaSensoreA(sA4);
        c.associaSensoreA(sA5);

        c.associaSensoreB(sB1);
        c.associaSensoreB(sB2);
        c.associaSensoreB(sB3);
        c.associaSensoreB(sB4);
        c.associaSensoreB(sB5);


        System.out.println("STAMPA SENSORI COLLEGATI ALLE PORTE A");
        for(Map.Entry<Integer,SensoreA>entry:c.getPorteA().entrySet()){
            System.out.println("PORTA A"+entry.getKey() + ": Info sensore: " + entry.getValue().toString());

        }
        System.out.println("STAMPA SENSORI COLLEGATI ALLE PORTE B");
        for(Map.Entry<Integer,SensoreB>entry:c.getPorteB().entrySet()){
            System.out.println("PORTA B"+entry.getKey() + ": Info sensore: " + entry.getValue().getMarcaSensore());

        }

        try {
            c.checkSensori();
            System.out.println("STAMPA LOG ALLARMI (MASSIMO 10)");
            c.stampaCronologiaAllarmi(c.getLogAllarmi());
        }catch (CentralinaNonAvviabileException e){
            System.err.println(e.getMessage());
        }



    }

}
