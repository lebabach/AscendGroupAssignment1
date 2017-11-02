package assignment.application;

import java.time.format.DateTimeFormatter;
import java.util.*;

import assignment.domain.entity.*;
import assignment.service.implement.*;
import assignment.service.interfaces.*;

public class Application {
	List<Category> categories = null;
	List<Menu> menus = null;
	IUserService userService = null;
	IRestaurantService restaurantService = null;
	IMenuService menuService = null;
	IOrderService orderService = null;
	DateTimeFormatter dtf = null;

	public Application() {
		categories = new ArrayList<Category>();
		menus = new ArrayList<Menu>();
		restaurantService = new RestaurantService();
		menuService = new MenuService(restaurantService.getInstanceOfRestaurantRepository());
		orderService = new OrderService();
		userService = new UserService();
		dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	}

	public void initData() {
		// category data
		Category category1 = new Category(1, false, "Fast Ethnic");
		Category category2 = new Category(2, false, "Fast food");
		Category category3 = new Category(3, false, "Fast casual");
		Category category4 = new Category(4, false, "Casual dining");
		Category category5 = new Category(5, false, "Fine dining");
		categories.add(category1);
		categories.add(category2);
		categories.add(category3);
		categories.add(category4);
		categories.add(category5);

		// menu data
		List<Menu> listMenu1 = new ArrayList<Menu>();
		listMenu1.add(new Menu(1, false, "food 1", 100));
		listMenu1.add(new Menu(2, false, "food 2", 100));
		listMenu1.add(new Menu(3, false, "food 3", 100));
		listMenu1.add(new Menu(4, false, "food 4", 100));

		List<Menu> listMenu2 = new ArrayList<Menu>();
		listMenu2.add(new Menu(5, false, "food 5", 100));
		listMenu2.add(new Menu(6, false, "food 6", 100));
		listMenu2.add(new Menu(7, false, "food 7", 100));
		listMenu2.add(new Menu(8, false, "food 8", 100));

		List<Menu> listMenu3 = new ArrayList<Menu>();
		listMenu3.add(new Menu(9, false, "food 9", 100));
		listMenu3.add(new Menu(10, false, "food 10", 100));
		listMenu3.add(new Menu(11, false, "food 11", 100));
		listMenu3.add(new Menu(12, false, "food 12", 100));

		List<Menu> listMenu4 = new ArrayList<Menu>();
		listMenu4.add(new Menu(13, false, "food 13", 100));
		listMenu4.add(new Menu(14, false, "food 14", 100));
		listMenu4.add(new Menu(15, false, "food 15", 100));
		listMenu4.add(new Menu(16, false, "food 16", 100));

		List<Menu> listMenu5 = new ArrayList<Menu>();
		listMenu5.add(new Menu(17, false, "food 17", 100));
		listMenu5.add(new Menu(18, false, "food 18", 100));
		listMenu5.add(new Menu(19, false, "food 19", 100));
		listMenu5.add(new Menu(20, false, "food 20", 100));

		List<Menu> listMenu6 = new ArrayList<Menu>();
		listMenu6.add(new Menu(21, false, "food 21", 100));
		listMenu6.add(new Menu(22, false, "food 22", 100));
		listMenu6.add(new Menu(23, false, "food 23", 100));
		listMenu6.add(new Menu(24, false, "food 24", 100));

		// restaurant data
		restaurantService.add(new Restaurant(1, false, "Big Boy", category1, listMenu1));
		restaurantService.add(new Restaurant(2, false, "Tokia baly", category1, listMenu2));
		restaurantService.add(new Restaurant(3, false, "Hali baly", category2, listMenu3));
		restaurantService.add(new Restaurant(4, false, "Singla", category3, listMenu4));
		restaurantService.add(new Restaurant(5, false, "Kung ka", category4, listMenu5));
		restaurantService.add(new Restaurant(6, false, "Jana ka", category5, listMenu6));
		User user = new User(1, false, 90000, new ArrayList<Order>());
		userService.addUser(user);

	}

	public void displayResult() {
		int restaurantId = 1;
		int menuId4 = 4;
		int menuId2 = 2;
		int menuId1 = 1;
		int userId = 1;
		// 1. search restaurant by name and category
		System.out.println("1. Search restaurant by name = 'baly' and category = 'fast' ");

		restaurantService.getRestaurantBy("baly", "fast").forEach(item -> System.out.println(
				"id restaurant: " + item.getId() + " ;name: " + item.name + " ;category: " + item.category.name));

		// 2. Display menu by restaurantId
		System.out.println("\n2. Display menu by restaurantId = 1 ");
		menuService.getListMenuBy(restaurantId).forEach(item -> System.out.println("menu id:"+item.getId()+" ;menu name: "+item.name+" ;menu price: "+item.getPrice()));

		// 3.1 add a menu to a restaurant
		int menuId = new Random().nextInt(10000) + 24;
		restaurantService.addMenu(restaurantId, new Menu(menuId, false, "food " + menuId, 100));
		System.out.println("\n3.1 Display menu by restaurantId = 1 after adding new menu");
		menuService.getListMenuBy(restaurantId).forEach(item -> System.out.println("menu id:"+item.getId()+" ;menu name: "+item.name+" ;menu price: "+item.getPrice()));
		// 3.2 delete a menu of restaurant
		restaurantService.deleteMenu(restaurantId, menuId4);
		System.out.println("3.2 Display menu by restaurantId = 1 after deleting menuid = 4");
		menuService.getListMenuBy(restaurantId).forEach(item -> System.out.println("menu id:"+item.getId()+" ;menu name: "+item.name+" ;menu price: "+item.getPrice()));
		// 3.3 update menu name
		Optional<Menu> editedMenu = menuService.selectMenuBy(menuId2);
		if(editedMenu.isPresent()) {
			editedMenu.get().setName("susi");
			editedMenu.get().setPrice(200);
		}
		restaurantService.updateMenu(1, editedMenu);
		System.out.println("3.3 Display menu by restaurantId = 1 after updating menuid = 2");
		menuService.getListMenuBy(1).forEach(item -> System.out.println("menu id:"+item.getId()+" ;menu name: "+item.name+" ;menu price: "+item.getPrice()));
		
		
		// 4&&5. user can select a menu to order ,track orders, check money
		// add menu1
		Optional<Menu> selectedMenu = menuService.selectMenuBy(menuId1);
		Optional<Order> order = orderService.createOrder(selectedMenu);
		userService.addOrderToUser(order, 1);

		// add menu2
		selectedMenu = menuService.selectMenuBy(2);
		order = orderService.createOrder(selectedMenu);
		userService.addOrderToUser(order, userId);

		Optional<User> urs = userService.getUserBy(userId);
		System.out.println("\n4&&5. user select menuid =1,2 to order and track orders");
		if (urs.isPresent()) {
			if (urs.get().getOrder() != null && !urs.get().getOrder().isEmpty()) {
				urs.get().getOrder().forEach(item -> System.out.println("IdOfOrder: " + item.getId() + " ;order name: "
						+ item.name + " ;price: " + item.price + " ;time: " + dtf.format(item.datetime)));
			} else {
				System.out.println("No order");
			}
		} else {
			System.out.println("please choose right menu or userid is not right");
		}

		// 6. pay money
		boolean isPayed = userService.payOrdersBy(userId);
		urs = userService.getUserBy(userId);
		System.out.println("\n6. User order, show balanced and display message successful");
		if (urs.isPresent()) {
			System.out.println("balanced: " + urs.get().getMoney());
			if (isPayed) {
				System.out.println("Your order has been successful");
				
			} else {
				System.out.println("no enough money");	
			}
			if (urs.get().getOrder() != null && !urs.get().getOrder().isEmpty()) {
				urs.get().getOrder()
						.forEach(item -> System.out.println("IdOfOrder: " + item.getId() + " ;order name: "
								+ item.name + " ;price: " + item.price + " ;time: " + dtf.format(item.datetime)));
			}
		} else {
			System.out.println("please choose right menu or userid is not right");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// init data
		Application app = new Application();
		app.initData();
		app.displayResult();

	}

}