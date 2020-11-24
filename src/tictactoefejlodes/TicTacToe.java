package tictactoefejlodes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JApplet implements ActionListener {
  private final String[] felirat={"0", "X"};
  private final String[]meretek={"3x3","4x4","5x5"};
  private JComboBox meretvalszto= new JComboBox(meretek);
 private static int y=3;
  private final JPanel pnJátéktér=new JPanel(new GridLayout(y,y));//3x3,4x4,5x5  
       
  private JButton btÚjJáték=new JButton("Új játék");
  private JLabel lbÜzenet=new JLabel("1. lépés: X");
  private JButton btGomb[]=new JButton[26];   //1-9-ig kell 10, 13, 26  
  private int lépésSzám=0;
  private int x=9;
  
  @Override
  public void init() {
    setSize(300, 350);
    JPanel pnEszköztár=new JPanel();
    pnEszköztár.add(btÚjJáték);
    pnEszköztár.add(meretvalszto);
    btÚjJáték.addActionListener(this);
    pnEszköztár.add(lbÜzenet);
    add(pnEszköztár, BorderLayout.NORTH);
        general(x);
       meretvalszto.addActionListener(this);
  }
 
    public void general(int x) {
      
         /*3x3=9,4x4=12,5x5=25*/for(int i=1; i<=x; i++) {
           Font betű=new Font("Comic Sans MS", Font.BOLD, 60);
            btGomb[i]=new JButton();
            btGomb[i].setFont(betű);
            //btÚjJáték.setEnabled(false);/*kezdéshez kell majd*/
            pnJátéktér.add(btGomb[i]);
            btGomb[i].addActionListener(this);
        }
           add(pnJátéktér);  
           
    }private void logika() {
      

  int xyIndex =meretvalszto.getSelectedIndex();
      switch(xyIndex) {
  case 0:
      System.out.println(xyIndex);
  x=9;
  pnJátéktér.removeAll();
  y=3;
  pnJátéktér.setLayout(new GridLayout(y, y));
      System.out.println(x);
      general(x);  
    //gridLayout=new GridLayout(3, 3);
    break;
  case 1:
  x=16;
  y=4;
  pnJátéktér.setLayout(new GridLayout(y, y));
  System.out.println(xyIndex);
    pnJátéktér.removeAll(); 
    System.out.println(x);
      general(x);
   
    break;
  case 2:
       x=25;
       y=5;
  pnJátéktér.setLayout(new GridLayout(y, y));
       System.out.println(xyIndex);
    pnJátéktér.removeAll();
    System.out.println(x);
      general(x);
      
    break;
  
}}
<<<<<<< HEAD
 
  @Override
  public void actionPerformed(ActionEvent a) {
      logika();
JButton btAktuális=(JButton)a.getSource();
=======
    
  @Override
  public void actionPerformed(ActionEvent a) {
      logika();
  
>>>>>>> e75c541053fbfbcb51a0082b28210ef58f021e8f
    String játékos;
   
   
//    if(btAktuális==btÚjJáték) {
//      lépésSzám=0;
//      játékos=felirat[(lépésSzám+1)%2];
//      lbÜzenet.setText((lépésSzám+1)+". lépés: "+játékos);
//     /*3x3=9,4x4=16,5x5=25*/for(int i=1; i<=x; i++) {
//        btGomb[i].setText("");
//        btGomb[i].setEnabled(true);
//        
//      }
//    }
//    else {  //pnJátéktér nyomógombjai
//      lépésSzám++;
//      játékos=felirat[(lépésSzám+1)%2];
//      lbÜzenet.setText((lépésSzám+1)+". lépés: "+játékos);
//      btAktuális.setText(felirat[lépésSzám%2]);
//      btAktuális.setEnabled(false);
//      String nyertes=nyertes();
//      if(!nyertes.equals("")) {
//        lbÜzenet.setText("Eredmény: "+nyertes+" nyert!");
//        for(int i=1; i<=x; i++)
//          btGomb[i].setEnabled(false);
//      }
//      else if(lépésSzám==9)
//        lbÜzenet.setText("Eredmény: döntetlen!");
//    }
  }
  
  private String nyertes() {
    int[] nyerő={123, 456, 789, 147, 258, 369, 159, 357};
    String százas="", tízes, egyes;
    for(int i: nyerő) {
      százas=btGomb[i/100].getText();
      tízes=btGomb[i%100/10].getText();
      egyes=btGomb[i%100%10].getText();
      System.out.println("\n"+i+": "+százas+" "+tízes+" "+egyes);
      if(százas.equals(tízes) && tízes.equals(egyes))
        return százas;
    }
    return "";
  }

    
}

