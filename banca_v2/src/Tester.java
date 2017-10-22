import java.util.Scanner;
public class Tester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Banca b1=new Banca("Unicredit","IBN", 17);
        //Conto conti []= b1.getConti();
        int s, nConto;
        System.out.println("1)Aggiungi conti");
        System.out.println("2)Stampa elenco conti ");
        System.out.println("3)Preleva da conto ");
        System.out.println("4)Deposita su conto ");
        System.out.println("5)Ricerca conto tramite iban ");
        System.out.println("0)Esci ");
        do{

            switch( s = b1.scelta()){
                case 0:
                    break;
                case 1: //AGGIUNGI CONTI
                    System.out.print("Conti da aggiungere: ");
                    int daAggiungere=in.nextInt();
                    if((daAggiungere+b1.getContiAttivi())<=b1.getNumeroContiMassimi()) {
                        for (int j = 0; j < daAggiungere; j++) {

                            b1.conti[j] = b1.aggiungiConto("codF");
                        }
                    }else{
                        System.out.println("ERRORE Conti disponibili: "+ (b1.getNumeroContiMassimi()-b1.getContiAttivi()));
                    }

                    break;
                case 2: //STAMPA ELENCO CONTI
                    System.out.println("conti attivi: " + b1.getContiAttivi());
                    for(int j=0;j<b1.getContiAttivi();j++){
                        System.out.println(b1.conti[j].getCodiceIban() + " " + b1.conti[j].getCodiceFiscale()+ " Saldo: " + b1.conti[j].getSaldo());
                    }
                    break;

                case 3: //PRELEVA DA CONTO
                    System.out.print("Conto da cui prelevare: ");
                    nConto=in.nextInt();
                    if(nConto<=b1.getContiAttivi()){
                        System.out.print("Qta prelievo: ");
                        double daPrelevare=in.nextDouble();
                        if(b1.conti[nConto-1].preleva(daPrelevare)){
                            System.out.println("OK, nuovo saldo: " + b1.conti[nConto-1].getSaldo());
                        }else{
                            System.out.println("ERRORE: Saldo non sufficiente.");
                        }
                    }else{
                        System.out.println("ERRORE: sono disponibili solo " + b1.getContiAttivi() + " conti attivi.");
                    }

                    break;

                case 4: //DEPOSITA SU CONTO
                    System.out.print("Conto su cui depositare: ");
                    nConto=in.nextInt();
                    if(nConto<=b1.getContiAttivi()){
                        System.out.print("Qta deposito: ");
                        double daDepositare=in.nextDouble();
                        if(b1.conti[nConto-1].deposita(daDepositare)){
                            System.out.println("OK, nuovo saldo: " + b1.conti[nConto-1].getSaldo());
                        }else{
                            System.out.println("ERRORE: versare almeno 10 euro.");
                        }
                    }else{
                        System.out.println("ERRORE: sono disponibili solo " + b1.getContiAttivi() + " conti attivi.");
                    }
                    break;

                case 5: //STAMPA SALDO TOTOALE
                     b1.saldoTotale();
                     break;
                case 6:
                    System.out.print("Iban del conto da cercare: ");
                    String ricerca= in.nextLine();
                    b1.getConto(ricerca);
                    break;
            }
        }while(s!=0);

    }

}
