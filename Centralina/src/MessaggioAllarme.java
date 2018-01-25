import Sensori.Sensore;
import Sensori.SensoreA;
import Sensori.SensoreB;

import java.time.LocalDateTime;

public class MessaggioAllarme {
    String tipoAllarme;
    String dettagliAllarme;
    String numeroDiTelefono;
    LocalDateTime dataOraAllarme;

    public MessaggioAllarme(Sensore s, String numeroDiTelefono, Integer numeroPorta) {
        this.dataOraAllarme= LocalDateTime.now();
        this.numeroDiTelefono=numeroDiTelefono;
        if(s instanceof SensoreA){
            this.tipoAllarme="PORTA A"+numeroPorta+": Valore fuori Range";
            this.dettagliAllarme="VALORE LETTO: "+((SensoreA) s).getValoreMisurato()+" RANGE: " +((SensoreA) s).getValoreMinimoRange()+"-"+((SensoreA) s).getValoreMassimoRange();
        }
        else{
            this.tipoAllarme="PORTA B"+numeroPorta+": Evento anomalo rilevato";
            this.dettagliAllarme="STATO LETTO: "+((SensoreB)s).getStatoRilevato();
        }


    }

    public String toString(){
        return tipoAllarme+" "+dettagliAllarme+" DATA e ORA:"+dataOraAllarme +" " + numeroDiTelefono;
    }


}
