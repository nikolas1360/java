public class TestPrinter {
    public static void main(String[] args) {
        InkJetPrinter p1=new InkJetPrinter(100);
        ImgVect img1 = new ImgVect("img1",3);

        img1.aggiungiForma(new Cerchio(Colore.BLACK, 4.2));
        img1.aggiungiForma(new Quadrato(Colore.BLUE, 4.2));
        img1.aggiungiForma(new Rettangolo(Colore.BLACK, 4.2,2.1));

        System.out. println("INK STATUS:");
        p1.showCartridgesLevel();
        System.out.println("Stampa dell'immagine...");

        if(p1.checkCartridgesLevel(img1)){ //PROVA STAMPA CON SUCCESSO
            p1.stampa(img1);
            System.out.println("Stampa terminata con successo. \nINK STATUS: ");
            p1.showCartridgesLevel();

        }else{
            System.out.println("Stampa fallita. Uno o più colori insufficienti.");
            System.out.println("Area di BLACK da stampare " + img1.areaTotaleColore(Colore.BLACK));
            System.out.println("Area di BLUE da stampare " + img1.areaTotaleColore(Colore.BLUE));
            System.out.println("Area di YELLOW da stampare " + img1.areaTotaleColore(Colore.YELLOW));
            System.out.println("Area di RED da stampare " + img1.areaTotaleColore(Colore.RED));
            System.out.println("INK STATUS:");
            p1.showCartridgesLevel();

            p1.changeCartrige(Colore.BLACK);
            System.out.println("Cartuccia BLACK cambiata.");

            System.out.println("INK STATUS:");
            p1.showCartridgesLevel();
        }

        System.out.println("\n \n \n \nStampa dell'immagine...");
        if(p1.checkCartridgesLevel(img1)){      //PROVA STAMPA FALLITA (BLACK INSUFFICIENTE)
            p1.stampa(img1);
            System.out.println("Stampa terminata con successo. \nINK STATUS: ");
            p1.showCartridgesLevel();

        }else{
            System.out.println("Stampa fallita. Uno o più colori insufficienti.");
            System.out.println("Area di BLACK da stampare " + img1.areaTotaleColore(Colore.BLACK));
            System.out.println("Area di BLUE da stampare " + img1.areaTotaleColore(Colore.BLUE));
            System.out.println("Area di YELLOW da stampare " + img1.areaTotaleColore(Colore.YELLOW));
            System.out.println("Area di RED da stampare " + img1.areaTotaleColore(Colore.RED));
            System.out.println("STATO ATTUALE CARTUCCE:");
            p1.showCartridgesLevel();

            p1.changeCartrige(Colore.BLACK);
            System.out.println("Cartuccia BLACK cambiata.");

            System.out.println("INK STATUS:");
            p1.showCartridgesLevel();
        }
    }
}


