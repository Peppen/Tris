import java.util.ArrayList;
import java.util.Scanner;


public class Init {

	static ArrayList<String> positions = null;
	
	public final static String FREE = "Free";
	public final static String CHOISE = " choose position where you want to enter the sign ";
	public final static String OCCUPIED = "Occupied Position";
	public final static String WINNER = "We have a Winner";
	public final static String PEPPE = "Peppe";
	public final static String GIOVANNI = "Giovanni";
	public final static String NO_WINNER = "Not Winner yet";
	public final static String HAVE_WINNER = " is the Winner";
	public Player first;
	public Player second;
	
	public Init(Player first, Player second) {
		first = new Player(1, PEPPE, Choise.X);
		second = new Player(2, GIOVANNI, Choise.O);
	}
	
	public void initialize() {

		positions = new ArrayList<String>();
		for(int i=0; i<9; i++)
			positions.add(FREE + i);
		Player first = new Player(1, PEPPE, Choise.X);
		Player second = new Player(2, GIOVANNI, Choise.O);
		boolean turn = true;
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		String winner = null;

		for(int i=0; i<9; i++) {
			if(count>=4) {
				if(chooseWinner(positions).equals(WINNER)) {
					System.out.println(winner + HAVE_WINNER);
					break;
				}
				else {
					System.out.println(NO_WINNER);
				}
			}
			if(turn) {
				System.out.println(first.getName() + CHOISE + first.getChoise().toString() + ":");
				int first_choise = scanner.nextInt();
				if(notOccupiedPositions(positions,first_choise)) {
					positions.remove(first_choise);
					positions.add(first_choise,first.getChoise().toString());
					turn = false;
					winner = first.getName();
					count++;
				}
				else {
					System.out.println(OCCUPIED);
					turn = true;
				}
			}
			else {
				System.out.println(second.getName() + CHOISE + second.getChoise().toString() + ":");
				int second_choise = scanner.nextInt();
				if(notOccupiedPositions(positions,second_choise)) {
					positions.remove(second_choise);
					positions.add(second_choise,second.getChoise().toString());
					turn = true;
					winner = second.getName();
					count++;
				}
				else {
					System.out.println(OCCUPIED);
					turn = false;
				}
			}
		}

		scanner.close();
	}

	private static boolean notOccupiedPositions(ArrayList<String> positions, int position) {
		return positions.get(position).equals(FREE + position);
	}

	private static String chooseWinner(ArrayList<String> positions) {

			if(positions.get(0).equals(positions.get(1)) && positions.get(1).equals(positions.get(2))) 
				return WINNER;

			else if(positions.get(0).equals(positions.get(4)) && positions.get(4).equals(positions.get(8)))
				return WINNER;

			else if(positions.get(0).equals(positions.get(3)) && positions.get(3).equals(positions.get(6))) 
				return WINNER;

			else if(positions.get(2).equals(positions.get(5)) && positions.get(5).equals(positions.get(8)))
				return WINNER;

			else if(positions.get(6).equals(positions.get(7)) && positions.get(7).equals(positions.get(8)))
				return WINNER;

			else if(positions.get(2).equals(positions.get(4)) && positions.get(4).equals(positions.get(6)))
				return WINNER;

			else
				return NO_WINNER;
	}
	
}
