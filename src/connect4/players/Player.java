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

/**
 * @author salvo
 *
 * Abstract type for the player
 */
public abstract class Player {
    protected Board board;
    protected boolean move=false;//Is true if this player must do a move
    
    public Player(Board board ) {
        this.board=board;
    }
    
    /**
     * Called by the board when the opponent moves.
     * @param row
     * @param col
     */
    public abstract void opponentMove(int row,int col);
    
    /**
     * Value setted by the board. when true the board will await the move of this player
     * @param val
     */
    public void mustMove(boolean val){
        this.move=val;
    }
    
    /**
     * Called by the board when the player wins
     *
     */
    public abstract void win();
    
    /**
     * Called by the board when the player loose
     *
     */
    public abstract void loose();
    
    
    public void showMessage(String msg){
        board.showMessage(msg,this);
    }
    
    /**
     * When nobody wins the match
     *
     */
    public abstract void parity();

}
