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

/**
 * This class represents a cell.
 * When initializing it, you'll have to set if it contains a mine or not.
 * A method in the util package will set a value to set how many mines there are around.
 * @author salvo tomaselli
 * @version 0.0.0.1
 */
public class Cell {
    
    private boolean mined; //true if this cell is mined
    private byte around=0;//how many mined cells around?
    private boolean discovered=false; //true if this cell were discovered
    private boolean flag=false;//true if there is a flag on this cell
    
    /**
     * Returns true if this cell is flagged
     * @return boolean
     */
    public boolean getFlag() {
        return this.flag;
    }
    
    /**
     * Sets if this cell is flagged or not
     * @param flag
     */
    public void setFlag(boolean flag) {
        this.flag=flag;
    }
    
    /**
     * Sets if this cell has been discovered
     * @param discovered
     */
    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }
    
    /**
     * Returns true if this cell has been discovered
     * @return boolean
     */
    public boolean getDiscovered() {
        return this.discovered;
    }
    
    
    /**
     * Sets this cell as mined
     * @param mined
     */
    public void setMined(boolean mined) {
        this.mined = mined;
    }
    
    /**
     *  Returns true if the cell is mined
     * @return boolean
     */
    public boolean isMined() {
        return mined;
    }
    
    /**
     * Returns how many mines there are around this cell
     * @return byte
     */
    public byte getValue() {
        return around;
    }
    
    /**
     * Sets the number of mined cells around 
     * @param val
     */
    public void setValue(byte val) {
        around=val;
    }
    

}
