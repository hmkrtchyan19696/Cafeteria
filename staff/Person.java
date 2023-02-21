package staff;

public abstract class Person {
	protected int id;
	protected static int idCounter;
	protected String name = "Undefined";
	
	public Person() {
		this.id = ++idCounter;
	}
	
	public Person(int id) {
		this.id = id;
	}
	
	public Person(String name) {
		this.id = ++idCounter;
		this.name = name;
	}
	
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getID() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
