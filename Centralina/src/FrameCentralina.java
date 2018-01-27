import Sensori.SensoreA;
import Sensori.SensoreB;
import jdk.nashorn.internal.objects.annotations.Where;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class FrameCentralina extends JFrame {

    InAlto inAlto;
    ListaSensori listaSensori;
    PannelloErrori pannelloErrori;



    public FrameCentralina(Centralina centralina){
        this.setTitle("CENTRALINA");
        this.setSize(800,800);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        inAlto=new InAlto(centralina);
        listaSensori= new ListaSensori(centralina);
        pannelloErrori= new PannelloErrori(centralina);

        ActionListener checkSens = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                centralina.checkSensori();
                pannelloErrori.stampaLogErrori(centralina);
                pannelloErrori.stampaAllarmi(centralina);


            }
        };

        ActionListener aggiungiNumero = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String numero = inAlto.getNumeroDiTelefono();
            centralina.setNumeroDiTelefono(numero);

            }
        };

        inAlto.getCheck().addActionListener(checkSens);
        inAlto.getSetNumero().addActionListener(aggiungiNumero);

        this.add(inAlto,BorderLayout.NORTH);
        this.add(listaSensori, BorderLayout.CENTER);
        this.add(pannelloErrori, BorderLayout.SOUTH);


    }
}

class InAlto extends JPanel {
    JTextField numeroDiTelefono;
    JButton setNumero;
    JButton check;
    public InAlto(Centralina c){
        setPreferredSize(new Dimension(800,80));
        setLayout(new GridLayout(0,3));

        numeroDiTelefono= new JTextField("Numero di telefono");
        numeroDiTelefono.setBackground(Color.BLACK);
        numeroDiTelefono.setForeground(Color.WHITE);
        numeroDiTelefono.setHorizontalAlignment(JTextField.CENTER);

        setNumero=new JButton("SET NUMERO");
        setNumero.setBackground(Color.BLACK);
        setNumero.setForeground(Color.WHITE);
        check=new JButton("CHECK SENSORI");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);

        add(numeroDiTelefono);
        add(setNumero);
        add(check);
    }

    public JButton getCheck() {
        return check;
    }

    public String getNumeroDiTelefono() {
        return numeroDiTelefono.getText();
    }

    public JButton getSetNumero() {
        return setNumero;
    }
}
class ListaSensori extends JPanel{

    private JList<String> listaSensoriA;
    private JList<String> listaSensoriB;
    DefaultListModel<String> modelA;
    DefaultListModel<String> modelB;
    public ListaSensori(Centralina c){
        setPreferredSize(new Dimension(800,200));
        setLayout(new GridLayout(0,2));
        setVisible(true);

        modelA=new DefaultListModel<>();
        modelB=new DefaultListModel<>();
        listaSensoriA=new JList<>(modelA);
        listaSensoriA.setFont(new Font("Arial",Font.BOLD,17));
        listaSensoriA.setBackground(Color.BLACK);
        listaSensoriA.setForeground(Color.WHITE);
        listaSensoriB=new JList<>(modelB);
        listaSensoriB.setFont(new Font("Arial",Font.BOLD,17));
        listaSensoriB.setBackground(Color.BLACK);
        listaSensoriB.setForeground(Color.WHITE);

        String str;
        for(Map.Entry<Integer, SensoreA>entry: c.getPorteA().entrySet()){
            str = entry.getKey() + " "+entry.getValue().toString();
            System.out.println(str);
            modelA.addElement(str);
        }

        for(Map.Entry<Integer, SensoreB>entry: c.getPorteB().entrySet()){
            str = entry.getKey() + " " +entry.getValue().getMarcaSensore();
            System.out.println(str);
            modelB.addElement(str);
        }

        add(listaSensoriA);
        add(listaSensoriB);
        listaSensoriA.setVisible(true);
        listaSensoriB.setVisible(true);
    }

}

class PannelloErrori extends JPanel {

    DefaultListModel modelloLog;
    DefaultListModel modelloAllarmi;
    JList listaLog;
    JList listaAllarmi;

    public PannelloErrori(Centralina c) {
        setPreferredSize(new Dimension(800, 520));
        setLayout(new GridLayout(2, 1));
        setBackground(Color.BLACK);

        modelloLog = new DefaultListModel();
        listaLog = new JList<>(modelloLog);
        listaLog.setBackground(Color.BLACK);
        listaLog.setForeground(Color.WHITE);
        listaLog.setFont(new Font("Arial", Font.PLAIN, 15));
        modelloAllarmi = new DefaultListModel();
        listaAllarmi = new JList<>(modelloAllarmi);
        listaAllarmi.setForeground(Color.RED);
        listaAllarmi.setBackground(Color.BLACK);
        stampaLogErrori(c);
        stampaAllarmi(c);
        add(listaLog);
        add(listaAllarmi);


    }

   public void stampaLogErrori(Centralina c){
        String str;
        if(c.getContatoreAllarmi()!=0){
            modelloLog.removeAllElements();
            for(MessaggioAllarme msg : c.getLogAllarmi()){
                str=msg.toString();
                modelloLog.addElement(str);

            }

        }
    }

    public void stampaAllarmi (Centralina c) {
        String str;
        if (c.getTempAllarmi().isEmpty()) {
            for (MessaggioAllarme msg : c.getTempAllarmi()) {
                str = msg.toString();
                modelloAllarmi.addElement(str);
            }
        }else{
                modelloAllarmi.removeAllElements();
                for (MessaggioAllarme msg : c.getTempAllarmi()) {
                    str = msg.toString();
                    modelloAllarmi.addElement(str);

                }
         }

    }
}

