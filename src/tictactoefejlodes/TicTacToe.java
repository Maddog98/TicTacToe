package tictactoefejlodes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JApplet
        implements ActionListener {

    private final String[] felirat = {"0", "X"};
    private JButton btÚjJáték = new JButton("Új játék");
    private JLabel lbÜzenet = new JLabel("1. lépés: X");
    private JButton btGomb[] = new JButton[10];  //1-9-ig kell
//  private JButton btGomb[]=new JButton[17];  //1-9-ig kell
//  private JButton btGomb[]=new JButton[26];  //1-9-ig kell
    private int lépésSzám = 0;
    private final String[] meretek = {"3x3", "4x4", "5x5"};
    private JComboBox meretvalszto = new JComboBox(meretek);
    private JPanel pnJátéktér = new JPanel(new GridLayout(3, 3));
//  private JPanel pnJátéktér=new JPanel(new GridLayout(4, 4));
//  private JPanel pnJátéktér=new JPanel(new GridLayout(5, 5));

    @Override
    public void init() {
        //mezo beállítás
        setSize(300, 350);
        JPanel pnEszköztár = new JPanel();
        pnEszköztár.add(btÚjJáték);
        pnEszköztár.add(meretvalszto);
        btÚjJáték.addActionListener(this);
        pnEszköztár.add(lbÜzenet);
        add(pnEszköztár, BorderLayout.NORTH);
        Font betű = new Font("Comic Sans MS", Font.BOLD, 60);
        
        for (int i = 1; i <= 9; i++) {
            btGomb[i] = new JButton();
            btGomb[i].setFont(betű);
            pnJátéktér.add(btGomb[i]);
            btGomb[i].addActionListener(this);
        }
        add(pnJátéktér);
    }

    public void actionPerformed(ActionEvent a) {
        JButton btAktuális = (JButton) a.getSource();
        String játékos;
        if (btAktuális == btÚjJáték) {
            lépésSzám = 0;
            játékos = felirat[(lépésSzám + 1) % 2];
            lbÜzenet.setText((lépésSzám + 1) + ". lépés: " + játékos);
            for (int i = 1; i <= 9; i++) {
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
                for (int i = 1; i <= 9; i++) {
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
