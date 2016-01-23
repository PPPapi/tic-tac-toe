package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest extends TicTacToe {
	private TicTacToe TestTacToe = new TicTacToe();
	
	@Test
	public void testInitialBoardIsEmpty() {
		
		assertTrue((TestTacToe.getMark(1, 1) == null) && (TestTacToe.getMark(1, 2) == null) && (TestTacToe.getMark(1, 3) == null) && (TestTacToe.getMark(2, 1) == null) && (TestTacToe.getMark(2, 2) == null) && (TestTacToe.getMark(2, 3) == null) && (TestTacToe.getMark(3, 1) == null) && (TestTacToe.getMark(3, 2) == null) && (TestTacToe.getMark(3, 3) == null));
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		
		TestTacToe.setMark(1, 3);
		assertTrue(TestTacToe.getMark(1, 3) == Mark.X);
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		TestTacToe.setMark(1,1);
		TestTacToe.setMark(3, 1);
		assertTrue(TestTacToe.getMark(3, 1) == Mark.O);
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		
		TestTacToe.setMark(1, 1);
		TestTacToe.setMark(1, 1);
		assertTrue(TestTacToe.getMark(1, 1) == Mark.X);
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		
		TestTacToe.setMark(1, 1);
		assertTrue(TestTacToe.getEndGameResult() == null);
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		TestTacToe.gameBoard[0][0] = Mark.X;
		TestTacToe.gameBoard[0][1] = Mark.X;
		
		TestTacToe.setMark(1, 3);
		TestTacToe.winDecider();
		assertTrue(TestTacToe.getEndGameResult() == Result.XWIN);
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		TestTacToe.gameBoard[0][0] = Mark.O;
		TestTacToe.gameBoard[0][1] = Mark.X;
		TestTacToe.gameBoard[0][2] = Mark.X;
		TestTacToe.gameBoard[1][0] = Mark.X;
		TestTacToe.gameBoard[1][1] = Mark.O;
		TestTacToe.gameBoard[1][2] = Mark.O;
		TestTacToe.gameBoard[2][0] = Mark.O;
		TestTacToe.gameBoard[2][1] = Mark.X;
		TestTacToe.setMark(3, 3);
		TestTacToe.winDecider();
		
		assertTrue(TestTacToe.getEndGameResult() == Result.TIE);
	}	
}
