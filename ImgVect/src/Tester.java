import java.util.Arrays;

public class Tester {

    public static void main(String[] args) {

       ImgVect img = new ImgVect("Immagine1",5);

       img.aggiungiForma(new Cerchio(Colore.BLUE,4.0));
       img.aggiungiForma(new Cerchio(Colore.BLACK,5.0));
       img.aggiungiForma(new Quadrato(Colore.BLACK,3.0));
       img.aggiungiForma(new Quadrato(Colore.RED,8.0));
       img.aggiungiForma(new Rettangolo(Colore.YELLOW,1.5,0.5));

       img.stampaVettore();
       img.areaTotale();
       img.areaTotaleColore(Colore.BLACK);

       Arrays.sort(img.getForme());

       img.stampaVettore();
    }
}
