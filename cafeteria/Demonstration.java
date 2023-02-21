package cafeteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import staff.Cook;
import staff.Waiter;

public class Demonstration {
	
	private static Random random = new Random();

	public static void main(String[] args) {
		
		Cafeteria cafeteria = new Cafeteria();
		
		cafeteria.addTable(new Table());
		cafeteria.addTable(new Table());
		cafeteria.addTable(new Table());
		
		
		cafeteria.addDish(new Dish("Burger"));
		cafeteria.addDish(new Dish("Pizza"));
		cafeteria.addDish(new Dish("Salad"));
		cafeteria.addDish(new Dish("Cola"));
		
		
		cafeteria.addWaiter(new Waiter("Hovhannes"));
		cafeteria.addWaiter(new Waiter("Arsen"));
		cafeteria.addWaiter(new Waiter("Vahe"));
		cafeteria.addCook(new Cook("Anush"));
		
		List<Integer> order1 = new ArrayList<>();
		for (int i = 0; i < 11; i++) {
			order1.add(random.nextInt(cafeteria.getMenu().size()) + 1);
		}
		cafeteria.addOrder(new Order(random.nextInt(cafeteria.getTables().size()) + 1,
				random.nextInt(cafeteria.getWaiters().size()) + 1,order1));
		
		List<Integer> order2 = new ArrayList<>();
		for (int i = 0; i < 11; i++) {
			order2.add(random.nextInt(cafeteria.getMenu().size()) + 1);
		}
		cafeteria.addOrder(new Order(random.nextInt(cafeteria.getTables().size()) + 1,
				random.nextInt(cafeteria.getWaiters().size()) + 1,order2));
		
		System.out.printf("Cafeteria tables: %s\n",cafeteria.getTables());
		System.out.printf("Cafeteria menu: %s\n",cafeteria.getMenu());
		System.out.printf("Cafeteria waiters: %s\n",cafeteria.getWaiters());
		System.out.printf("Cafeteria cooks: %s\n",cafeteria.getCooks());
		System.out.printf("Cafeteria orders: %s\n",cafeteria.getOrders());
		
		Dish maxDish = cafeteria.getDishWithMaxOrders();
		Table maxTable = cafeteria.getTableWithMaxOrders();
		Waiter maxWaiter = cafeteria.getWaiterWithMaxOrders();
		System.out.printf("Dish with max orders of %d is %s\n",cafeteria.countDishOrders(maxDish), maxDish);
		System.out.printf("Table with max orders of %d is table#%s\n",cafeteria.countTableOrders(maxTable), maxTable);
		System.out.printf("Waiter with max orders of %d is %s\n",cafeteria.countWaiterOrders(maxWaiter), maxWaiter);		
	}

}
