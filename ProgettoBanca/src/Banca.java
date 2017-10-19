public class Banca {
    private String nome;
    private int contiMassimi;
    private String radiceIban;
    private Conto[] conti;
    private int contiAttivi;

    public Banca(String nome, int contiMassimi, String radiceIban) {
        this.nome = nome;
        this.contiMassimi = contiMassimi;
        this.contiAttivi =0;
        this.radiceIban= radiceIban;
        this.conti = new Conto[contiMassimi];

    }

    public Conto[] getConti() {

        return conti;
    }

    public Conto aggiungiConto(String cf, int attivi){
        if(contiAttivi<=contiMassimi)
        {
            attivi++;
            setContiAttivi(attivi);
            conti[contiAttivi - 1]= new Conto(nome+radiceIban+contiAttivi,cf);

            return conti[contiAttivi -1 ];

        }else{
            return null;
        }
   }

    public double totaleSaldi(){
       double sommaTotale=0;
       for(int i=0; i<contiAttivi;i++){
           sommaTotale=sommaTotale+conti[i].getSaldo();
       }
       return sommaTotale;
    }

    public int getContiMassimi() {
        return contiMassimi;
    }

    public int getContiAttivi() {
        return contiAttivi;
    }

    public void setContiAttivi(int contiAttivi) {
        this.contiAttivi = contiAttivi;
    }

    public void getConto(String iban){
        int flag=0;
        System.out.println("Ricerca conti con IBAN: "+ iban);
        for(int i= 0; i<contiAttivi;i++){
            if(conti[i].getIban().equals(iban)){
                flag++;
                System.out.println("TROVATO: "+conti[i].getIban()+ " " + conti[i].getCf() + " Saldo: " + conti[i].getSaldo());
            }
        }
        if(flag == 0){
            System.out.println("Nessun conto con IBAN: "+ iban);
        }
     }

}
