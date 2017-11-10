public class InkJetPrinter {
    private final int MAXLEVEL;
    private  int cartridge[];

    public InkJetPrinter(int MAXLEVEL) {
        this.MAXLEVEL = MAXLEVEL;
        this.cartridge = new int [Colore.values().length];
        initCartridge();

    }
    public void initCartridge(){
        for(Colore c:Colore.values()){
            this.cartridge[c.ordinal()]=MAXLEVEL;
        }
    }

    public void showCartridgesLevel(){
        System.out. println("INK STATUS:");
        for(Colore c:Colore.values()){
            System.out. print(c.name()+" " +cartridge[c.ordinal()]+" ");
        }
        System.out. print(" \n");

    }

    public void changeCartrige(Colore col){
        for(Colore c:Colore.values()){
            if(c==col){
                cartridge[c.ordinal()]=MAXLEVEL;
                System.out.println("Cartuccia "+c.name()+" cambiata");
            }
        }
    }
    {}
    public void stampa(ImgVect img){
        if(checkCartridgesLevel(img)){
            for(Colore c: Colore.values()){
                double areaTotC = img.areaTotaleColore(c);
                cartridge[c.ordinal()]-=areaTotC;
            }
        }else{
            System.out.println("impossibile stampare");
        }

    }


    public boolean checkCartridgesLevel(ImgVect img){
        for(Colore c:Colore.values()){
            double areaTotC = img.areaTotaleColore(c);
            if(areaTotC > cartridge[c.ordinal()]){
                System.out.println("Colore "+c.name()+" insufficiente");
                return false;
            }
        }
        return true;

    }



}
