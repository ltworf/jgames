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
package connect4.players;

import connect4.board.Board;
import connect4.board.CellEvent;

/**
 * @author salvo
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class Human extends Player implements CellEvent{

    
    public Human (Board board){
        super(board);
        super.board.addCellEventListener(this);
    }
    
    public void opponentMove(int row, int col) {
        // nothing to do here
        
    }

    
    
    public void cellPress(int row, int col) {

        if (super.move) {            
            super.board.placePiece(col,this);        
        }
    }


    public void win() {
       showMessage("I am the master of players!");
        
    }


    public void loose() {
        showMessage("I was just unlucky");
        
    }


    public boolean move() {
        
        return super.move;
    }


    public void parity() {
        showMessage("That's incredible, happens only 1 time over millions");
        
    }

}
