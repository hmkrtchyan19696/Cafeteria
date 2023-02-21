package cafeteria;

import java.util.List;


public class Order {
	
	private int tableID;
	private int waiterID;
	private List<Integer> dishIDs;
	private int id;
	private static int idCounter;
	
	public Order(int tableID, int waiterID, List<Integer> dishIDs) {
		this.tableID = tableID;
		this.waiterID = waiterID;
		this.dishIDs = dishIDs;
		this.id = ++idCounter;
	}
	
	public int getID() {
		return this.id;
	}
	
	public int getTableID() {
		return this.tableID;
	}
	
	public int getWaiterID() {
		return this.waiterID;
	}
	
	public List<Integer> getDishIDs() {
		return this.dishIDs;
	}
	
	@Override
	public String toString() {
		return "Order #" + this.id + " : table ID " + tableID + ", waiter ID " + waiterID + 
				", dish IDs " + this.dishIDs + "\n";
	}
 
}
