public class Quadrato extends Forma{
    private int numeroLati;
    private double lunghezzaLato;

    public Quadrato(Colore c, double lunghezza){
        super (c);
        this.numeroLati=4;
        this.lunghezzaLato=lunghezza;
    }

    public double area(){
        return Math.pow(lunghezzaLato,2.0);

    }

    public double perimetro(){
        return lunghezzaLato*numeroLati;
    }

    public String toString(){
        return "Quadrato di lato "+lunghezzaLato +" e area " +area() ;
    }
}
