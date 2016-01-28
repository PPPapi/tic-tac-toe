package edu.jsu.mcis;

import java.util.Scanner;

public class TicTacToe {

public enum Mark {X, O, E};
public Mark[][] gameBoard;
public enum Result {XWIN, OWIN, TIE};
private Result endGameResult;
private int playerTurn;

public TicTacToe(){
	
	gameBoard = new Mark[3][3];
	playerTurn = 1;
	endGameResult = null;
	
	
}

public void setMark(int i, int j){
	if (playerTurn == 1) {
		if (gameBoard[i - 1][j - 1] == null) {
			gameBoard[i - 1][j - 1] = Mark.X;
			playerTurn = 2;
		}
		else {
			playerTurn = 1;
		}
	}
	else {
		if (gameBoard[i - 1][j - 1] == null) {
			gameBoard[i - 1][j - 1] = Mark.O;
			playerTurn = 1;
		}
		else {
			playerTurn = 2;
		}
	}
}

public Mark getMark(int i, int j) {
	return gameBoard[i - 1][j - 1];
}



public void printBoard(){
    
	for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                System.out.print(gameBoard[i][j] + " ");
                
            }
            System.out.print("\n");
        }
}

public Result winDecider() {
    if (((gameBoard[0][0] == Mark.X) && (gameBoard[0][1] == Mark.X) && (gameBoard[0][2] == Mark.X)) || ((gameBoard[1][0] == Mark.X) && (gameBoard[1][1] == Mark.X) && (gameBoard[1][2] == Mark.X)) || ((gameBoard[2][0] == Mark.X) && (gameBoard[2][1] == Mark.X) && (gameBoard[2][2] == Mark.X)) || ((gameBoard[0][0] == Mark.X) && (gameBoard[1][0] == Mark.X) && (gameBoard[2][0] == Mark.X)) || ((gameBoard[0][1] == Mark.X) && (gameBoard[1][1] == Mark.X) && (gameBoard[2][1] == Mark.X)) || ((gameBoard[0][2] == Mark.X) && (gameBoard[1][2] == Mark.X) && (gameBoard[2][2] == Mark.X)) || ((gameBoard[0][0] == Mark.X) && (gameBoard[1][1] == Mark.X) && (gameBoard[2][2] == Mark.X)) || ((gameBoard[2][0] == Mark.X) && (gameBoard[1][1] == Mark.X) && (gameBoard[0][2] == Mark.X))) {
                        endGameResult = Result.XWIN;
                        return endGameResult;
                        }
    else if (((gameBoard[0][0] == Mark.O) && (gameBoard[0][1] == Mark.O) && (gameBoard[0][2] == Mark.O)) || ((gameBoard[1][0] == Mark.O) && (gameBoard[1][1] == Mark.O) && (gameBoard[1][2] == Mark.O)) || ((gameBoard[2][0] == Mark.O) && (gameBoard[2][1] == Mark.O) && (gameBoard[2][2] == Mark.O)) || ((gameBoard[0][0] == Mark.O) && (gameBoard[1][0] == Mark.O) && (gameBoard[2][0] == Mark.O)) || ((gameBoard[0][1] == Mark.O) && (gameBoard[1][1] == Mark.O) && (gameBoard[2][1] == Mark.O)) || ((gameBoard[0][2] == Mark.O) && (gameBoard[1][2] == Mark.O) && (gameBoard[2][2] == Mark.O)) || ((gameBoard[0][0] == Mark.O) && (gameBoard[1][1] == Mark.O) && (gameBoard[2][2] == Mark.O)) || ((gameBoard[2][0] == Mark.O) && (gameBoard[1][1] == Mark.O) && (gameBoard[0][2] == Mark.O))) {
                        endGameResult = Result.OWIN;
                        return endGameResult;
                        }
    else if ((gameBoard[0][0] != null) && (gameBoard[0][1] != null) && (gameBoard[0][2] != null) && (gameBoard[1][0] != null) && (gameBoard[1][1] != null) && (gameBoard[1][2] != null) && (gameBoard[2][0] != null) && (gameBoard[2][1] != null) && (gameBoard[2][2] != null)) {
                        endGameResult = Result.TIE;
                        return endGameResult;
                        }
    else {
        endGameResult = null;
        return endGameResult;
    }

	
}
public static void main(String[] args){
	TicTacToe newGame = new TicTacToe();
        while (newGame.endGameResult == null) {
            Scanner row = new Scanner(System.in);
            Scanner col = new Scanner(System.in);
            
            System.out.println("Player " + newGame.playerTurn + "'s turn");
            System.out.println("Input desired row (Descending 1-3), press enter and then column (left to right 1-3) and press enter to mark a coordinate on the board.");
            int pickedRow = row.nextInt();
            int pickedCol = col.nextInt();
            newGame.setMark(pickedRow, pickedCol);
            newGame.printBoard();
            System.out.println("\n");
            newGame.winDecider();
        }
        System.out.println(newGame.endGameResult);
}




}
