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
package jmines.util;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import jmines.jMines.Board;
import jmines.jMines.Cell;
import jmines.jMines.CellWrapper;
import jmines.jMines.GameBoard;
import jmines.jMines.Menus;

public class MinePlacer {    
    /**
     * Creates the board, placing mines. Then the CellWrapper[] are ready to be placed
     * inside a JPanel.
     * @param rows of the board
     * @param cols of the board
     * @param mines to place in it
     * @return CellWrapper[][]
     */
    public static CellWrapper[][] createBoard(int rows,int cols, int mines,Board board) {
        Cell[][] cells = new Cell[rows][cols];
        CellWrapper[][] wrappers = new CellWrapper[rows][cols];
        
        for (int r=0;r<rows;r++) {
            for (int c=0;c<cols;c++) {      
                cells[r][c] = new Cell();
                wrappers[r][c] = new CellWrapper(cells[r][c],board);                
            }
        }
        
        //Placing the mines
        for (int i=0;i<mines;i++) {
            int row = (int)(Math.random()*rows);
            int col = (int)(Math.random()*cols);
            if (cells[row][col].isMined()==false) {
                cells[row][col].setMined(true);                
            } else {
                i--;
            }
        }
        

//      TODO controllare quante mine ha una cella nei suoi dintorni.
        for (int r=0;r<rows;r++) {
            for (int c=0;c<cols;c++) {
                ArrayList near = new ArrayList();
                byte mineCount=0;
                
                try {
                    near.add(wrappers[r-1][c-1]);
                    if (cells[r-1][c-1].isMined()) mineCount++;
                } catch (Exception e) {}
                try {
                    near.add(wrappers[r-1][c]);
                    if (cells[r-1][c].isMined()) mineCount++;
                } catch (Exception e) {}
                try {
                    near.add(wrappers[r-1][c+1]);
                    if (cells[r-1][c+1].isMined()) mineCount++;
                } catch (Exception e) {}
                try {
                    near.add(wrappers[r][c-1]);
                    if (cells[r][c-1].isMined()) mineCount++;
                } catch (Exception e) {
                 
                }
                try {
                    near.add(wrappers[r][c+1]);
                    if (cells[r][c+1].isMined()) mineCount++;
                } catch (Exception e) {
                 
                } try {
                    near.add(wrappers[r+1][c-1]);
                    if (cells[r+1][c-1].isMined()) mineCount++;
                } catch (Exception e) {
                  
                } try {
                    near.add(wrappers[r+1][c]);
                    if (cells[r+1][c].isMined()) mineCount++;
                } catch (Exception e) {
                   
                } try {
                    near.add(wrappers[r+1][c+1]);
                    if (cells[r+1][c+1].isMined()) mineCount++;
                } catch (Exception e) {
                    
                }
                
                cells[r][c].setValue(mineCount); 
                CellWrapper[] around = new CellWrapper[near.size()];
               for (int n=0;n<around.length;n++) {
                   around[n]=(CellWrapper)near.get(n);
               }
                
               
                wrappers[r][c].setAround(around);               
            }
        }
        
        return wrappers;
    }
    
    public static void newGame(int rows,int cols,int mines) {
    	MineFrame frame = new MineFrame("JMines");        
        frame.getContentPane().add(new GameBoard(rows,cols,mines),BorderLayout.CENTER);
        Menus m =new Menus();
        frame.getContentPane().add(m,BorderLayout.NORTH);
        
        frame.pack();
        frame.setSize(GameBoard.CELL_SIZE_H*(cols+1),GameBoard.CELL_SIZE_V*(rows+2)+m.getSize().height);
        frame.setVisible(true);
        
    }

}

class MineFrame extends JFrame implements WindowListener {
	

	static int count=0;
	
	public MineFrame(String title) {
		this.setTitle(title);
		this.addWindowListener(this);
		count++;		
	}

	public void windowActivated(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}

	public void windowClosing(WindowEvent e) {
		count--;	
		if (count==0) System.exit(0);
	}
	public void windowDeactivated(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}	
}
