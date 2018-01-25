
import Sensori.SensoreA;
import Sensori.SensoreB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Centralina {
    private static final int N_SENSORI_A=5;
    private static final int N_SENSORI_B=5;


    private String numeroDiTelefono;
    private boolean checkNumeroTelefono=false;
    private int contatoreAllarmi=0;

    MessaggioAllarme[] logAllarmi=new MessaggioAllarme[10];
    ArrayList<MessaggioAllarme> tempAllarmi=new ArrayList<>();

    Map<Integer, SensoreA> porteA = new HashMap<>();
    Map<Integer, SensoreB> porteB = new HashMap<>();
    private int porteAUtilizzate=0;
    private int porteBUtilizzate=0;


    public void setNumeroDiTelefono(String numeroDiTelefono) {
        this.numeroDiTelefono = numeroDiTelefono;
        this.checkNumeroTelefono=true;
    }
    public boolean checkAvviabilitaCentralina(){
                return((checkNumeroTelefono)&&(porteAUtilizzate==N_SENSORI_A)&&(porteBUtilizzate==N_SENSORI_B));
    }

    public void checkSensori() throws CentralinaNonAvviabileException {

        if((checkAvviabilitaCentralina()))
        {
            tempAllarmi.clear();
            for(Map.Entry<Integer,SensoreA>entry:porteA.entrySet()) {
                if(!(entry.getValue().leggiValore())){
                    tempAllarmi.add(new MessaggioAllarme(entry.getValue(),numeroDiTelefono,entry.getKey()));
                    aggiungiAllarmeAlLog(new MessaggioAllarme(entry.getValue(),numeroDiTelefono,entry.getKey()));
                }

            }
            for(Map.Entry<Integer,SensoreB>entry:porteB.entrySet()) {
                if(!(entry.getValue().leggiValore())){
                    aggiungiAllarmeAlLog(new MessaggioAllarme(entry.getValue(),numeroDiTelefono,entry.getKey()));
                    tempAllarmi.add(new MessaggioAllarme(entry.getValue(),numeroDiTelefono,entry.getKey()));
                }
            }
        }else{
            throw new CentralinaNonAvviabileException();
        }


    }

    private void aggiungiAllarmeAlLog(MessaggioAllarme messaggio){
        if(contatoreAllarmi>9){
            setContatoreAllarmi(contatoreAllarmi -10);

        }
        logAllarmi[contatoreAllarmi]=messaggio;
        setContatoreAllarmi(contatoreAllarmi +1);

    }
    public void stampaCronologiaAllarmi(MessaggioAllarme[] log){
        for(int i=0; i<=9;i++){
            if(log[i]!=null) {
                System.out.println(log[i].toString());
            }
            else {
                break;
            }
        }
    }


    public void associaSensoreA(SensoreA s){
        porteA.put(porteAUtilizzate,s);
        setPorteAUtilizzate(porteAUtilizzate +1 );
    }
    public void associaSensoreB(SensoreB s){
        porteB.put(porteBUtilizzate,s);
        setPorteBUtilizzate(porteBUtilizzate +1 );
    }


    private void setPorteAUtilizzate(int porteAUtilizzate) {
        this.porteAUtilizzate = porteAUtilizzate;
    }
    private void setPorteBUtilizzate(int porteBUtilizzate) {
        this.porteBUtilizzate = porteBUtilizzate;
    }
    private void setContatoreAllarmi(int contatoreAllarmi) {
        this.contatoreAllarmi = contatoreAllarmi;
    }

    public Map<Integer, SensoreA> getPorteA() {
        return porteA;
    }
    public Map<Integer, SensoreB> getPorteB() {
        return porteB;
    }
    public MessaggioAllarme[] getLogAllarmi() {
        return logAllarmi;
    }
    public ArrayList<MessaggioAllarme> getTempAllarmi() {
        return tempAllarmi;
    }
    public String getNumeroDiTelefono() {
        return numeroDiTelefono;
    }
}
