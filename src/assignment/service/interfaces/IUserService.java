package assignment.service.interfaces;

import java.util.Optional;

import assignment.domain.entity.*;

public interface IUserService {
	public void addUser(User user);
	public void addOrderToUser(Optional<Order> order,int userId);
	public Optional<User> getUserBy(int userId);
	public boolean payOrdersBy(int userid);
}
