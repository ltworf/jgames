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

import soldama.selectedPiece.SelectedPiece;

public class Solitario extends JFrame 
implements ActionListener{
	
	JButton[][] Tabella = new JButton[11][11];
	JButton EndGame = new JButton("End game");
	JButton cmdDifficult = new JButton("Difficult");
	JLabel lblCounter= new JLabel();
	JLabel lblWeb= new JLabel("http://supersalvus.altervista.org");
	JLabel lblWeb1= new JLabel("sourceforge.net/projects/smallgamesc/");
	
	SelectedPiece piece= new SelectedPiece();
	
	ChooseDifficult difficult = new ChooseDifficult();
	
	public boolean SetDifficult(byte Difficult){
		return true;
	}
	
    public Solitario() {
           
            getContentPane().setLayout(null);
            
            { 
            	getContentPane().add(EndGame);
            	EndGame.setBounds(30,230,150,20);            	
            	EndGame.addActionListener(this);
            	
            	getContentPane().add(cmdDifficult);
            	cmdDifficult.setBounds(30,253,150,20);
            	cmdDifficult.addActionListener(this);
            	
            	getContentPane().add(lblCounter);
            	lblCounter.setBounds(143,0,100,20);
            	
            	getContentPane().add(lblWeb);
            	lblWeb.setBounds(5,283,260,20);
            	
            	getContentPane().add(lblWeb1);
            	lblWeb1.setBounds(2,303,260,20);
            	
            	
            	for (byte x = 0; x <11 ; x++){//Crea la tabella   		
            		for (byte y=0; y<11; y++){
            		    Tabella[x][y]= new JButton("");
            		    getContentPane().add(Tabella[x][y]);
            			Tabella[x][y].setBounds(x*20,y*20,20,20);    
            			Tabella[x][y].addActionListener(this);   			
            		}
            	}
            	
            	{//Elimina alcune caselle per dare la giusta forma alla scacchiera
            		Tabella[0][0].setVisible(false);
            		Tabella[0][1].setVisible(false);
            		Tabella[0][2].setVisible(false);
            		Tabella[0][3].setVisible(false);
            		Tabella[0][7].setVisible(false);
            		Tabella[0][8].setVisible(false);
            		Tabella[0][9].setVisible(false);
            		Tabella[0][10].setVisible(false);		
            		Tabella[1][0].setVisible(false);
            		Tabella[1][1].setVisible(false);
            		Tabella[1][2].setVisible(false);
            		Tabella[1][8].setVisible(false);
            		Tabella[1][9].setVisible(false);
            		Tabella[1][10].setVisible(false);		
            		Tabella[2][0].setVisible(false);
            		Tabella[2][1].setVisible(false);
            		Tabella[2][2].setVisible(false);
            		Tabella[2][8].setVisible(false);
            		Tabella[2][9].setVisible(false);
            		Tabella[2][10].setVisible(false);		
            		Tabella[3][0].setVisible(false);
            		Tabella[3][10].setVisible(false);		
            		Tabella[7][0].setVisible(false);
            		Tabella[7][10].setVisible(false);		
            		Tabella[8][0].setVisible(false);
            		Tabella[8][1].setVisible(false);
            		Tabella[8][2].setVisible(false);
            		Tabella[8][8].setVisible(false);
            		Tabella[8][9].setVisible(false);
            		Tabella[8][10].setVisible(false);		
            		Tabella[9][0].setVisible(false);
            		Tabella[9][1].setVisible(false);
            		Tabella[9][2].setVisible(false);
            		Tabella[9][8].setVisible(false);
            		Tabella[9][9].setVisible(false);
            		Tabella[9][10].setVisible(false);		
            		Tabella[10][0].setVisible(false);
            		Tabella[10][1].setVisible(false);
            		Tabella[10][2].setVisible(false);
            		Tabella[10][3].setVisible(false);
            		Tabella[10][7].setVisible(false);
            		Tabella[10][8].setVisible(false);
            		Tabella[10][9].setVisible(false);
            		Tabella[10][10].setVisible(false);
            	}
		
            	//Posiziona i pezzi sulla scacchiera
            	piece.remaining= difficult.placePieces(Tabella,lblCounter);
            	
            		
            }
            
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
            
            
    		this.pack(); 	
    		this.setBounds(20,20,260,360);
    		this.setResizable(false);
    		this.setTitle("Solitario Dama");
    		this.setVisible(true);	

        
    }
    
	public void actionPerformed(ActionEvent arg0) {		
		JButton b = (JButton)arg0.getSource();
		if (b==EndGame){
		    piece.remaining= difficult.placePieces(Tabella,lblCounter);
		    piece.eat=0;
		} else if (b==cmdDifficult){
			System.out.println("Show difficult window");
		    difficult.pack();
		    difficult.setVisible(true);
			
		    difficult.setBounds(40,40,140,190);		    
		    difficult.setFocusable(true);
		    difficult.setResizable(false);
			difficult.setTitle("Choose difficult");			
		} else {
		    //Compara il pulsante che � stato premuto con i pulsanti della tabella
        	for (byte x = 0; x <11 ; x++){        	    
        		for (byte y=0; y<11; y++){
        		    if(Tabella[x][y]==b){
        		        this.buttonPressed(x,y);
        		        break;
        		    }
        		       			
        		}
        	}		    
		}
	}
	
	private void buttonPressed(byte x,byte y){
	    System.out.println("Selected piece         x:"+piece.x +"         y:"+piece.y);
	    System.out.println("Pressed piece         x:"+x +"         y:"+y);
	    if ((piece.selected==false)&&(Tabella[x][y].getBackground()==Color.RED)){	        
	        //Select the piece
	        piece.selected=true;
	        piece.x=x;
	        piece.y=y;
	        Tabella[x][y].setBackground(Color.BLUE);
	    } else {
	        
	        if ((x==piece.x)&&(y==piece.y)){
	            //Deseleziona il pezzo selezionato
	            Tabella[x][y].setBackground(Color.RED);
	            piece.selected=false;
	            System.out.println("Unselecting piece");
	        } else if(((x==piece.x+1)||(x==piece.x-1))||((y==piece.y+1)||(y==piece.y-1))) {
	            // Se cerco di muovere in una casella adiacente
	            JOptionPane.showMessageDialog(null, "Can't move here", "",JOptionPane.WARNING_MESSAGE);
	        } else if((y==piece.y)&&(x==piece.x+2)&&(Tabella[x-1][y].getBackground()==Color.RED)&&(Tabella[x][y].getBackground()==Color.GREEN)){
	            //Muovo a destra!	            
	            Tabella[x-1][y].setBackground(Color.GREEN);//Elimino il pezzo nel mezzo
	            this.eat(x,y);
	        } else if((y==piece.y)&&(x==piece.x-2)&&(Tabella[x+1][y].getBackground()==Color.RED)&&(Tabella[x][y].getBackground()==Color.GREEN)){
	            //Muovo a sinistra!	            
	            Tabella[x+1][y].setBackground(Color.GREEN);//Elimino il pezzo nel mezzo
	            this.eat(x,y);
	        } else if((y==piece.y)&&(x==piece.x+4)&&(Tabella[x-2][y].getBackground()==Color.RED)&&(Tabella[x][y].getBackground()==Color.GREEN)){
	            //Muovo a destra con salto!	            
	            Tabella[x-2][y].setBackground(Color.GREEN);//Elimino il pezzo nel mezzo
	            this.eat(x,y);
	        } else if((y==piece.y)&&(x==piece.x-4)&&(Tabella[x+2][y].getBackground()==Color.RED)&&(Tabella[x][y].getBackground()==Color.GREEN)){
	            //Muovo a sinistra con salto!	            
	            Tabella[x+2][y].setBackground(Color.GREEN);//Elimino il pezzo nel mezzo
	            this.eat(x,y);
	        } else if((x==piece.x)&&(y==piece.y+2)&&(Tabella[x][y-1].getBackground()==Color.RED)&&(Tabella[x][y].getBackground()==Color.GREEN)){
	            //Muovo in basso!
	            Tabella[x][y-1].setBackground(Color.GREEN);//Elimino il pezzo nel mezzo
	            this.eat(x,y);
	        } else if((x==piece.x)&&(y==piece.y-2)&&(Tabella[x][y+1].getBackground()==Color.RED)&&(Tabella[x][y].getBackground()==Color.GREEN)){
	            //Muovo a sinistra!
	            Tabella[x][y+1].setBackground(Color.GREEN);//Elimino il pezzo nel mezzo
	            this.eat(x,y);
	        } else if((x==piece.x)&&(y==piece.y+4)&&(Tabella[x][y-2].getBackground()==Color.RED)&&(Tabella[x][y].getBackground()==Color.GREEN)){
	            //Muovo in basso con salto!
	            Tabella[x][y-2].setBackground(Color.GREEN);//Elimino il pezzo nel mezzo
	            this.eat(x,y);
	        } else if((x==piece.x)&&(y==piece.y-4)&&(Tabella[x][y+2].getBackground()==Color.RED)&&(Tabella[x][y].getBackground()==Color.GREEN)){
	            //Muovo in alto con salto!
	            Tabella[x][y+2].setBackground(Color.GREEN);//Elimino il pezzo nel mezzo
	            this.eat(x,y);
	        } else if(((x==piece.x+2)&&(y==piece.y+2))&&(Tabella[x-1][y-1].getBackground()==Color.RED)&&(Tabella[x][y].getBackground()==Color.GREEN)){
	            //Diagonale basso destra
	            Tabella[x-1][y-1].setBackground(Color.GREEN);
	            this.eat(x,y);
	        } else if(((x==piece.x-2)&&(y==piece.y-2))&&(Tabella[x+1][y+1].getBackground()==Color.RED)&&(Tabella[x][y].getBackground()==Color.GREEN)){
	            //Diagonale alto sinistra
	            Tabella[x+1][y+1].setBackground(Color.GREEN);
	            this.eat(x,y);
	        } else if(((x==piece.x-2)&&(y==piece.y+2))&&(Tabella[x+1][y-1].getBackground()==Color.RED)&&(Tabella[x][y].getBackground()==Color.GREEN)){
	            //Diagonale basso sinistra
	            Tabella[x+1][y-1].setBackground(Color.GREEN);
	            this.eat(x,y);
	        } else if(((x==piece.x+2)&&(y==piece.y-2))&&(Tabella[x-1][y+1].getBackground()==Color.RED)&&(Tabella[x][y].getBackground()==Color.GREEN)){
	            //Diagonale alto destra
	            Tabella[x-1][y+1].setBackground(Color.GREEN);
	            this.eat(x,y);
	        }    
	    }
	}
	
	private void eat(byte x,byte y){
	    Tabella[x][y].setBackground(Color.RED);
        Tabella[piece.x][piece.y].setBackground(Color.GREEN);
        
	    piece.eat++;//Aumento i pezzi mangiati
        piece.remaining--;//Riduco pi pezzi rimanenti
        piece.selected=false;//Deseleziono
        lblCounter.setText("Left:" + piece.remaining);
        if (piece.remaining==1) JOptionPane.showMessageDialog(null, "Congratulations!!! You did it!", "Solitario Dama",JOptionPane.INFORMATION_MESSAGE);
	}
	
}
