import edu.jsu.mcis.*;


public class TicTacToeKeywords {
	private TicTacToe newGame;
	public void startNewGame() {
		newGame = new TicTacToe();

	}
	
	public void markLocation(int row, int col) {
		newGame.setMark(row + 1, col + 1);

	}
	
	public String fetchMark(int row, int col) {
		String returnedMark = "";
		if (newGame.getMark(row + 1, col + 1) == Mark.X) {
			returnedMark = "X";
		}
		else if (newGame.getMark(row + 1, col + 1) == Mark.O) {
			returnedMark = "O";
		}
		else {
			returnedMark = "Oops";
		}
		return returnedMark;
		
	}
    
	public String getWinner() {
		String returnedWinState = "";
		if (newGame.winDecider() == Result.XWIN) {
			returnedWinState = "X";
		}
		else if (newGame.winDecider() == Result.OWIN) {
			returnedWinState = "O";
		}
		else if (newGame.winDecider() == Result.TIE) {
			returnedWinState = "TIE";
		}
		return returnedWinState;
                
	}
}