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
package jmines.jMines;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 * This class is the graphic representation of a cell. 
 * @author salvo tomaselli
 * @version 0.0.0.1
 */
public class CellWrapper extends JButton implements MouseListener {

    private static final long serialVersionUID = -7435824525097087671L;
    
    private final Cell cell;//Cell associated to this button
    private static Board board=null;//Board of the game
    private CellWrapper[] around; //Cells around this cell
    private static Color NORMAL_BACKGROUND;
    
    //Mouse constants
    private static int LEFT_BUTTON=1;
    private static int RIGHT_BUTTON=3;
    private static int CENTER_BUTTON=2;
   
    /**
     * Creates a new wrapper. It is important to add to the wrapper the array of
     * other wrappers around, so the game can be run properly.
     * @param cell
     * @param board
     */
    public CellWrapper(Cell cell,Board board) {
        super();
        super.addMouseListener(this);
        
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        
        
        
        this.cell = cell;       
        CellWrapper.board=board;
        NORMAL_BACKGROUND = this.getBackground();//Assign the standard BG color
    }
    
    /**
     * Sets the cells around this.
     * @param around
     */
    public void setAround (CellWrapper[] around) {
        this.around = around;        
    }
    
    /**
     * Selects temporarly a cell
     * @param val
     */
    private void select(boolean val){
        if (val) this.setBackground(Color.RED); else this.setBackground(NORMAL_BACKGROUND);
    }
    
    public void discover() {
        this.setBackground(Color.LIGHT_GRAY);
        cell.setDiscovered(true);
        board.discoveredCell();
        
        if (cell.isMined()) {//The selected cell is mined
            board.loose();
            //TODO Paint a mine here
            
            this.setText("M");
            return;
            
        } 
        
        
        if (cell.getValue()>0) {
            this.setText(String.valueOf( cell.getValue()));
        } else {
            //If this cell isn't near to mines, there is no need to keep listener enabled
            this.removeMouseListener(this);
            //Discovering the close cells
            for (int i=0;i<around.length;i++) {
                if (around[i].cell.getDiscovered()==false)
                    around[i].discover();
            }
                    
                
        }
        
        
        switch (cell.getValue()) {
            case 1:
                this.setForeground(Color.BLUE);
                break;
            case 2:
                this.setForeground(Color.GREEN);
                break;
            case 3:
                this.setForeground(Color.YELLOW);
                break;
            case 4:
                this.setForeground(Color.MAGENTA);
                break;
            case 5: 
                this.setForeground(Color.RED);
                break;
            case 6: 
                this.setForeground(Color.ORANGE);
                
                
        }
        
        
    }

    public void mouseClicked(MouseEvent e) {
        if (cell.getDiscovered()) return;
        
        if (e.getButton()==LEFT_BUTTON) {
            if (cell.getFlag()) return;
                this.discover();
        } else if (e.getButton()==RIGHT_BUTTON) {
            if (cell.getFlag()) {
                this.setText("");
                this.cell.setFlag(false);
            } else {
                this.setText("X");
                this.cell.setFlag(true);
            }
            
        }
    }
    
    public boolean isMined() {
        return cell.isMined();
    }

    public void mousePressed(MouseEvent e) {
        if (e.getButton()==CENTER_BUTTON) {
            
            //How many flagged cells around?
            int aroundFlagged=0;
            for (int i=0;i<around.length;i++) {
                if  (around[i].cell.getFlag()) aroundFlagged++;
            }
            
            for (int i=0;i<around.length;i++) {
                if ((!around[i].cell.getDiscovered()) && (!around[i].cell.getFlag())) {
                    if (aroundFlagged==cell.getValue()&& (cell.getDiscovered())) {
                        around[i].discover();
                    }else {
                        around[i].select(true);
                    }
                    
                    
                }
            }
        }
        
    }

    public void mouseReleased(MouseEvent e) {
        if (e.getButton()==CENTER_BUTTON) {
            for (int i=0;i<around.length;i++) {
                if ((!around[i].cell.getDiscovered()) && (!around[i].cell.getFlag())) {
                    around[i].select(false);
                }
            }
        }
        
    }

    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }


    

}
