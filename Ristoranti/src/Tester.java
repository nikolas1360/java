import Alimenti.Alimento;
import Alimenti.Carne;
import Alimenti.Vino;
import Exceptions.EmptyMenuException;
import Exceptions.NotFoundInMenuException;
import Exceptions.NotWineException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Tester {
    public static void main(String[] args)throws IOException {
        EsercizioRistorazione e1 = new Enoteca("Enoteca1");
        EsercizioRistorazione r1 = new Ristorante("Ristorante1");

        //ELIMINAZIONE PRIMA DI CREAZIONE MENU
        try{
            r1.rimuoviPortata("Filetto al pepe verde");

        }catch(EmptyMenuException e){
            System.err.println(e.getMessage());
        }
        catch(NotFoundInMenuException e){
            System.err.println(e.getMessage());
        }
        System.out.println("\nSTAMPA MENU ENOTECA (post eliminazione)");
        r1.stampaMenu();


        //CREAZIONE DEI MENU
        String fileName="E:\\Java\\Ristoranti\\src\\menu1.txt";
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while((line=br.readLine())!=null){
            try{
                String[] parts = line.split("\t");
                if(parts[0].equals("0")){
                    r1.aggiungiPortata(new Portata(new Carne(parts[1],parts[2],parts[3]),Double.parseDouble(parts[4])));
                    e1.aggiungiPortata(new Portata(new Carne(parts[1],parts[2],parts[3]),Double.parseDouble(parts[4])));


                }else{
                    r1.aggiungiPortata(new Portata(new Vino(parts[1],parts[2],parts[3],parts[4]),Double.parseDouble(parts[5])));
                    e1.aggiungiPortata(new Portata(new Vino(parts[1],parts[2],parts[3],parts[4]),Double.parseDouble(parts[5])));

                }

            }catch(NotWineException e){
                System.err.println(e.getMessage());
                continue;
            }
        }
        br.close();


        //STAMPA DEI MENU
        System.out.println("\nSTAMPA MENU ENOTECA (post lettura file)");
        e1.stampaMenu();
        System.out.println("\nSTAMPA MENU RISTORANTE(post lettura file)");
        r1.stampaMenu();

        try{
            e1.rimuoviPortata("Brunello tenuta Nuova");

        }catch(EmptyMenuException e){
            System.err.println(e.getMessage());
        }
        catch(NotFoundInMenuException e){
            System.err.println(e.getMessage());
        }
        System.out.println("\nSTAMPA MENU ENOTECA (post eliminazione)");
        e1.stampaMenu();
    }
}
