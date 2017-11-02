package assignment.service.interfaces;

import java.util.Optional;

import assignment.domain.entity.Menu;
import assignment.domain.entity.Order;

public interface IOrderService {
	public Optional<Order> createOrder(Optional<Menu> menu);
}
