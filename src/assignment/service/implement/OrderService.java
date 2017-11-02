package assignment.service.implement;

import java.time.LocalDateTime;
import java.util.Optional;

import assignment.domain.entity.Menu;
import assignment.domain.entity.Order;
import assignment.domain.generic.IGenericRepository;
import assignment.repository.implement.OrderRepository;
import assignment.repository.interfaces.IOrderRepository;
import assignment.service.interfaces.*;

public class OrderService implements IOrderService {
	public IOrderRepository orderRepository;
	public OrderService() {
		orderRepository = new OrderRepository();
	}

	@Override
	public Optional<Order> createOrder(Optional<Menu> menu) {
		// TODO Auto-generated method stub
		Optional<Order> order = Optional.empty();
		if (menu.isPresent()) {
			Order newOrder = new Order(menu.get().getId(), menu.get().isDeletedFlag(), menu.get().name, menu.get().price,
					LocalDateTime.now());
			this.orderRepository.addElement(newOrder);
			order = Optional.ofNullable(newOrder);
		}
		return order;
	}

}
