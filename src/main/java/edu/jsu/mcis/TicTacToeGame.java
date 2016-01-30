package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TicTacToeGame extends JPanel implements ActionListener {
    private TicTacToe model = new TicTacToe();
    private JButton[][] button;
    
    
    public TicTacToeGame() {
        model = new TicTacToe();
        button = new JButton[3][3];
        setLayout(new GridLayout(3, 3));
        for (int i = 0; i < button.length; i++) {
            for (int j = 0; j < button[i].length; j++) {
                button[i][j] = new JButton();
                button[i][j].setPreferredSize(new Dimension(100, 100));
                button[i][j].addActionListener(this);
                button[i][j].setName("Location" + i +  j);
                add(button[i][j]);
            }
        }
    }
        private void checkForWin() {
        TicTacToe.Result result = model.winDecider();
		final String s;
        if (result == TicTacToe.Result.XWIN) {
            s = "X";
        }
        else if (result == TicTacToe.Result.OWIN) {
            s = "O";
        }
        else if (result == TicTacToe.Result.TIE) {
            s = "TIE";
        }
		else {
			s = "";
		}
		if (s.length() > 0) {
			new Thread(new Runnable() {
				public void run() {
					JOptionPane.showMessageDialog(null, "The winner is " + s, "Game Over", JOptionPane.INFORMATION_MESSAGE);
				}
			}).start();
                        
		}
        
    }
    
    
    
    public static void main(String[] args) {
        JFrame win = new JFrame("Tic Tac Toe");
        win.add(new TicTacToeGame());
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.pack();
        win.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton b = (JButton)event.getSource();
        String loc = b.getName().substring(8);
        
        int r = Integer.parseInt(loc.substring(0, 1)) + 1;
        int c = Integer.parseInt(loc.substring(1, 2)) + 1;
        
        model.setMark(r , c);
        TicTacToe.Mark m = model.getMark(r, c);
        if (m == TicTacToe.Mark.X) {
            b.setText("X");
        }
        else if (m == TicTacToe.Mark.O) {
            b.setText("O");
        }
        checkForWin();
    }
    
}
