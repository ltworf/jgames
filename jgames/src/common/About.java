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
package common;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;



/**
 * 
 * @author salvo
 *
 * This class shows a window with the about informations of Connect4
 */
public class About{

    private static final long serialVersionUID = 1393199473374096148L;
    
    public static final String version = "0.0.0.1"; //Version of this game
    public static final String author = "Salvo \"LtWorf\"Tomaselli"; //Author of this game
    public static final String authorWeb = "http://supersalvus.altervista.org"; //Author's page
    public static final String authorMail = "tiposchi@libero.it";//Author's email
    public static final String gameWeb = "http://galileo.dmi.unict.it/wiki/jgames/";//Project's page
    
    public static void printConsoleInfo(){
        System.out.println(
        "Connect 4" + version + ", Copyright (C) 2005 " + author + "\n" + 
        "Connect 4 comes with ABSOLUTELY NO WARRANTY.\n" +
        "This is free software, and you are welcome to redistribute it under certain conditions");
    }
    
    public static void showAbout(){
        JFrame frame = new JFrame ("Connect 4 - About");
        
        JTextPane text = new JTextPane ();
        text.setContentType("text/html; charset=UTF-8");
        try {
            text.setPage(common.About.class.getResource("about.html"));
        } catch (IOException e) {
            System.err.println("Unable to load the page");
            text.setText("Unable to load the page");
        }
        
        text.setMinimumSize(new Dimension(500,150));
        text.setPreferredSize(new Dimension(700,250));
        frame.setLayout(new BorderLayout());
        JScrollPane scroll = new JScrollPane();        
        scroll.setWheelScrollingEnabled(true);
        scroll.setViewportView(text);
        frame.add(scroll,BorderLayout.CENTER);
        text.setEditable(false);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        
        
    }

}
