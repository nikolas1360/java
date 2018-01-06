import calcolatriceModel.Calcolatrice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class FinestraCalc extends JFrame {
    public static final int FRAMEWIDTH = 500;
    public static final int FRAMEHEIGHT = 300;
    private String display ="Benvenuto";
    private ScreenPanel sp;
    private ButtonPanel bp;

    public FinestraCalc() {
        setSize(FRAMEWIDTH, FRAMEHEIGHT);
        setTitle("Calcolatrice");
        setLocation(700, 340);
        setLayout(new BorderLayout());
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Calcolatrice calc = new Calcolatrice();

        ActionListener a1 = new ActionListener(){                       //CREO L'ACTION LISTENER COME CLASSE ANONIMA

            @Override
            public void actionPerformed(ActionEvent e) {
                String operation=e.getActionCommand();
                calc.key(Integer.parseInt(operation));
                display=calc.getDisplay();
                sp.setLabel(display);
            }
        };

        sp= new ScreenPanel(FRAMEWIDTH,FRAMEHEIGHT,display);
        bp = new ButtonPanel(FRAMEWIDTH,FRAMEHEIGHT,a1);

        Container contentPane = getContentPane();
        contentPane.add(sp,BorderLayout.NORTH);
        contentPane.add(bp,BorderLayout.CENTER);


    }


}


class ScreenPanel extends JPanel{
    JLabel testoDaVisualizzare;

    public ScreenPanel(int w, int h, String display) {
        setPreferredSize(new Dimension(w, h/3));
        setBackground(Color.black);
        testoDaVisualizzare=new JLabel(display);
        testoDaVisualizzare.setFont(new Font("Arial",Font.BOLD,40));
        testoDaVisualizzare.setForeground(Color.green);
        add(testoDaVisualizzare);
    }

    public void setLabel(String display) {
        testoDaVisualizzare.setText(display);
    }
}

class ButtonPanel extends JPanel{
    public ButtonPanel(int w, int h, ActionListener a) {

        setPreferredSize(new Dimension(w,(h/3)*2));

        ArrayList<CalcButton> pulsanti = new ArrayList<CalcButton>();

        pulsanti.add(new CalcButton("7","7"));
        pulsanti.add(new CalcButton("8","8"));
        pulsanti.add(new CalcButton("9","9"));
        pulsanti.add(new CalcButton("12","+"));
        pulsanti.add(new CalcButton("-1","CE"));

        pulsanti.add(new CalcButton("4","4"));
        pulsanti.add(new CalcButton("5","5"));
        pulsanti.add(new CalcButton("6","6"));
        pulsanti.add(new CalcButton("13","-"));
        pulsanti.add(new CalcButton("17","M+"));

        pulsanti.add(new CalcButton("1","1"));
        pulsanti.add(new CalcButton("2","2"));
        pulsanti.add(new CalcButton("3","3"));
        pulsanti.add(new CalcButton("14","x"));
        pulsanti.add(new CalcButton("18","MR"));

        pulsanti.add(new CalcButton("0","0"));
        pulsanti.add(new CalcButton("11","."));
        pulsanti.add(new CalcButton("16","="));
        pulsanti.add(new CalcButton("15","/"));
        pulsanti.add(new CalcButton("19","MC"));


        setLayout(new GridLayout(4,5));

        for(CalcButton cb:pulsanti){
            cb.setActionCommand(cb.getVal());           //IMPOSTA COME ACTION IL VALUE DEL PULSANTE
            cb.addActionListener(a);                    //ASSOCIA A CIASCUN PULSANTE UNA ACTION LISTENER
            add(cb);                                    //AGGIUNGE IL PULSANTE AL LAYOUT
        }
    }

}

class CalcButton extends JButton{
    private String val;
    public CalcButton(String value,String name) {
        super(name);
        val=value;
    }

    public String getVal() {
        return val;
    }
}
