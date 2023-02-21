package cafeteria;

public class Dish {
	
	private int id;
	private static int idCounter;
	private String name = "Undefined";
	
	public Dish() {
		this.id = ++idCounter;
	}
	
	public Dish(int id) {
		this.id = id;
	}
	
	public Dish(String name) {
		this.id = ++idCounter;
		this.name = name;
	}
	
	public Dish(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public int getID() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
