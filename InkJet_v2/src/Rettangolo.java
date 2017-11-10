public class Rettangolo extends Forma {
    private double latoCorto;
    private double latoLungo;

    public Rettangolo(Colore c, double lungo, double corto){
        super(c);
        this.latoCorto=corto;
        this.latoLungo=lungo;
    }

    public double getArea(){
        return latoLungo*latoCorto ;
    }
    public double getPerimetro(){
        return (latoCorto+latoLungo)*2;
    }

    public String toString(){
        return "Rettangolo di lati "+latoLungo +" e "+latoCorto + " con area  " + getArea();
    }
}
