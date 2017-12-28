import Exceptions.EmptyMenuException;
import Exceptions.NotFoundInMenuException;

import java.util.ArrayList;
import java.util.Iterator;

public class EsercizioRistorazione implements OperazioniMenu{
    protected String nome;

    protected ArrayList<Portata> menu=new ArrayList<Portata>();


    public EsercizioRistorazione(String name){
        this.nome=name;
    }

    public void aggiungiPortata(Portata p){
        menu.add(p);
    }

    public void  rimuoviPortata(String nomePortata)throws NotFoundInMenuException,EmptyMenuException{
        boolean check = false;
        if(menu.isEmpty()){
            throw new EmptyMenuException();
        }else{

            Iterator<Portata> i= menu.iterator();
            while(i.hasNext()){
                Portata s= i.next();
                if(s.getNomeAlimento().equals(nomePortata)){
                    check=true;
                    i.remove();
                }

            }
            /*for(Portata port : menu){
                if (port.getNomeAlimento().equals(nomePortata)){
                    check= true;
                    menu.remove(port);
                }
            }*/
            if(!check){
                throw new NotFoundInMenuException();
            }

        }
    }

    public void stampaMenu(){
        for(Portata port : menu){
            System.out.println(port.toString());

        }
    }

}

