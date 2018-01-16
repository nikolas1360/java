package Graphics;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;

public class ReaderVolley {
    private String codice;
    private String commento;
    private String data;


    public String lettura(BufferedReader br) throws IOException {

        String line;
        if((line=br.readLine())!=null)
        {
            String[] parts = line.split("\t");
            codice=parts[0];
            commento = parts[1];
            System.out.println(commento);
            data = parts[2];
        }
        else{
            System.err.println("Fine file \n");
        }



        return codice;
    }

    public String getCommento() {
        return commento;
    }
}
