package Alimenti;

public class Vino extends Alimento {
    String tipo;
    String colore;
    String gradazioneAlcolica;
    public Vino(String name,String gradazioneAlcolica,String tipo, String colore) {
        super(name);
        this.tipo=tipo;
        this.gradazioneAlcolica=gradazioneAlcolica;
        this.colore=colore;
    }

    @Override
    public void stampaEtchetta() {
        System.out.println(
                "Nome vino: "+this.nome +"\n"
                +"Gradazione: "+ this.gradazioneAlcolica + "\n"
                +"Tipo: "+ this.tipo + "\n"
                +"Colore: " + this.colore + "\n"

        );
    }
}
