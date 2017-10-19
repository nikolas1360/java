public class Conto{
    private String iban;
    private String cf;
    private double  saldo;

    public Conto(String iban, String cf) {
        this.iban = iban;
        this.cf = cf;
        this.saldo = 0;
    }

    public boolean preleva(double sommaPrelievo){

        if(saldo >= sommaPrelievo){
            saldo = saldo - sommaPrelievo;
            return true;
        }else {
            System.out.println("Fondi insufficienti sul conto.");
            return false;
        }
    }

    public boolean deposita(double sommaDeposito){
        if(sommaDeposito>= 10){
            saldo=saldo+sommaDeposito;
            return true;
        }else{
            return false;
        }
    }

    public String getIban() {return iban;}
    public String getCf() {return cf;}
    public double getSaldo() {return saldo;}



}

