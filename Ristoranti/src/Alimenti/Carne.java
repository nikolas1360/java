package Alimenti;

public class Carne extends Alimento {
    String origine;
    String parteAnimale;
    public Carne(String name,String animale,String parte) {
        super(name);
        this.origine=animale;
        this.parteAnimale=parte;
    }

    @Override
    public void stampaEtchetta() {
        System.out.println(
                "Nome piatto: "+this.nome +"\n"
                + "Animale: "+this.origine + "\n"
                +"Parte Animale: " + this.parteAnimale + "\n"
        );
    }
}
