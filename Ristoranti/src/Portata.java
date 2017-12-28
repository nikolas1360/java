import Alimenti.Alimento;

public class Portata {
    Alimento alimento;
    double prezzo;
    public Portata(Alimento a, double p){
        this.alimento=a;
        this.prezzo=p;
    }

    public String getNomeAlimento(){
        return alimento.getNome();
    }

    public String toString(){
        String str="Alimento: "+alimento.getNome()+" Prezzo: "+prezzo ;
        return str;
    }
}
