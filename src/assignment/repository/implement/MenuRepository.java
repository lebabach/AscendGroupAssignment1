package assignment.repository.implement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import assignment.domain.entity.Menu;
import assignment.domain.generic.GenericRepository;
import assignment.repository.interfaces.IMenuRepository;
import assignment.repository.interfaces.IRestaurantRepository;

public class MenuRepository extends GenericRepository<Menu> implements IMenuRepository {
	IRestaurantRepository restaurantRepository = null;
	public MenuRepository() {
		super();
	}

	public MenuRepository(IRestaurantRepository restaurantRepository) {
		super();
		this.restaurantRepository = restaurantRepository;
	}
	
	@Override
	public List<Menu> getListMenuBy(int restaurantId) {
		// TODO Auto-generated method stub
		return restaurantRepository.findAll().stream().filter(item -> item.getId() == restaurantId)
				.flatMap(item -> item.menus.stream()).filter(item -> item.isDeletedFlag() == false)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<Menu> selectMenuBy(int menuId) {
		// TODO Auto-generated method stub
		return restaurantRepository.findAll().stream().flatMap(item -> item.menus.stream()).filter(item -> item.isDeletedFlag() == false && item.getId()==menuId).findFirst();
	}

}
