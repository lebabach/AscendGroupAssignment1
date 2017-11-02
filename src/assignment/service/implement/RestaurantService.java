package assignment.service.implement;

import java.util.List;
import java.util.Optional;

import assignment.domain.entity.*;
import assignment.repository.implement.RestaurantRepository;
import assignment.repository.interfaces.IRestaurantRepository;
import assignment.service.interfaces.*;

public class RestaurantService implements IRestaurantService {
	public IRestaurantRepository restaurantRepository;

	public RestaurantService() {
		restaurantRepository = new RestaurantRepository();
	}

	@Override
	public List<Restaurant> getRestaurantBy(String name, String categoryName) {
		// TODO Auto-generated method stub
		return restaurantRepository.getRestaurantBy(name, categoryName);
	}

	@Override
	public Restaurant add(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return restaurantRepository.addElement(restaurant);
	}

	@Override
	public IRestaurantRepository getInstanceOfRestaurantRepository() {
		return restaurantRepository;
	}

	@Override
	public void addMenu(int restaurantId, Menu menu) {
		if (menu != null) {
			Optional<Restaurant> selectedRestaurant = restaurantRepository.getElementById(restaurantId);
			if (selectedRestaurant.isPresent()) {
				if (selectedRestaurant.get().menus != null && !selectedRestaurant.get().menus.isEmpty()) {
					selectedRestaurant.get().menus.add(menu);
					Restaurant copyRestaurant = new Restaurant(selectedRestaurant.get().getId(), false,
							selectedRestaurant.get().name, selectedRestaurant.get().category,
							selectedRestaurant.get().menus);
					restaurantRepository.updateElement(copyRestaurant);
				}

			}
		}

	}

	@Override
	public void deleteMenu(int restaurantId, int menuId) {
		// TODO Auto-generated method stub
		Optional<Restaurant> selectedRestaurant = restaurantRepository.getElementById(restaurantId);
		if (selectedRestaurant.isPresent()) {
			if (selectedRestaurant.get().menus != null && !selectedRestaurant.get().menus.isEmpty()) {
				selectedRestaurant.get().menus.stream().filter(item -> item.getId() == menuId)
						.forEach(item -> item.setDeletedFlag(true));
				Restaurant copyObject = new Restaurant(selectedRestaurant.get().getId(), false,
						selectedRestaurant.get().name, selectedRestaurant.get().category,
						selectedRestaurant.get().menus);
				restaurantRepository.updateElement(copyObject);
			}

		}
	}

	@Override
	public void updateMenu(int restaurantId, Optional<Menu> menu) {
		// TODO Auto-generated method stub

		Optional<Restaurant> selectedRestaurant = restaurantRepository.getElementById(restaurantId);
		if (selectedRestaurant.isPresent() && menu.isPresent()) {
			if (selectedRestaurant.get().menus != null && !selectedRestaurant.get().menus.isEmpty()) {
				selectedRestaurant.get().menus.stream().filter(item -> item.getId() == menu.get().getId())
						.forEach(item -> {
							item.name=menu.get().getName();
							item.price=menu.get().getPrice();
						});
				Restaurant copyObject = new Restaurant(selectedRestaurant.get().getId(), false,
						selectedRestaurant.get().name, selectedRestaurant.get().category,
						selectedRestaurant.get().menus);
				restaurantRepository.updateElement(copyObject);
			}

		}
	}

}
