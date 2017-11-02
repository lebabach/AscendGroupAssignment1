package assignment.service.interfaces;

import java.util.List;
import java.util.Optional;

import assignment.domain.entity.Menu;

public interface IMenuService {
	public List<Menu> getListMenuBy(int restaurantId);
	public Optional<Menu> selectMenuBy(int menuId);
}
