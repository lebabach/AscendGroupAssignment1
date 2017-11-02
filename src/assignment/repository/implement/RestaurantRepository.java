package assignment.repository.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import assignment.domain.entity.*;
import assignment.domain.generic.GenericRepository;
import assignment.repository.interfaces.IRestaurantRepository;

public class RestaurantRepository extends GenericRepository<Restaurant> implements IRestaurantRepository {
	public RestaurantRepository() {
		super();
	}

	@Override
	public List<Restaurant> getRestaurantBy(String name, String categoryName) {
		// TODO Auto-generated method stub
		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		if (name != null && categoryName != null) {
			restaurants = this.findAll().stream()
					.filter(item -> item.name.toLowerCase().trim().contains(name.toLowerCase().trim())
							&& item.category != null 
							&& item.category.name.toLowerCase().trim().contains(categoryName.toLowerCase().trim()))
					.collect(Collectors.toList());
		}
		return restaurants;
	}

}
