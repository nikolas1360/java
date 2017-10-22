import java.util.Scanner;

public class Banca {
    private Scanner in = new Scanner(System.in);
    private String nomeBanca;
    private String radiceIban;
    private int contiAttivi;
    private int numeroContiMassimi;
    public Conto[] conti;


    public Banca(String nomeB, String radice, int contiMax){
        this.nomeBanca=nomeB;
        this.radiceIban=radice;
        this.numeroContiMassimi=contiMax;
        this.conti = new Conto[numeroContiMassimi];
    }
    Conto aggiungiConto( String cf){
        String iban=nomeBanca+radiceIban+(contiAttivi+1);
        conti[contiAttivi]=new Conto(iban,cf);
        contiAttivi++;
        return conti[contiAttivi - 1];
    }


    void  saldoTotale() {
        double totale =0;
        for(int i=0; i<contiAttivi; i++ ){
            totale += conti[i].getSaldo();
        }
        System.out.println("Saldo totale: "+totale);
    }

    public Conto[] getConti() {
        return conti;
    }

    public int getNumeroContiMassimi() {
        return numeroContiMassimi;
    }

    public int getContiAttivi() {
        return contiAttivi;
    }

    int scelta(){

        System.out.print("Scelta: ");
        return in.nextInt();
    }
    public void getConto(String iban){
        int flag=0;
        System.out.println("Ricerca conti con IBAN: "+ iban);
        for(int i= 0; i<contiAttivi;i++){
            if(conti[i].getCodiceIban().equals(iban)){
                flag++;
                System.out.println("TROVATO: "+conti[i].getCodiceIban()+ " " + conti[i].getCodiceFiscale() + " Saldo: " + conti[i].getSaldo());
            }
        }
        if(flag == 0){
            System.out.println("Nessun conto con IBAN: "+ iban);
        }
    }
}
