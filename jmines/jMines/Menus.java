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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

import jmines.util.MinePlacer;

public class Menus extends JToolBar {
    
    private static final long serialVersionUID = 4535639426028258380L;

    public Menus() {
        JButton easy = new JButton("Easy");
        JButton medium = new JButton("Medium");
        JButton hard = new JButton("Hard");
        JButton about = new JButton("About");
        JButton close = new JButton("Close");
        
        this.add(easy);
        this.add(medium);
        this.add(hard);
        this.addSeparator();
        this.add(about);
        this.add(close);
        
        about.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) { 
                common.About.showAbout();                
            }
            
        });
        
        close.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            
        });
        
        easy.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                MinePlacer.newGame(8,8,10);                
            }            
        });
        
        medium.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                MinePlacer.newGame(16,16,40);
                
            }            
        });
        
        hard.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                MinePlacer.newGame(16,30,99);
                
            }            
        });
    }

}
