package edu.jsu.mcis;

public class TicTacToe {

public enum Mark {X, O, E};
public Mark[][] gameBoard;
public enum Result {XWIN, OWIN, TIE};
private TicTacToe.Result endGameResult;
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

public Result getEndGameResult(){
	return endGameResult;
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

}
