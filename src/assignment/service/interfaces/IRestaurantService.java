package assignment.service.interfaces;

import java.util.List;
import java.util.Optional;

import assignment.domain.entity.Menu;
import assignment.domain.entity.Restaurant;
import assignment.repository.interfaces.IRestaurantRepository;

public interface IRestaurantService {
	public List<Restaurant> getRestaurantBy(String name, String categoryName);
	public Restaurant add(Restaurant restaurant);
	public IRestaurantRepository getInstanceOfRestaurantRepository();
	public void addMenu(int restaurantId, Menu menu);
	public void deleteMenu(int restaurantId, int menuId);
	public void updateMenu(int restaurantId, Optional<Menu> menu);
}
