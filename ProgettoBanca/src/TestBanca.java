import java.util.Scanner;

public class TestBanca {
    public static void main(String[] args) {

        String ricerca,codf;
        int nConti;
        double totaleSaldi=0;

        Banca b1=new Banca("NOVARA", 10, "IBN");
        Conto[] conti= b1.getConti();

        Scanner in = new Scanner(System.in);
        nConti = Integer.parseInt(in.nextLine());

        if(nConti<=b1.getContiMassimi()){                                                   //CONTROLLO SE IL NUMERO DI CONTI CHE VOGLIO CRARE SUPERA IL LIMITE MASSIMO DELLA BANCA
            for(int i=0; i<nConti; i++){
                System.out.print("Conto n."+(i+1));
                System.out.print(" Codice Fiscale: ");
                codf = in.nextLine();

                conti[i]= b1.aggiungiConto(codf, b1.getContiAttivi());
                conti[i].deposita(50.0);                                        //DEPOSITO INIZIALMENTE 50 EURO SU OGNI CONTO PER PROVA

            }
            conti[0].preleva(47.0);                                                 //PRELEVO 47 DAL PRIMO CONTO
            System.out.println("ELENCO CONTI ");

            for(int i=0; i<nConti; i++) {                                                   //STAMPO ELENCO CONTI
                System.out.println(conti[i].getIban() + " CF: " + conti[i].getCf());
            }

            b1.getConto("NOVARAIBN2");                                                  //PROVA RICERCA
            totaleSaldi= b1.totaleSaldi();                                                      //SOMMA DEI SALDI
            System.out.println("Totale saldi: "+ totaleSaldi);

        }else{
            System.out.println("ERRORE: Numero conti troppo alto.");
        }

    }

}
