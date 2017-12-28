package Alimenti;

public abstract class Alimento implements OperazioniAlimento {
    String nome;

    public Alimento(String name){
        this.nome = name;
    }

    public String getNome() {
        return nome;
    }
}
