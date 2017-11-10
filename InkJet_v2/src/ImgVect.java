

public class ImgVect implements Comparable<ImgVect>{
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
            areaTot+=forme[i].getArea();
        }

        return areaTot;
    }

    public double areaTotaleColore(Colore c){
        double areaTot=0.0;
        for(int i=0; i<formeInserite;i++){
            if(forme[i].getColore().equals(c))
            {
                areaTot+=forme[i].getArea();
            }

        }
        //
        return (int)areaTot;
    }


    public void stampaVettore(){
        for(int i=0; i<formeInserite;i++){
            System.out.println((i+1)+") "+ forme[i].toString());
        }

    }

    public int compareTo(ImgVect immagine){
        if (this.areaTotale() < (immagine.areaTotale())) {
            return -1;
        } else if (this.areaTotale() > (immagine.areaTotale())) {
            return 1;
        }
        return 0;
    }

    public String toString(){
        String str;
        str= "Area totale: "+(int)this.areaTotale() + "\nForme: \n";
        for(int i=0;i<formeInserite;i++){
            str+= forme[i].toString() + "\n";
        }
        return str;
    }

    public Forma[] getForme() {
        return forme;
    }

    public int getFormeMax() {
        return formeMax;
    }
}
