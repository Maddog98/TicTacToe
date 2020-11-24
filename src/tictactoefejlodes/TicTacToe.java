package tictactoefejlodes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JApplet
        implements ActionListener {

    private final String[] felirat = {"0", "X"};
    private final String[] meretek = {"3x3", "4x4", "5x5"};
    private JComboBox meretvalszto = new JComboBox(meretek);
    private JButton btÚjJáték = new JButton("Új játék");
    private JLabel lbÜzenet = new JLabel("1. lépés: X");
    private JButton btGomb[] = new JButton[10];   //1-9-ig kell 10, 13, 26  
    private int lépésSzám = 0;
    private int x = (int) meretvalszto.getSelectedIndex();

    @Override
    public void init() {
        setSize(300, 350);
        JPanel pnEszköztár = new JPanel();
        pnEszköztár.add(btÚjJáték);
        pnEszköztár.add(meretvalszto);
        btÚjJáték.addActionListener(this);
        pnEszköztár.add(lbÜzenet);
        add(pnEszköztár, BorderLayout.NORTH);
        JPanel pnJátéktér = new JPanel(new GridLayout(3, 3));//3x3,4x4,5x5
        Font betű = new Font("Comic Sans MS", Font.BOLD, 60);
        for (int i = 1; i <= x; i++) {
            btGomb[i] = new JButton();
            btGomb[i].setFont(betű);            
            pnJátéktér.add(btGomb[i]).setEnabled(false);
            btGomb[i].addActionListener(this);
//btÚjJáték.setEnabled(false);/*kezdéshez kell majd*/
        }
//        switch ((int) meretvalszto.getSelectedIndex()) {
//            case 0:
//                general(betű, pnJátéktér, 9);
//
//                break;
//            case 1:
//                general(betű, pnJátéktér, 12);
//                break;
//            case 2:
//                general(betű, pnJátéktér, 25);
//                break;
//
//        }

        add(pnJátéktér);
    }

//    public void general(Font betű, JPanel pnJátéktér, int x) {
//        /*3x3=9,4x4=12,5x5=25*/
//        for (int i = 1; i <= x; i++) {
//            btGomb[i] = new JButton();
//            btGomb[i].setFont(betű);
//            //btÚjJáték.setEnabled(false);/*kezdéshez kell majd*/
//            pnJátéktér.add(btGomb[i]).setEnabled(false);
//            btGomb[i].addActionListener(this);
//        }
//
//    }
// nem jó
    public void actionPerformed(ActionEvent a) {
        JButton btAktuális = (JButton) a.getSource();
        String játékos;
        if (btAktuális == btÚjJáték) {
            lépésSzám = 0;
            játékos = felirat[(lépésSzám + 1) % 2];
            lbÜzenet.setText((lépésSzám + 1) + ". lépés: " + játékos);
            /*3x3=9,4x4=16,5x5=25*/
            for (int i = 1; i <= x; i++) {
                btGomb[i].setText("");
                btGomb[i].setEnabled(true);
            }
        } else {  //pnJátéktér nyomógombjai
            lépésSzám++;
            játékos = felirat[(lépésSzám + 1) % 2];
            lbÜzenet.setText((lépésSzám + 1) + ". lépés: " + játékos);
            btAktuális.setText(felirat[lépésSzám % 2]);
            btAktuális.setEnabled(false);
            String nyertes = nyertes();
            if (!nyertes.equals("")) {
                lbÜzenet.setText("Eredmény: " + nyertes + " nyert!");
                for (int i = 1; i <= x; i++) {
                    btGomb[i].setEnabled(false);
                }
            } else if (lépésSzám == 9) {
                lbÜzenet.setText("Eredmény: döntetlen!");
            }
        }
    }

    private String nyertes() {
        int[] nyerő = {123, 456, 789, 147, 258, 369, 159, 357};
        String százas = "", tízes, egyes;
        for (int i : nyerő) {
            százas = btGomb[i / 100].getText();
            tízes = btGomb[i % 100 / 10].getText();
            egyes = btGomb[i % 100 % 10].getText();
            System.out.println("\n" + i + ": " + százas + " " + tízes + " " + egyes);
            if (százas.equals(tízes) && tízes.equals(egyes)) {
                return százas;
            }
        }
        return "";
    }
}
