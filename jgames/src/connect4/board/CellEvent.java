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

/**
 * @author salvo
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public interface CellEvent {
    
    /**
     * Event sent to the player if requested to know wich button is pressed on the board.
     * @param row
     * @param col
     */
    public void cellPress(int row,int col);
    
    /**
     * Returns true if the player must move
     * @return
     */
    public boolean move();

}
