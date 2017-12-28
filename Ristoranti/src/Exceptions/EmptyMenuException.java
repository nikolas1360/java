package Exceptions;

public class EmptyMenuException extends RuntimeException {
    public EmptyMenuException(){
        super ("Impossibile eliminare: nessun elemento nel menu");
    }
}
