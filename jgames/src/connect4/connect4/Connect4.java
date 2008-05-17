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
package connect4.connect4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import connect4.players.*;
import connect4.board.Board;

/**
 * @author salvo
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class Connect4 implements ActionListener {
    
    String[] players = {
            "Human player",
            "Computer - Easy",
            "Computer - Medium",
            "Computer - Hard"
    };
    
    JComboBox cmbOpponent = new JComboBox(players);
    JButton cmdNew = new JButton("New game");
    JButton cmdAbout = new JButton("About this game");
    
    public static void main(String[] args){
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        new Connect4();
    }
    
    private Connect4(){
        About.printConsoleInfo();
        cmdNew.addActionListener(this);
        cmdAbout.addActionListener(this);
        
        JFrame win = new JFrame ("Connect 4 - New Game");
        
        win.add(cmbOpponent,BorderLayout.NORTH);
        win.add(cmdNew,BorderLayout.CENTER);
        win.add(cmdAbout,BorderLayout.SOUTH);
        win.setResizable(false);
        win.pack();
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();//Contains the source of the event
        
        if (button==cmdNew){//Set up a new game
            Board board = new Board();
            
            //TODO here user must chose the player
            Player pl1 = new Human(board);
            Player pl2=null;
            
            switch (cmbOpponent.getSelectedIndex()) {
                case 0:
                    pl2 = new Human(board);
                    break;
                case 1:
                    pl2 = new Easy(board);
                    break;
                case 2: 
                    pl2 = new Medium(board);
                    break;
                case 3:
                    pl2 = new Hard(board);
                    break;
            }     
            board.setPlayer(pl1,(byte)1);
            board.setPlayer(pl2,(byte)2);
        } else if (button==cmdAbout) {//Show about box
  
            About.showAbout();
        }
        
        
        
    }

}
