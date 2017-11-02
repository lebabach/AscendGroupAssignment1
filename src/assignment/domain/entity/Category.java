package assignment.domain.entity;

import assignment.domain.generic.GenericEntity;

public class Category extends GenericEntity {
	public String name;

	public Category(int id, boolean isDeletedFlag, String name) {
		super(id, isDeletedFlag);
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		Category other = (Category) obj;
		return other.getId() == this.getId() ? true : false;
	}

}
