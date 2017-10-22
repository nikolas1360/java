public class Conto {
    private String codiceFiscale;
    private String codiceIban;
    private double saldo;

    public Conto(String iban, String cf) {
        codiceFiscale=cf;
        codiceIban=iban;
        saldo=0;
    }

    boolean preleva(double qtaPrelievo){
        if(saldo >= qtaPrelievo){
            saldo = saldo - qtaPrelievo;
            return true;

        }else{
            return false;
        }

    }
    boolean deposita(double qtaDeposito){
        if(qtaDeposito>= 10){
            saldo=saldo+qtaDeposito;
            return true;
        }else{
            return false;
        }
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String getCodiceIban() {
        return codiceIban;
    }

    public double getSaldo() {
        return saldo;
    }
}
