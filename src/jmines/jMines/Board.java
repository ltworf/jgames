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

/**
 * This interface has the methods that a board must have
 * @author salvo tomaselli
 * @version 0.0.0.1
 */
public interface Board {
    
    /**
     * Raised by a CellWrapper when a mine is discovered
     *
     */
    public void loose();
    
    /**
     * Called when a cell is discovered.
     *
     */
    public void discoveredCell() ;

}
