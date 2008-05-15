/*
jgames
Copyright (C) 2007  Salvo "LtWorf" Tomaselli

jgames is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

@author Salvo "LtWorf" Tomaselli <tiposchi@libero.it>

 */
package numbers;


/**
 * @author LtWorf
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.*;

public class Numeri extends JPanel implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = 2427771182331440756L;
    Color standard;
    //Caselle
    JButton[] casella = new JButton[8];
    
    //Il numero da piazzare nella casella
    byte numero;
    
    //Completa
    JButton about= new JButton("Help");
    JButton restart = new JButton("Restart");
    
    //Indirizzo sito
    JLabel lblWeb= new JLabel("galileo.dmi.unict.it/wiki/jgames");
    JLabel lblWeb1= new JLabel("galileo.dmi.unict.it/svn/jgames");
    public static void main(String[] args) {
       new Numeri();
       
        
    }
    
    public Numeri(){
        numero=0;        
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        JFrame frame = new JFrame("Numbers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setOpaque(true); 
        frame.setContentPane(this);
        
        frame.getContentPane().setLayout(null);
        
        //Aggiunge la label
        frame.getContentPane().add(lblWeb);
        lblWeb.setBounds(0,80,250,30);
        lblWeb.setForeground(Color.BLUE);
        
        frame.getContentPane().add(lblWeb1);
        lblWeb1.setBounds(0,110,250,30);
        lblWeb1.setForeground(Color.BLUE);
        
        //Aggiunge i pulsanti
        frame.getContentPane().add(about);
        about.setBounds(35,140,130,25);
        about.addActionListener(this);
        
        frame.getContentPane().add(restart);
        restart.setBounds(35,165,130,25);
        restart.addActionListener(this);
        
        for (int c=0; c< casella.length;c++){
            casella[c]= new JButton("   ");
            frame.getContentPane().add( casella[c]);
            casella[c].addActionListener(this);
        }            
        casella[0].setBounds(50,0,50,20);
        casella[1].setBounds(100,0,50,20);
        
        casella[2].setBounds(00,20,50,20);
        casella[3].setBounds(50,20,50,20);
        casella[4].setBounds(100,20,50,20);
        casella[5].setBounds(150,20,50,20);
        
        casella[6].setBounds(50,40,50,20);
        casella[7].setBounds(100,40,50,20);
        
        standard=casella[0].getBackground();
        
        
        frame.pack();
        frame.setBounds(10,10,260,225);        
        frame.setVisible(true);
        frame.setResizable(false);
   }
    
    private void init(){
        numero=0;
        about.setText("Help");
        
        for (int c=0; c< casella.length;c++){
            casella[c].setText("   ");
        	casella[c].setBackground(standard);
        }
                    
    }

    
    public void actionPerformed(ActionEvent arg0) {
        JButton pulsante = (JButton)arg0.getSource();
        for (int c=0; c< casella.length;c++){
            if (pulsante==casella[c] && casella[c].getText().equals("   ")) casella[c].setText(Byte.toString(++numero));
            if (numero==8) controlla();
        }  
        if (pulsante==about) JOptionPane.showMessageDialog(this,
                "Rules are very simple: \n"+"You must place a number in each box, you start placing 1 and you end placing 8 \n"+
                "When you have filled all the boxes, Numbers will check what you have done. \n"+
                "To win, each number must be far from number+1 and number-1\n"+
                "\n Under GNU GPLv3\n\nAuthor: Salvo Tomaselli <tiposchi@libero.it>"
                ,"Numbers", JOptionPane.PLAIN_MESSAGE);
        else if (pulsante==restart) this.init();
		} 
    
    
    private void controlla(){
        /*
         * 		|---|---|
         * 		| 0 | 1 |
         * 	|---|---|---|---|
         *  | 2 | 3 | 4 | 5 | 
         * 	|---|---|---|---|
         *  	| 6 | 7 |
         * 		|---|---|
         */
        boolean errato=false;
        byte adiacenti[][]= {
            {1,2,3,4},
            {0,3,4,5},
            {0,3,6},
            {0,1,4,7,6,2},
            {1,5,7,6,3,0},
            {1,4,7},
            {2,3,4,7},
            {6,3,4,5}
        };
        
        for (byte c=0;c<casella.length;c++){
            byte n= Byte.parseByte(casella[c].getText());
            for (byte i=0;i<adiacenti[c].length;i++){
                byte nAdiacente= Byte.parseByte(casella[ adiacenti[c][i] ].getText());
                
                if (((n+1)==nAdiacente)||((n-1)==nAdiacente)){
                    casella[c].setBackground(Color.RED);
                    errato=true;
                }
            }
            
        }
        
        if (errato==false) about.setText("You win!");
    }
}
