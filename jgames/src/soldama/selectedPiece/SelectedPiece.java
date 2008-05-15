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

@author Salvo "LtWorf" Tomaselli <ltworf@galileo.dmi.unict.it>

 */

package soldama.selectedPiece;

/**
 * @author Salvo Tomaselli
 *
 * This class specify the selected piece... nothing else!
 */
public class SelectedPiece {
    public boolean selected=false;
    public byte x=0;
    public byte y=0;
    public byte remaining;
    public byte eat=0;

}
