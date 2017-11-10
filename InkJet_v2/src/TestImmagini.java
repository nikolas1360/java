import java.util.Arrays;

public class TestImmagini {
    public static void main(String[] args) {
        ImgVect images[]=new ImgVect[3];
        images[0]=new ImgVect("img1",3);
        images[1]=new ImgVect("img2",3);
        images[2]=new ImgVect("img3",3);

        images[0].aggiungiForma(new Cerchio(Colore.BLACK, 4.2));
        images[0].aggiungiForma(new Quadrato(Colore.BLUE, 4.2));
        images[0].aggiungiForma(new Rettangolo(Colore.BLACK, 4.2,2.1));

        images[1].aggiungiForma(new Cerchio(Colore.BLACK, 3.2));
        images[1].aggiungiForma(new Quadrato(Colore.BLUE, 3.2));
        images[1].aggiungiForma(new Rettangolo(Colore.BLACK, 3.2,1.7));

        images[2].aggiungiForma(new Cerchio(Colore.BLACK, 6.2));
        images[2].aggiungiForma(new Quadrato(Colore.BLUE, 6.2));
        images[2].aggiungiForma(new Rettangolo(Colore.BLACK, 5.2,2.6));

        Arrays.sort(images,0,2);

        System.out.println(images[0].toString());
        System.out.println(images[1].toString());
        System.out.println(images[2].toString());
    }
}
