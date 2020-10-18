
public class Player {
	public int id;
	public String name;
	public Choise choise; 
	
	public Player(int id, String name, Choise choise) {
		this.id = id;
		this.name = name;
		this.choise = choise;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Choise getChoise() {
		return choise;
	}

	public void setChoise(Choise choise) {
		this.choise = choise;
	}

}
