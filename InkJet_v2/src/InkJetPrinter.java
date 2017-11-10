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

        for(Colore c:Colore.values()){
            System.out. print(c.name()+" " +cartridge[c.ordinal()]+" ");
        }
        System.out. print(" \n");

    }

    public void changeCartrige(Colore col){
        for(Colore c:Colore.values()){
            if(c==col){
                cartridge[c.ordinal()]=MAXLEVEL;
            }
        }
    }
    {}
    public void stampa(ImgVect img){
        for(Colore c: Colore.values()){
            double areaTotC = img.areaTotaleColore(c);
            cartridge[c.ordinal()]-=areaTotC;
        }
    }


    public boolean checkCartridgesLevel(ImgVect img){
        for(Colore c:Colore.values()){
            double areaTotC = img.areaTotaleColore(c);
            if(areaTotC > cartridge[c.ordinal()]){
                return false;
            }
        }
        return true;
    }



}
