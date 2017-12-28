package Exceptions;

public class NotWineException extends RuntimeException {
    public NotWineException(){
        super ("Impossibile aggiungere: la portata non è un vino");
    }
}
