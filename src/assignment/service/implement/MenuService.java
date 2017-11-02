package assignment.service.implement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import assignment.domain.entity.Menu;
import assignment.repository.implement.MenuRepository;
import assignment.repository.implement.RestaurantRepository;
import assignment.repository.interfaces.IMenuRepository;
import assignment.repository.interfaces.IRestaurantRepository;
import assignment.service.interfaces.IMenuService;

public class MenuService implements IMenuService {
	IMenuRepository menuRepository;
	public MenuService(IRestaurantRepository restaurantRepository) {
		menuRepository = new MenuRepository(restaurantRepository);
	}

	@Override
	public List<Menu> getListMenuBy(int restaurantId) {
		// TODO Auto-generated method stub
		return menuRepository.getListMenuBy(restaurantId);
	}

	@Override
	public Optional<Menu> selectMenuBy(int menuId) {
		// TODO Auto-generated method stub
		return menuRepository.selectMenuBy(menuId);
	}

}
