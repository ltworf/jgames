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
 * 
 * @author salvo
 *
 * This is the implementation of the easy difficult level
 */
public class Easy extends Player {

    public Easy(Board board) {
        super(board);
        
    }

    public void opponentMove(int row, int col) {
        boolean boolTemp=false; 
        int c; 
        int r;  
        
        byte opponent = board.getCell(row,col);
        byte self =(byte)(opponent==1?-1:1);
        
        //See if i can win
        for  (r=Board.ROWS-1;r>=0;r--) {
            for  (c=Board.COLS-1;c>=0;c--){
                if (board.getCell(r,c)==self) boolTemp =tris(r,c);
                if (boolTemp) return;
            }
        }
        
        //Stop other player's 4
        for  (r=Board.ROWS-1;r>=0;r--) {
            for  (c=Board.COLS-1;c>=0;c--){
                if (board.getCell(r,c)==opponent) boolTemp =tris(r,c);
                if (boolTemp) return;
            }
        }

        if (bis(row,col)) return;

        while ( !board.placePiece( (int)(Math.random()*Board.COLS-1) ,this) ){
            
        }
        
        
    }
    
    private boolean bis (int row,int col) { 

    int temp1; 
    int temp2; 

    int player= board.getCell(row,col);
      
        
      temp1=board.getCell(row,col+1);
      temp2=board.getCell(row,col-1);
      if (temp1==player && temp2==Board.EMPTY_CELL && board.getCell(row+1,col-1)==Board.EMPTY_CELL)
        return board.placePiece(col-1,this);
       
      //|   | O | X |
      
      temp1=board.getCell(row,col-1);
      temp2=board.getCell(row,col-2);
      if (temp1==player && temp2==Board.EMPTY_CELL && board.getCell(row+1,col-2)==Board.EMPTY_CELL)
        return board.placePiece(col-2,this);
 
      //|   | X | O |
      
      temp1=board.getCell(row,col-1);
      temp2=board.getCell(row,col+1);
      if ( temp1==player && temp2==Board.EMPTY_CELL && board.getCell(row+1,col+1)==Board.EMPTY_CELL)
        return board.placePiece(col+1,this);
      
      //| X | O |   |
      
      temp1=board.getCell(row,col+1);
      temp2=board.getCell(row,col+2);
      if (temp1==player && temp2==Board.EMPTY_CELL && board.getCell(row+1,col+2)==Board.EMPTY_CELL)
        return board.placePiece(col+2,this);
  
      //| O | X |   |
      
      
      return false;
      }
    
    /**
     * Checks if the piece in the coordinate will do a 4
     * @param row
     * @param col
     * @return
     */
    private boolean tris (int row ,int col){
        
    int temp1;  
    int temp2;  
    int temp3;
    int player= board.getCell(row,col);
      
      //Horizontal check
        
      temp1=board.getCell(row,col-1);
      temp2=board.getCell(row,col-2);
      temp3=board.getCell(row,col+1);
      if ((temp1==player) && (temp2==player) && (temp3==Board.EMPTY_CELL) && (board.getCell(row+1,col+1)!=Board.EMPTY_CELL)) {
          
          return board.placePiece(col+1,this);  
          
      }
         

      //| X | X | O |   |   |  
      
      temp1=board.getCell(row,col+1);
      temp2=board.getCell(row,col+2);
      temp3=board.getCell(row,col-1);
      if ((temp1==player) && (temp2==player) && (temp3==Board.EMPTY_CELL) && (board.getCell(row+1,col-1)!=Board.EMPTY_CELL) ){   
      return board.placePiece(col-1,this); 
    }
      
      //|   |   | O | X | X |
      
      temp1=board.getCell(row,col-1);
      temp2=board.getCell(row,col+2);
      temp3=board.getCell(row,col+1);
      if ((temp1==player) && (temp2==player) && (temp3==Board.EMPTY_CELL) && (board.getCell(row+1,col+1)!=Board.EMPTY_CELL) ){   
           board.placePiece(col+1,this);
      }
      
      //|   | X | O |   | X |
      
      temp1=board.getCell(row,col+1);
      temp2=board.getCell(row,col-2);
      temp3=board.getCell(row,col-1);
      if  ((temp1==player) && (temp2==player) && (temp3==Board.EMPTY_CELL)  && (board.getCell(row+1,col-1)!=Board.EMPTY_CELL)) { 
       
      return board.placePiece(col-1,this); 
      }
      
     //| X |   | O | X |   |      
      
      temp1=board.getCell(row,col-2);
      temp2=board.getCell(row,col-3);
      temp3=board.getCell(row,col-1) ; 
      if ((temp1==player) && (temp2==player) && (temp3==Board.EMPTY_CELL) && (board.getCell(row+1,col-1)!=Board.EMPTY_CELL)) {    
      return board.placePiece(col-1,this); 
      }
      
      //| X | X |   | O |      
      temp1=board.getCell(row,col+2);
      temp2=board.getCell(row,col+3);
      temp3=board.getCell(row,col+1); 
      if ((temp1==player) && (temp2==player) && (temp3==Board.EMPTY_CELL) && (board.getCell(row+1,col+1)!=Board.EMPTY_CELL) ){   
       return board.placePiece(col+1,this); 
      }
      //| O |   | X | X |
      
      
      temp1=board.getCell(row,col+1);
      temp2=board.getCell(row,col-1);
      temp3=board.getCell(row,col-2);
      if 
      ((temp1==player) && (temp2==player) && (temp3==Board.EMPTY_CELL) && (board.getCell(row+1,col-2)!=Board.EMPTY_CELL)) { 
        
      return board.placePiece(col-2,this);
      }
      //|   | X | O | X | / |
      
      temp1=board.getCell(row,col+1);
      temp2=board.getCell(row,col-1);
      temp3=board.getCell(row,col+2);
      if 
      ((temp1==player) && (temp2==player) && (temp3==Board.EMPTY_CELL)  && (board.getCell(row+1,col+2)!=Board.EMPTY_CELL)){ 
       
      return board.placePiece(col+2,this); 
      }
     
      //| / | X | O | X |   |
      
      
      temp1=board.getCell(row,col-1);
      temp2=board.getCell(row,col-3);
      temp3=board.getCell(row,col-2);
      if ((temp1==player) && (temp2==player) && (temp3==Board.EMPTY_CELL) && (board.getCell(row+1,col-2)!=Board.EMPTY_CELL)){ 
       
      return board.placePiece(col-2,this); 
      }  
      //| X |   | X | O |
      
      temp1=board.getCell(row,col+1);
      temp2=board.getCell(row,col+3);
      temp3=board.getCell(row,col+2);
      if ((temp1==player) && (temp2==player) && (temp3==Board.EMPTY_CELL)  && (board.getCell(row+1,col+2)!=Board.EMPTY_CELL)){ 
       
      return board.placePiece(col+2,this); 
      }
      //| O | X |   | X |
      
      //Vertical check
      temp1=board.getCell(row+1,col);
      temp2=board.getCell(row+2,col);
      temp3=board.getCell(row-1,col);
      if ((temp1==player) && (temp2==player) && (temp3==Board.EMPTY_CELL)){   
      return board.placePiece(col,this);
      }
      
      
      return false;
    }
      
      






    public void win() {
        showMessage("Yahoo!");
        
    }

    public void loose() {
        showMessage("Hey! You've cheated!");        
    }

    public void parity() {
        showMessage("Strange, so strange.");
        
    }

}
