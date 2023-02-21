package cafeteria;

public class Table {
	
	private int id;
	private static int idCounter;
	
	public Table() {
		this.id = ++idCounter;
	}
	
	public Table(int id) {
		this.id = id;
	}
	
	public int getID() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return Integer.toString(id);
	}

}
