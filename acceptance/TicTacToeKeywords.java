import edu.jsu.mcis.*;

public class TicTacToeKeywords extends TicTacToe {
	private TicTacToe newGame;
	public void startNewGame() {
		newGame = new TicTacToe();

	}
	
	public void markLocation(int row, int col) {
		newGame.setMark(row + 1, col + 1);

	}
	
	public String fetchMark(int row, int col) {
		if (newGame.getMark(row, col) == Mark.X) {
			return "X";
		}
		else if (newGame.getMark(row, col) == Mark.O) {
			return "O";
		}
                else {
                    return "POOP";
                }
	}
    
	public String getWinner() {
		if (newGame.winDecider() == Result.XWIN) {
			return "X";
		}
		else if (newGame.winDecider() == Result.OWIN) {
			return "O";
		}
		else if (newGame.winDecider() == Result.TIE) {
			return "TIE";
		}
                else {
                    return "poop";
                }
	}
}
