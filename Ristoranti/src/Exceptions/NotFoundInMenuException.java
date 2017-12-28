package Exceptions;

public class NotFoundInMenuException extends RuntimeException {
    public NotFoundInMenuException(){
        super("Impossibile eliminare: la portata desiderata non è nel menu");
    }
}
