package assignment.repository.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import assignment.domain.entity.Menu;
import assignment.domain.generic.IGenericRepository;

public interface IMenuRepository extends IGenericRepository<Menu> {
	public List<Menu> getListMenuBy(int restaurantId);

	public Optional<Menu> selectMenuBy(int menuId);

}
