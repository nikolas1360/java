public abstract class Forma implements Comparable <Forma> {
    private Colore colore;


    public Forma(Colore c){
        this.colore= c;
    }

    public Colore getColore() {
        return colore;
    }
    public abstract double area();
    public abstract double perimetro();

    public int compareTo(Forma f) {
        if (this.area() < (f.area())) {
            return -1;
        } else if (this.area() > (f.area())) {
            return 1;
        }
        return 0;
    }
}
