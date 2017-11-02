package assignment.service.implement;

import java.util.*;
import java.util.Optional;

import assignment.domain.entity.Order;
import assignment.domain.entity.User;
import assignment.repository.implement.UserRepository;
import assignment.repository.interfaces.IUserRepository;
import assignment.service.interfaces.IUserService;

public class UserService implements IUserService {
	public IUserRepository userRepository;

	public UserService() {
		userRepository = new UserRepository();
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userRepository.addElement(user);
	}

	@Override
	public void addOrderToUser(Optional<Order> order, int userId) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.getElementById(userId);
		if (user.isPresent() && order.isPresent()) {
			List<Order> orders = new ArrayList<Order>();
			if (user.get().getOrder() != null && !user.get().getOrder().isEmpty()) {
				orders.addAll(user.get().getOrder());
			}
			orders.add(order.get());
			user.get().setOrder(orders);

			User newOrder = new User(user.get().getId(), user.get().isDeletedFlag(), user.get().getMoney(),
					user.get().getOrder());

			userRepository.updateElement(newOrder);
		}
	}

	@Override
	public Optional<User> getUserBy(int userId) {
		// TODO Auto-generated method stub
		return this.userRepository.getElementById(userId);

	}

	@Override
	public boolean payOrdersBy(int userid) {
		// TODO Auto-generated method stub
		boolean isOrdered = false;
		Optional<User> user = this.userRepository.getElementById(userid);
		if (user.isPresent()) {
			if (user.get().getOrder() != null && !user.get().getOrder().isEmpty()) {
				double totalPrice = user.get().getOrder().stream().mapToDouble(item -> item.price).sum();
				if (user.get().getMoney() - totalPrice >= 0) {
					user.get().setMoney(user.get().getMoney() - totalPrice);
					user.get().setOrder(new ArrayList<Order>());
					User copyUser = new User(user.get().getId(), user.get().isDeletedFlag(), user.get().getMoney(),
							user.get().getOrder());
					userRepository.updateElement(copyUser);
					isOrdered = true;
				}
			}

		}
		return isOrdered;
	}

}