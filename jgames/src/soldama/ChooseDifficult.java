/*
jgames
Copyright (C) 2007  Salvo "LtWorf" Tomaselli

Weborf is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

@author Salvo "LtWorf" Tomaselli <ltworf@galileo.dmi.unict.it>

 */
package soldama;

/**
 * @author Salvo Tomaselli
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ChooseDifficult extends JFrame implements ActionListener{
	JButton OptEasy;
	JButton OptMedium;
	JButton OptHard;
	
	JButton cmdOk;
	
	byte difficult=1;

	public ChooseDifficult(){

        getContentPane().setFont(new Font("Verdana", Font.PLAIN, 10));
        getContentPane().setLayout(null);
        
        
        //Easy
        OptEasy = new JButton("Easy (64)");
        getContentPane().add(OptEasy);
        OptEasy.setBounds(5,5,120,30);
        OptEasy.addActionListener(this);
        
        //Medium
        OptMedium = new JButton("Medium (52)");
        getContentPane().add(OptMedium);
        OptMedium.setBounds(5,35,120,30);
        OptMedium.addActionListener(this);
        
        //Hard
        OptHard = new JButton("Hard (44)");
        getContentPane().add(OptHard);
        OptHard.setBounds(5,65,120,30);
        OptHard.addActionListener(this);
        
        //Ok
        cmdOk = new JButton("Ok");
        getContentPane().add(cmdOk);
        cmdOk.setBounds(20,110,90,20);
        cmdOk.addActionListener(this);
        
		
	}


	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
	    if(e.getSource()==OptEasy)difficult=0;
	    if(e.getSource()==OptMedium)difficult=1;
		if(e.getSource()==OptHard)difficult=2;
		
		if(e.getSource()==cmdOk)this.setVisible(false);
		
	}
	/**
	 * This method places the pieces following the difficult preferences
	 * 
	 * @param Tabella This is the array of JButtons
	 * @return The number of pieces!
	 */
	public byte placePieces(JButton Tabella[][],JLabel counter){
	    byte p=0;
	    
    	for (byte x = 0; x <11 ; x++){	
    		for (byte y=0; y<11; y++){
    			Tabella[x][y].setBackground(Color.GREEN);    			
    		}
    	}
	    
	    switch (difficult){
	    	case 0: //Easy
	    	    p=64;
	    	    Tabella[4][0].setBackground(Color.RED);
	    	    Tabella[5][0].setBackground(Color.RED);
	    	    Tabella[6][0].setBackground(Color.RED);
	    	    
	    	    Tabella[3][1].setBackground(Color.RED);
	    	    Tabella[4][1].setBackground(Color.RED);
	    	    Tabella[5][1].setBackground(Color.RED);
	    	    Tabella[6][1].setBackground(Color.RED);
	    	    Tabella[7][1].setBackground(Color.RED);
	    	    
	    	    Tabella[3][2].setBackground(Color.RED);
	    	    Tabella[4][2].setBackground(Color.RED);
	    	    Tabella[5][2].setBackground(Color.RED);
	    	    Tabella[6][2].setBackground(Color.RED);
	    	    Tabella[7][2].setBackground(Color.RED);
	    	    
	    	    Tabella[1][3].setBackground(Color.RED);
	    	    Tabella[2][3].setBackground(Color.RED);
	    	    Tabella[4][3].setBackground(Color.RED);
	    	    Tabella[5][3].setBackground(Color.RED);
	    	    Tabella[6][3].setBackground(Color.RED);	    	    
	    	    Tabella[8][3].setBackground(Color.RED);
	    	    Tabella[9][3].setBackground(Color.RED);
	    	    
	    	    Tabella[0][4].setBackground(Color.RED);
	    	    Tabella[1][4].setBackground(Color.RED);
	    	    Tabella[2][4].setBackground(Color.RED);
	    	    Tabella[3][4].setBackground(Color.RED);
	    	    Tabella[7][4].setBackground(Color.RED);	    	    
	    	    Tabella[8][4].setBackground(Color.RED);
	    	    Tabella[9][4].setBackground(Color.RED);
	    	    Tabella[10][4].setBackground(Color.RED);
	    	    
	    	    Tabella[0][5].setBackground(Color.RED);
	    	    Tabella[1][5].setBackground(Color.RED);
	    	    Tabella[2][5].setBackground(Color.RED);
	    	    Tabella[3][5].setBackground(Color.RED);
	    	    Tabella[7][5].setBackground(Color.RED);
	    	    Tabella[8][5].setBackground(Color.RED);
	    	    Tabella[9][5].setBackground(Color.RED);
	    	    Tabella[10][5].setBackground(Color.RED);
	    	    
	    	    Tabella[0][6].setBackground(Color.RED);
	    	    Tabella[1][6].setBackground(Color.RED);
	    	    Tabella[2][6].setBackground(Color.RED);
	    	    Tabella[3][6].setBackground(Color.RED);
	    	    Tabella[7][6].setBackground(Color.RED);
	    	    Tabella[8][6].setBackground(Color.RED);
	    	    Tabella[9][6].setBackground(Color.RED);
	    	    Tabella[10][6].setBackground(Color.RED);
	    	    
	    	    Tabella[1][7].setBackground(Color.RED);
	    	    Tabella[2][7].setBackground(Color.RED);
	    	    Tabella[4][7].setBackground(Color.RED);
	    	    Tabella[5][7].setBackground(Color.RED);
	    	    Tabella[6][7].setBackground(Color.RED);
	    	    Tabella[8][7].setBackground(Color.RED);
	    	    Tabella[9][7].setBackground(Color.RED);
	    	    
	    	    Tabella[3][8].setBackground(Color.RED);
	    	    Tabella[4][8].setBackground(Color.RED);
	    	    Tabella[5][8].setBackground(Color.RED);
	    	    Tabella[6][8].setBackground(Color.RED);
	    	    Tabella[7][8].setBackground(Color.RED);
	    	    
	    	    Tabella[3][9].setBackground(Color.RED);
	    	    Tabella[4][9].setBackground(Color.RED);
	    	    Tabella[5][9].setBackground(Color.RED);
	    	    Tabella[6][9].setBackground(Color.RED);
	    	    Tabella[7][9].setBackground(Color.RED);
	    	    
	    	    Tabella[4][10].setBackground(Color.RED);
	    	    Tabella[5][10].setBackground(Color.RED);
	    	    Tabella[6][10].setBackground(Color.RED);

	    	break;
	    	case 1: // Standard
	    	    p=52;
	    	    Tabella[4][0].setBackground(Color.RED);
	    	    Tabella[5][0].setBackground(Color.RED);
	    	    Tabella[6][0].setBackground(Color.RED);
	    	    
	    	    Tabella[3][1].setBackground(Color.RED);
	    	    Tabella[4][1].setBackground(Color.RED);
	    	    Tabella[5][1].setBackground(Color.RED);
	    	    Tabella[6][1].setBackground(Color.RED);
	    	    Tabella[7][1].setBackground(Color.RED);
	    	    
	    	    Tabella[3][2].setBackground(Color.RED);
	    	    Tabella[4][2].setBackground(Color.RED);
	    	    Tabella[5][2].setBackground(Color.RED);
	    	    Tabella[6][2].setBackground(Color.RED);
	    	    Tabella[7][2].setBackground(Color.RED);
	    	    
	    	    Tabella[1][3].setBackground(Color.RED);
	    	    Tabella[2][3].setBackground(Color.RED);
	    	    Tabella[8][3].setBackground(Color.RED);
	    	    Tabella[9][3].setBackground(Color.RED);
	    	    
	    	    Tabella[0][4].setBackground(Color.RED);
	    	    Tabella[1][4].setBackground(Color.RED);
	    	    Tabella[2][4].setBackground(Color.RED);
	    	    Tabella[8][4].setBackground(Color.RED);
	    	    Tabella[9][4].setBackground(Color.RED);
	    	    Tabella[10][4].setBackground(Color.RED);
	    	    
	    	    Tabella[0][5].setBackground(Color.RED);
	    	    Tabella[1][5].setBackground(Color.RED);
	    	    Tabella[2][5].setBackground(Color.RED);
	    	    Tabella[8][5].setBackground(Color.RED);
	    	    Tabella[9][5].setBackground(Color.RED);
	    	    Tabella[10][5].setBackground(Color.RED);
	    	    
	    	    Tabella[0][6].setBackground(Color.RED);
	    	    Tabella[1][6].setBackground(Color.RED);
	    	    Tabella[2][6].setBackground(Color.RED);
	    	    Tabella[8][6].setBackground(Color.RED);
	    	    Tabella[9][6].setBackground(Color.RED);
	    	    Tabella[10][6].setBackground(Color.RED);
	    	    
	    	    Tabella[1][7].setBackground(Color.RED);
	    	    Tabella[2][7].setBackground(Color.RED);
	    	    Tabella[8][7].setBackground(Color.RED);
	    	    Tabella[9][7].setBackground(Color.RED);
	    	    
	    	    Tabella[3][8].setBackground(Color.RED);
	    	    Tabella[4][8].setBackground(Color.RED);
	    	    Tabella[5][8].setBackground(Color.RED);
	    	    Tabella[6][8].setBackground(Color.RED);
	    	    Tabella[7][8].setBackground(Color.RED);
	    	    
	    	    Tabella[3][9].setBackground(Color.RED);
	    	    Tabella[4][9].setBackground(Color.RED);
	    	    Tabella[5][9].setBackground(Color.RED);
	    	    Tabella[6][9].setBackground(Color.RED);
	    	    Tabella[7][9].setBackground(Color.RED);
	    	    
	    	    Tabella[4][10].setBackground(Color.RED);
	    	    Tabella[5][10].setBackground(Color.RED);
	    	    Tabella[6][10].setBackground(Color.RED);
	    	    
	    	break;
	    	
	    	case 2: //Hard
	    	    
	    	    p=44;
	    	    Tabella[5][0].setBackground(Color.RED);
	    	    
	    	    Tabella[3][1].setBackground(Color.RED);
	    	    Tabella[4][1].setBackground(Color.RED);
	    	    Tabella[5][1].setBackground(Color.RED);
	    	    Tabella[6][1].setBackground(Color.RED);
	    	    Tabella[7][1].setBackground(Color.RED);
	    	    
	    	    Tabella[3][2].setBackground(Color.RED);
	    	    Tabella[4][2].setBackground(Color.RED);
	    	    Tabella[5][2].setBackground(Color.RED);
	    	    Tabella[6][2].setBackground(Color.RED);
	    	    Tabella[7][2].setBackground(Color.RED);
	    	    
	    	    Tabella[2][3].setBackground(Color.RED);
	    	    Tabella[8][3].setBackground(Color.RED);
	    	    	    	    
	    	    Tabella[0][4].setBackground(Color.RED);
	    	    Tabella[1][4].setBackground(Color.RED);
	    	    Tabella[2][4].setBackground(Color.RED);
	    	    Tabella[8][4].setBackground(Color.RED);
	    	    Tabella[9][4].setBackground(Color.RED);
	    	    Tabella[10][4].setBackground(Color.RED);
	    	    
	    	    Tabella[0][5].setBackground(Color.RED);
	    	    Tabella[1][5].setBackground(Color.RED);
	    	    Tabella[2][5].setBackground(Color.RED);
	    	    Tabella[8][5].setBackground(Color.RED);
	    	    Tabella[9][5].setBackground(Color.RED);
	    	    Tabella[10][5].setBackground(Color.RED);
	    	    
	    	    Tabella[0][6].setBackground(Color.RED);
	    	    Tabella[1][6].setBackground(Color.RED);
	    	    Tabella[2][6].setBackground(Color.RED);
	    	    Tabella[8][6].setBackground(Color.RED);
	    	    Tabella[9][6].setBackground(Color.RED);
	    	    Tabella[10][6].setBackground(Color.RED);
	    	    
	    	    Tabella[2][7].setBackground(Color.RED);
	    	    Tabella[8][7].setBackground(Color.RED);
	    	    
	    	    Tabella[3][8].setBackground(Color.RED);
	    	    Tabella[4][8].setBackground(Color.RED);
	    	    Tabella[5][8].setBackground(Color.RED);
	    	    Tabella[6][8].setBackground(Color.RED);
	    	    Tabella[7][8].setBackground(Color.RED);
	    	    
	    	    Tabella[3][9].setBackground(Color.RED);
	    	    Tabella[4][9].setBackground(Color.RED);
	    	    Tabella[5][9].setBackground(Color.RED);
	    	    Tabella[6][9].setBackground(Color.RED);
	    	    Tabella[7][9].setBackground(Color.RED);
	    	    
	    	    Tabella[5][10].setBackground(Color.RED);
	    	    	    	    
	    	break;
	    }
	    counter.setText("Left:" + p);
	    return p;
	    
	}


	

}
