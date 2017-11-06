public class Cerchio extends Forma {
    private double raggio;
    public static final double PI= Math.PI;

    public Cerchio(Colore c, double r){
        super(c);
        this.raggio=r;
    }

    public double area(){
        return PI*Math.pow(raggio,2.0);
    }
    public double perimetro(){
        return 2*PI*raggio;
    }

    public String toString(){
        return "Cerchio di raggio "+raggio+" e area "+ area();
    }
}
