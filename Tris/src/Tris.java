import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Tris {

	public JFrame frame;
	public boolean turn = true;
	public boolean done = false;
	public int i = 0;
	public ArrayList<JButton> buttons;
	public ActionListener listener;
	public final static String TRIS = "Tris";
	public final static String X = "X";
	public final static String O = "O";
	public final static String PEPPE = "Peppe";
	public final static String GIOVANNI = "Giovanni";
	public final static String STARTGAME = "Start Game";
	public final static String GAMESTARTED = "Game Started \n";
	public final static String WINNER = " is the winner";
	public final static String PLAYERS = "Players in game: ";
	public final static String RESTART = "Restart";
	public final static String AND = " and ";
	public final static String END_LINE = "\n";
	public final static String NOWINNER = "We have no winner";

	public void run() {
		HashMap<Integer, JButton> maps = new HashMap<>();
		buttons = new ArrayList<>();
		Player first = new Player(1, PEPPE, Choise.X);
		Player second = new Player(2, GIOVANNI, Choise.O);
		frame = new JFrame(TRIS);
		JPanel panel = new JPanel();
		BoxLayout box = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
		panel.setLayout(box);
		JPanel firstPanel = new JPanel();

		for(int i=0; i<9; i++) {
			JButton cell = new JButton();
			cell.setPreferredSize(new Dimension(40,40));
			maps.put(i, cell);
			buttons.add(cell);
			cell.setVisible(false);
			firstPanel.add(cell);
		}

		GridLayout grid = new GridLayout(3,3);
		firstPanel.setLayout(grid);
		panel.add(firstPanel);
		panel.add(Box.createRigidArea(new Dimension(0,25)));
		JPanel thirdPanel = new JPanel();
		JButton start = new JButton(STARTGAME);		
		thirdPanel.add(start);
		JButton restart = new JButton(RESTART);
		thirdPanel.add(restart);
		restart.setVisible(false);

		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(JButton b : buttons)
					b.setVisible(true);
				start.setEnabled(false);
				start.setVisible(false);
				restart.setVisible(true);
			}
		});

		restart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				turn=true;
				i=0;
				enableAll(buttons);
				clear(buttons);
			}
		});
		
		panel.add(thirdPanel);
		for(JButton b : buttons) {
			b.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					i++;
					if(turn) {
						b.setText(X);
						b.setEnabled(false);
						turn = false;
					}
					else {
						b.setText(O);
						b.setEnabled(false);
						turn = true;
					}
					if(calculateWinner(maps)) {
						if(turn==false) 
							JOptionPane.showMessageDialog(frame, null, first.getName() + WINNER, JOptionPane.INFORMATION_MESSAGE);
						else 
							JOptionPane.showMessageDialog(frame, null, second.getName() + WINNER, JOptionPane.INFORMATION_MESSAGE);
						disableAll(buttons);
						//restart.setVisible(true);
						
					} else if(i==8)
						JOptionPane.showInputDialog(NOWINNER);
				}
			});
		}
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public boolean calculateWinner(HashMap<Integer, JButton> maps) {
		if(maps.get(0).getText().equals(maps.get(1).getText()) && maps.get(1).getText().equals(maps.get(2).getText()) && !maps.get(0).getText().isEmpty()) { 
			return true;
		}
		else if(maps.get(0).getText().equals(maps.get(4).getText()) && maps.get(4).getText().equals(maps.get(8).getText()) && !maps.get(0).getText().isEmpty()) {
			return true;
		}
		else if(maps.get(0).getText().equals(maps.get(3).getText()) && maps.get(3).getText().equals(maps.get(6).getText()) && !maps.get(0).getText().isEmpty()) {
			return true;
		}
		else if(maps.get(2).getText().equals(maps.get(5).getText()) && maps.get(5).getText().equals(maps.get(8).getText()) && !maps.get(2).getText().isEmpty()) {
			return true;
		}
		else if(maps.get(6).getText().equals(maps.get(7).getText()) && maps.get(7).getText().equals(maps.get(8).getText()) && !maps.get(6).getText().isEmpty()) {
			return true;
		}
		else if(maps.get(2).getText().equals(maps.get(4).getText()) && maps.get(4).getText().equals(maps.get(6).getText()) && !maps.get(2).getText().isEmpty()) {
			return true;
		}
		else if(maps.get(3).getText().equals(maps.get(4).getText()) && maps.get(4).getText().equals(maps.get(5).getText()) && !maps.get(3).getText().isEmpty()) {
			return true;
		}
		else if(maps.get(1).getText().equals(maps.get(4).getText()) && maps.get(4).getText().equals(maps.get(7).getText()) && !maps.get(1).getText().isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}

	public void disableAll(ArrayList<JButton> buttons) {
		for(JButton b : buttons)
			b.setEnabled(false);
	}
	
	public void enableAll(ArrayList<JButton> buttons) {
		for(JButton b : buttons)
			b.setEnabled(true);
	}

	public void clear(ArrayList<JButton> buttons) {
		for(JButton b : buttons)
			b.setText("");
	}
	public static void main(String args[]) {
		new Tris().run();
	}
	

}
