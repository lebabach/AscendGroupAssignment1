package assignment.domain.entity;

import java.util.List;

import assignment.domain.generic.GenericEntity;

public class Restaurant extends GenericEntity {
	public String name;
	public Category category;
	public List<Menu> menus;

	public Restaurant(int id, boolean isDeletedFlag, String name, Category category, List<Menu> menus) {
		super(id, isDeletedFlag);
		this.name = name;
		this.category = category;
		this.menus = menus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((menus == null) ? 0 : menus.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Restaurant other = (Restaurant) obj;

		return other.getId() == this.getId() ? true : false;
	}

}
