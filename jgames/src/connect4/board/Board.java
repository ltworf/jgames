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

import connect4.players.Player;


/**
 * @author salvo
 *
 * This class is the board. Displays the board and checks if there is a winner
 */
public class Board{

    public static final byte PLAYER1 = 1;//This number is assigned to a cell containing a piece owned by player 1
    public static final byte PLAYER2 = -1;//This number is assigned to a cell containing a piece owned by player 2
    public static final byte EMPTY_CELL = 0;//Empty cell
    public static final byte SOLID_CELL = 10;//A cell out of the board
    
    public static final int ROWS =6;//Change those numbers to resize the board
    public static final int COLS =7;

    private int freeplaces = ROWS*COLS;
    private byte[][] vals= new byte[ROWS][COLS];
    
    private ScreenBoard sBoard;
    
    private Player player1;
    private Player player2;
    
    /**
     * Sets the players using the board
     * @param p
     * @param n
     */
    public void setPlayer(Player p, byte n) {
        if (n==1) {
            player1=p;
            player1.mustMove(true);
        }
        else if (n==2) player2=p;
        else throw new RuntimeException("Not allowed player number");
        
        
       
    }
    
    public Board(){
        this(true);
    }
    
    public Board (boolean showBoard){
        if (showBoard) sBoard= new ScreenBoard(ROWS,COLS);
    }
    
    /**
     * Creates a copy of the board, using only the data but without displaying it on 
     * the screen.
     * It is used by some players to understand wich moves would allow the opponent
     * to win.
     * @return The copied board
     */
    public Board copy(){
        Board tmp = new Board(false);
        tmp.freeplaces = this.freeplaces;
        tmp.player1 = this.player1;
        tmp.player2 = this.player2;
        
        byte[][] bVals = new byte[ROWS][COLS];
        for (int r=0;r<ROWS;r++){
            for (int c=0;c<COLS;c++){
                bVals[r][c]=vals[r][c];
            }
        }
        
        tmp.vals = bVals;
        
        
        return tmp;
    }
    
   
    
    public void addCellEventListener(CellEvent c){
        sBoard.addCellEventListener(c);
    }
    
        
    /**
     * Returns what a cell contains. If you ask for a cell of of bounds, it will return EMPTY_CELL
     * @param row
     * @param col
     * @return
     */
    public byte getCell(int row,int col){
        
        if ((row<0)||(row>=ROWS)||(col<0)||(col>=COLS)) return SOLID_CELL;
        
        return vals[row][col];
    }
    
    /**
     * Places a piece in the selected column
     * @param col: The column where you wish to place the piece
     * @param player: The player who is placing the piece
     * @return
     */
    public boolean placePiece(int col, Player player){
        byte p=0;
        if (player==player1) p = PLAYER1;
        else p=PLAYER2;
        return placePiece(col,p);
    }
    
    /**
     * Places a piece in the selected column
     * @param col: The column where you wish to place the piece
     * @param player: The player who is placing the piece
     * @return
     */
    public boolean placePiece(int col, byte player){
        int a;       
        int row=0; 
        
        int r;
        int c;
        
          
            for (a=ROWS-1;a>=0;a--){
              if (vals[a][col]==EMPTY_CELL) { 
                row=a;
                vals[a][col]=player;
                if (player==PLAYER1) {                    
                    player1.mustMove(false);                                        
                    player2.mustMove(true);
                    player2.opponentMove(a,col);
                } else {
                    player2.mustMove(false);
                    player1.mustMove(true);
                    player1.opponentMove(a,col);                   
                }
                freeplaces--;
                if (freeplaces==0) {
                    sBoard.endGame();//Nobody wins, endin game
                    player1.parity();
                    player2.parity();
                }
                Refresh();

                    
                break;
              }      
            }
            


            for (r =0;r<ROWS;r++) {
              for (c=0;c<COLS;c++) {    
                if ((vals[r][c]==player) && isWinner(r,c)) {//Player wins!!
                  Winner(player);           
                }
              }
            }
            

      return getCell(row,col)==player;

        
    }
    
    public boolean isWinner(int row, int col) {
        
    byte player=vals[row][col]; 
    boolean bool=false; 

    

    //horizontal check
    bool=
        (player== getCell(row, col + 1) &&
                player == getCell(row, col + 2)
                && player == getCell(row, col + 3));  
  
     
     //vertical check
    bool=bool||
    (player == getCell(row + 1, col) &&
                   player == getCell(row + 2, col) &&
                                 player == getCell(row + 3, col));



    //Obliguo
    bool=bool||
        (player == getCell(row + 1, col + 1) &&
                player == getCell(row + 2, col + 2) &&
                player == getCell(row + 3, col + 3));
 
     
    bool=bool||
    	(player == getCell(row + 1, col - 1) && 
    	        player == getCell(row + 2, col - 2) &&
    	        player == getCell(row + 3, col - 3));
 
     
    return bool;

       }
    
    private void Refresh(){
       if (sBoard!=null) sBoard.refresh(vals);
    }
    
    
    /**
     * Player wins the match
     * @param player
     */
    private void Winner(byte player){
        sBoard.endGame();
        if (player==PLAYER1) {
            player1.win();
            player2.loose();
        } else {
            player1.loose();
            player2.win();
        }
    }
        
    
    public void showMessage(String msg,Player player){
        if (player==player1){
            sBoard.lbl1.setText(msg);
        } else {
            sBoard.lbl2.setText(msg);
        }
    }
  
    
}
