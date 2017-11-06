

public class ImgVect {
    private String nomeImmagine;
    private int formeMax;
    private int formeInserite;
    private Forma forme[];



    public ImgVect(String nome, int max){
        this.nomeImmagine=nome;
        this.formeInserite=0;
        this.formeMax=max;
        this.forme=new Forma[formeMax];
    }

    public void  aggiungiForma(Forma f){
        if(formeInserite<formeMax){

            forme[formeInserite]= f;
            formeInserite++;
        }else{
            System.out.println("Limite di forme raggiunto.");
        }
    }

    public double areaTotale(){
        double areaTot=0.0;
        for(int i=0; i<formeInserite;i++){
            areaTot+=forme[i].area();
        }
        System.out.println("Area totale: "+areaTot);
        return areaTot;
    }

    public double areaTotaleColore(Colore c){
        double areaTot=0.0;
        for(int i=0; i<formeInserite;i++){
            if(forme[i].getColore().equals(c))
            {
                areaTot+=forme[i].area();
            }

        }
        System.out.println("Area totale del colore " + c +" : "+ areaTot);
        return areaTot;
    }


    public void stampaVettore(){
        System.out.println("Elenco delle forme presenti in: "+ nomeImmagine);
        for(int i=0; i<formeInserite;i++){
            System.out.println((i+1)+") "+ forme[i].toString());
        }

    }



    public Forma[] getForme() {
        return forme;
    }

    public int getFormeMax() {
        return formeMax;
    }
}
