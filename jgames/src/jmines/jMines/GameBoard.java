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
package jmines.jMines;

import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import jmines.util.MinePlacer;

public class GameBoard extends JPanel implements Board{
    

    private static final long serialVersionUID = 7438740428069020330L;
    public static final byte CELL_SIZE_H = 20;//Size of each cell
    public static final byte CELL_SIZE_V = 20;//Size of each cell
    
    private int cellCount;
    private int discoveredCells=0;
    CellWrapper[][] cells;
    
    public GameBoard(int rows, int cols, int mines) {
        cellCount=rows*cols-mines;
        cells = MinePlacer.createBoard(rows,cols,mines,this);
        
        //Generating the board
        this.setLayout(null);
        
        for (int r=0;r<cells.length;r++) {
            for (int c=0;c<cells[0].length;c++) {
                this.add(cells[r][c]);
                cells[r][c].setBounds(CELL_SIZE_H*c,CELL_SIZE_V*r,CELL_SIZE_H,CELL_SIZE_V);
            }
        }
        this.setSize(CELL_SIZE_H*cols,CELL_SIZE_V*rows);
        this.setMinimumSize(new Dimension(CELL_SIZE_H*cols,CELL_SIZE_V*rows));
    }
    
    

    public void loose() {
        this.setEnabled(false);
        System.out.println("you have lost");
        
        for (int r=0;r<cells.length;r++) {
            for (int c=0;c<cells[0].length;c++) {
                cells[r][c].setEnabled(false);
                cells[r][c].removeMouseListener(cells[r][c]);
                if (cells[r][c].isMined()) cells[r][c].setText("M");                
            }
        }
        
    }



    public void discoveredCell() {
        discoveredCells++;
        if (discoveredCells==cellCount) {
            
            JOptionPane.showMessageDialog(this,"Game completed","JMines",JOptionPane.PLAIN_MESSAGE);
            System.out.println("You win");
        }
        
    }

}
