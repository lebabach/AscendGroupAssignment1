package assignment.repository.interfaces;

import java.util.List;

import assignment.domain.entity.*;
import assignment.domain.generic.IGenericRepository;

public interface IRestaurantRepository extends IGenericRepository<Restaurant>{
	public List<Restaurant> getRestaurantBy(String name, String categoryName);
}
