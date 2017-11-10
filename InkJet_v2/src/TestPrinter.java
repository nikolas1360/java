public class TestPrinter {
    public static void main(String[] args) {
        InkJetPrinter p1=new InkJetPrinter(100);
        ImgVect img1 = new ImgVect("img1",3);

        img1.aggiungiForma(new Cerchio(Colore.BLACK, 4.2));
        img1.aggiungiForma(new Quadrato(Colore.BLUE, 4.2));
        img1.aggiungiForma(new Rettangolo(Colore.BLACK, 4.2,2.1));


        p1.showCartridgesLevel();
        p1.stampa(img1);
        p1.showCartridgesLevel();
        p1.stampa(img1); //BLACK non sufficiente
        p1.changeCartrige(Colore.BLACK);
        p1.stampa(img1);
        p1.showCartridgesLevel();


    }
}


