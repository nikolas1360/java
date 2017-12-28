import Alimenti.Vino;
import Exceptions.NotWineException;

public class Enoteca extends EsercizioRistorazione {
    public Enoteca(String name) {
        super(name);
    }

    public void aggiungiPortata(Portata p){
        if(p.alimento instanceof Vino){
            menu.add(p);
        }
        else{
            throw new NotWineException();
        }

    }
}
