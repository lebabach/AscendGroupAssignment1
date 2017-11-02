package assignment.domain.entity;

import java.util.List;

import assignment.domain.generic.GenericEntity;

public class User extends GenericEntity {
	public double money;
	public List<Order> order;

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public User(int id, boolean isDeletedFlag, double money, List<Order> order) {
		super(id, isDeletedFlag);
		this.money = money;
		this.order = order;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		long temp;
		temp = Double.doubleToLongBits(money);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return other.getId() == this.getId() ? true : false;
	}

}
