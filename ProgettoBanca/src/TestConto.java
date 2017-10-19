public class TestConto {
    public static void main(String[] args) {
        double dep=9,prel=50;

        Conto c1 = null;
        c1= new Conto("iban1", "cf1");

        if(c1.deposita(dep)){
            System.out.println("Saldo post deposito: "+c1.getSaldo());
        }else{
            System.out.println("ERRORE: Inserire un saldo superiore a 10 euro");
        }

        if(c1.preleva(prel)){
            System.out.println("Saldo post prelievo: "+c1.getSaldo());
        }else{
            System.out.println("ERRORE: Saldo insufficiente");
        }
    }
}
