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
package connect4.board;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author salvo
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class ScreenBoard implements ActionListener {
    
    private JButton[][] cells;
    private JPanel board = new JPanel();
    
    protected static final int CELL_SIZE=40;
    
    private JFrame win= new JFrame ("Connect 4 - Board");
    
    protected JLabel lbl1 = new JLabel(" ");
    protected JLabel lbl2 = new JLabel(" ");
    
    
    private ArrayList listeners = new ArrayList();
    
    public ScreenBoard(int rows,int cols){
        //Create the graphical board
        cells = new JButton[rows][cols];
        board.setLayout(null);
        for (int r=0; r<rows;r++){
            for (int c=0;c<cols;c++){
                cells[r][c] = new JButton();
                cells[r][c].setBackground(Color.WHITE);
                board.add(cells[r][c]);
                cells[r][c].setBounds(c*CELL_SIZE,r*CELL_SIZE,CELL_SIZE,CELL_SIZE);
                cells[r][c].addActionListener(this);
            }
        }
        
        board.setPreferredSize(new Dimension(cols*CELL_SIZE,rows*CELL_SIZE));
        win.getContentPane().add(board,BorderLayout.CENTER);
        
        lbl1.setForeground(Color.red);
        lbl2.setForeground(new Color(100,100,0));
        win.getContentPane().add(lbl1,BorderLayout.NORTH);
        win.getContentPane().add(lbl2,BorderLayout.SOUTH);
        win.setResizable(false);
        win.pack();
        win.setVisible(true);
        
    }

    /**
     * Freezes the board when the game is finished
     *
     */
    protected void endGame(){
        for (int r=0; r<cells.length;r++){
            for (int c=0;c<cells[0].length;c++){
                cells[r][c].setEnabled(false);

            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        //Find out what was the pressed button.
        JButton pressed = (JButton)e.getSource();
        int row=0;
        int col=0;
        
        for (int r=0; r<cells.length;r++){
            for (int c=0;c<cells[0].length;c++){
                if (cells[r][c] == pressed){
                    row=r;col=c;
                }
                
            }
        }
        
        
        for (int a=0; a<listeners.size();a++){
            CellEvent event = (CellEvent)listeners.get(a);
            if (event.move()) {
                event.cellPress(row,col);
                break;
            }
        }
            
        
    }
    
    /**
     * Adds a listener
     * @param c
     */
    public void addCellEventListener(CellEvent c){
        listeners.add(c);
    }
    
    
    /**
     * Refresh the table
     * @param vals
     */
    public void refresh(byte[][] vals){
        for (int r=0; r<vals.length;r++){
            for (int c=0;c<vals[0].length;c++){
               
              if (vals[r][c]==Board.PLAYER1){
                  if (cells[r][c].getBackground()!=Color.RED)
                      cells[r][c].setBackground(Color.RED);
              }
              
              if (vals[r][c]==Board.PLAYER2){
                  if (cells[r][c].getBackground()!=Color.YELLOW)
                      cells[r][c].setBackground(Color.YELLOW);
              }
                              
                
                               
                
            }
        }
    }

}
