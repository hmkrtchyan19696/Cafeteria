package cafeteria;

import java.util.ArrayList;
import java.util.List;

import exceptions.IDIsAlreadyPresentException;
import exceptions.IDNotFoundException;
import staff.Cook;
import staff.Waiter;

public class Cafeteria {
	
	private List<Table> tables = new ArrayList<>();
	private List<Dish> menu = new ArrayList<>();
	private List<Waiter> waiters = new ArrayList<>();
	private List<Cook> cooks = new ArrayList<>();
	private List<Order> orders = new ArrayList<>();
	
	/**
	 * Adds a table to cafeteria tables after making sure that the table is not already present in cafeteria tables
	 * @param table
	 * @throws IDIsAlreadyPresentException if the table that is to be added already present in cafeteria tables
	 */
	public void addTable(Table table) throws IDIsAlreadyPresentException {
		if (tableExists(table.getID())) {
			throw new IDIsAlreadyPresentException("The Table with the given ID is already present.");
		}
		tables.add(table);
	}
	
	/**
	 * Adds a dish to cafeteria menu after making sure that the dish is not already present in the menu
	 * @param dish
	 * @throws IDIsAlreadyPresentException
	 */
	public void addDish(Dish dish) throws IDIsAlreadyPresentException {
		if (dishExists(dish.getID())) {
			throw new IDIsAlreadyPresentException("The Dish with the given ID is already present.");
		}
		menu.add(dish);
	}
	
	/**
	 * Adds a waiter to cafeteria waiters after making sure that the waiter is not already present in waiters list
	 * @param waiter
	 * @throws IDIsAlreadyPresentException
	 */
	public void addWaiter(Waiter waiter) throws IDIsAlreadyPresentException {
		if (waiterExists(waiter.getID())) {
			throw new IDIsAlreadyPresentException("The Waiter with the given ID is already present.");
		}
		waiters.add(waiter);
	}
	
	/**
	 * Adds a cook to cafeteria cooks after making sure that the cook is not already present in cooks list
	 * @param cook
	 * @throws IDIsAlreadyPresentException
	 */
	public void addCook(Cook cook) throws IDIsAlreadyPresentException {
		if (cookExists(cook.getID())) {
			throw new IDIsAlreadyPresentException("The Cook with the given ID is already present.");
		}
		cooks.add(cook);
	}
	
	/**
	 * Adds a new order after validating all the inputs
	 * @param order
	 * @throws IDNotFoundException
	 */
	public void addOrder(Order order) throws IDNotFoundException {
		if (!isValidOrder(order.getTableID(), order.getWaiterID(), order.getDishIDs())) {
			throw new IDNotFoundException("One of the inputs doesn't match the database");
		}
		orders.add(order);
	}
	
	/**
	 * Returns the first occurrence of the dish that was ordered the most times
	 * @return the first occurrence of the dish that was ordered the most times
	 */
	public Dish getDishWithMaxOrders() {
		Dish maxDish = null;
		int maxNumberOfOrders = 0;
		
		for (Dish dish : menu) {
			int numberOfOrders = countDishOrders(dish);
			if (numberOfOrders > maxNumberOfOrders) {
				maxNumberOfOrders = numberOfOrders;
				maxDish = dish;
			}
		}
		return maxDish;
	}
	
	/**
	 * Returns the table on which maximum number of orders was placed
	 * @return the table on which maximum number of orders was placed
	 */
	public Table getTableWithMaxOrders() {
		Table maxTable = null;
		int maxNumberOfOrders = 0;
		
		for (Table table : tables) {
			int numberOfOrders = countTableOrders(table);
			if (numberOfOrders > maxNumberOfOrders) {
				maxNumberOfOrders = numberOfOrders;
				maxTable = table;
			}
		}
		return maxTable;
	}
	
	/**
	 * Returns the waiter that completed the most number of orders
	 * @return the waiter that completed the most number of orders
	 */
	public Waiter getWaiterWithMaxOrders() {
		Waiter maxWaiter = null;
		int maxNumberOfOrders = 0;
		
		for (Waiter waiter : waiters) {
			int numberOfOrders = countWaiterOrders(waiter);
			if (numberOfOrders > maxNumberOfOrders) {
				maxNumberOfOrders = numberOfOrders;
				maxWaiter = waiter;
			}
		}
		return maxWaiter;
	}
	
	/**
	 * Counts the number of orders that was made by a particular dish
	 * @param dish
	 * @return the number of orders that was made by a particular dish
	 */
	public int countDishOrders(Dish dish) {
		int count = 0;
		for (Order order : orders) {
			for (Integer dishID : order.getDishIDs()) {
				if (dishID == dish.getID()) {
					count++;
				}
			}
		}
		return count;
	}
	
	/**
	 * Counts the number of orders that was placed on a particular table
	 * @param table
	 * @return the number of orders that was placed on a particular table
	 */
	public int countTableOrders(Table table) {
		int count = 0;
		for (Order order : orders) {
			if (order.getTableID() == table.getID()) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Counts the number of orders that a particular waiter has made
	 * @param waiter
	 * @return the number of orders that a particular waiter has made
	 */
	public int countWaiterOrders(Waiter waiter) {
		int count = 0;
		for (Order order : orders) {
			if (order.getWaiterID() == waiter.getID()) {
				count++;
			}
		}
		return count;
	}
	
	public List<Table> getTables() {
		return tables;
	}
	
	public List<Dish> getMenu() {
		return menu;
	}
	
	public List<Waiter> getWaiters() {
		return waiters;
	}
	
	public List<Cook> getCooks() {
		return cooks;
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	
	/**
	 * Checks whether a table exists in cafeteria tables
	 * @param id
	 * @return true if table with a given id is already present in tables list
	 */
	private boolean tableExists(int id) {
		for (Table table: tables) {
			if (table.getID() == id) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Checks whether a dish exists in cafeteria menu
	 * @param id
	 * @return true if the dish is present in the menu
	 */
	private boolean dishExists(int id) {
		for (Dish dish : menu) {
			if (dish.getID() == id) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks whether a waiter exists in cafeteria waiters list
	 * @param id
	 * @return true if the waiter with a given id is already present in cafeteria waiters
	 */
	private boolean waiterExists(int id) {
		for (Waiter waiter : waiters) {
			if(waiter.getID() == id) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks whether a cook exists in cafeteria cooks list
	 * @param id
	 * @return true if the cook with a given id is already present in cafeteria cooks list
	 */
	private boolean cookExists(int id) {
		for (Cook cook : cooks) {
			if (cook.getID() == id) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks whether the order that was placed is a valid one
	 * @param tableID
	 * @param waiterID
	 * @param dishIDs
	 * @return true if the table, waiter and dish IDs are present in tables, waiters and dishes accordingly
	 * @throws IDNotFoundException
	 */
	private boolean isValidOrder(int tableID, int waiterID, List<Integer> dishIDs) throws IDNotFoundException {
		
		if (!tableExists(tableID)) {
			throw new IDNotFoundException(String.format("Table with the ID of %d is not present in Cafeteria Tables", tableID));
		}
		
		if (!waiterExists(waiterID)) {
			throw new IDNotFoundException(String.format("Waiter with the ID of %d is not present in Cafeteria Waiters", waiterID));
		}
		
		if (!dishesExist(dishIDs)) {
			// the dishesExist will throw an exception of one of the dishes is not found in menu
		}
		
		return true;
	}
	
	/**
	 * Checks whether all the dishes in dish id list exist in cafeteria menu
	 * @param dishIDs
	 * @return true if all the dishes in the order are present in cafeteria menu
	 * @throws IDNotFoundException
	 */
	private boolean dishesExist(List<Integer> dishIDs) throws IDNotFoundException {
		for (Integer dishID : dishIDs) {
			if (!dishExists(dishID)) {
				throw new IDNotFoundException(String.format("Dish with the ID of %d is not present in Cafeteria Menu", dishID));
			}
		}
		return true;
	}
	
}
