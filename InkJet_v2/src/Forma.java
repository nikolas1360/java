public abstract class Forma implements Misurable  {
    private Colore colore;


    public Forma(Colore c){
        this.colore= c;
    }

    public Colore getColore() {
        return colore;
    }
    public abstract double getArea();
    public abstract double getPerimetro();

    /*public int compareTo(Forma f) {
        if (this.area() < (f.area())) {
            return -1;
        } else if (this.area() > (f.area())) {
            return 1;
        }
        return 0;
    }
    */
}
