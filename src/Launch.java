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

/**
 *
 * @author salvo "LtWorf" Tomaselli
 */
public class Launch {
    
    public static void main(String[] args) {
        System.out.println("jgames");
        System.out.println("This program comes with ABSOLUTELY NO WARRANTY.");
        System.out.println("This is free software, and you are welcome to redistribute it");
        System.out.println("under certain conditions.");
        System.out.println("For details see the GPLv3 Licese.");

        
        if (args.length==0) printHelp();
        
        if (args[0].equals("jmines")) {
            jmines.JMines.main(null);            
        } else if (args[0].equals("numbers")) {
            numbers.Numeri.main(null);
        } else if (args[0].equals("soldama")) {
            soldama.Principale.main(null);
        } else if (args[0].equals("connect4")) {
            connect4.connect4.Connect4.main(null);
        } else {
            printHelp();
        }
    }
    
    public static void printHelp() {
        System.out.println("You need to specify the game you want to play.");
        System.out.println("Available options are:");
        System.out.println("jmines");
        System.out.println("numbers");
        System.out.println("soldama");
        System.out.println("connect4");
        System.exit(0);
    }

}
