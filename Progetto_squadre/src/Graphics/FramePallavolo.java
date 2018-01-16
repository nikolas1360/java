package Graphics;

import Partita.PartitaPallavolo;


import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FramePallavolo extends JFrame {
    public static final int FRAMEWIDTH=500;
    public static final int FRAMEHEIGHT=300;
    BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Nikolas\\Desktop\\Progetto_squadre\\src\\docs\\volley.txt"));
    PartitaPallavolo p = new PartitaPallavolo("A","B");
    ReaderVolley r = new ReaderVolley();
    JButton refresh=new JButton("Refresh");


    ParteSuperiore  sup= new ParteSuperiore(p);
    AreaCommenti  cen= new AreaCommenti(p);



    public FramePallavolo() throws IOException {
        setSize(FRAMEWIDTH,FRAMEHEIGHT);
        setTitle("Tabellone pallavolo");
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        ActionListener a1=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String cod=r.lettura(br);
                    p.gestioneCodici(cod);
                    sup.setSetInCorso(Integer.toString(p.getSetInCorso()));
                    sup.setPuntiCasa(Integer.toString(p.getPuntiCasa()));
                    sup.setPuntiOspiti(Integer.toString(p.getPuntiOspite()));
                    sup.setSetCasa(Integer.toString(p.getSetVintiCasa()));
                    sup.setSetOspiti(Integer.toString(p.getSetVintiOspite()));
                    sup.setTimeoutCasa(Integer.toString(p.getTimeoutCasa()));
                    sup.setTimeoutOspiti(Integer.toString(p.getTimeoutOspite()));
                    cen.setCommento(r.getCommento());

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        };



        add(sup,BorderLayout.NORTH);
        add(cen,BorderLayout.CENTER);
        add(refresh,BorderLayout.SOUTH);
        refresh.addActionListener(a1);


    }

    class ParteSuperiore extends JPanel{
        JLabel setInCorso,puntiCasa,puntiOspiti,setCasa,setOspiti,timeoutCasa,timeoutOspiti;

        public ParteSuperiore(PartitaPallavolo p){
            setPreferredSize(new Dimension(500,50));
            setLayout(new GridLayout(1,7));


            setInCorso=new JLabel("SIC: "+p.getSetInCorso());
            add(setInCorso);
            puntiCasa=new JLabel("PC: "+p.getPuntiCasa());
            add(puntiCasa);
            puntiOspiti=new JLabel("PO: "+p.getPuntiOspite());
            add(puntiOspiti);
            setCasa=new JLabel("SC: " + p.getSetVintiCasa());
            add(setCasa);
            setOspiti=new JLabel("SO: "+p.getSetVintiOspite());
            add(setOspiti);
            timeoutCasa= new JLabel("TC: "+p.getTimeoutCasa());
            add(timeoutCasa);
            timeoutOspiti= new JLabel("TO: "+p.getTimeoutOspite());
            add(timeoutOspiti);
        }

        public void setSetInCorso(String p) {
           setInCorso.setText("SIC: "+ p);
        }
        public void setPuntiCasa(String p) {
            puntiCasa.setText("PC: "+ p);
        }
        public void setPuntiOspiti(String p) {
            puntiOspiti.setText("PO: "+ p);
        }
        public void setSetCasa(String p) {
            setCasa.setText("SC: "+ p);
        }
        public void setSetOspiti(String p) {
            setOspiti.setText("SO: "+ p);
        }
        public void setTimeoutCasa(String p) {
            timeoutCasa.setText("TC: "+ p);
        }
        public void setTimeoutOspiti(String p) {
            timeoutOspiti.setText("TO: "+ p);
        }
    }
}

class AreaCommenti extends JPanel{
    JLabel commento = new JLabel("Benvenuti alla partita.");

    public AreaCommenti(PartitaPallavolo p ){
        setPreferredSize(new Dimension(500,200));
        commento.setFont(new Font("Arial",Font.PLAIN,15));
        setLayout(new BorderLayout());
        add(commento,BorderLayout.CENTER);

    }
    public void setCommento(String p) {
        commento.setText(p);
    }
}
