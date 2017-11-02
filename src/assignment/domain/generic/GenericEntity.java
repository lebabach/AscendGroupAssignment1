package assignment.domain.generic;

public abstract class GenericEntity {
	int id;
	boolean isDeletedFlag;
	
	public GenericEntity(int id, boolean isDeletedFlag) {
		this.id = id;
		this.isDeletedFlag = isDeletedFlag;
	}
	
	public int getId() {
		return id;
	}

	public boolean isDeletedFlag() {
		return isDeletedFlag;
	}

	public void setDeletedFlag(boolean isDeletedFlag) {
		this.isDeletedFlag = isDeletedFlag;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + (isDeletedFlag ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GenericEntity other = (GenericEntity) obj;
		if (id != other.id)
			return false;
		if (isDeletedFlag != other.isDeletedFlag)
			return false;
		return true;
	}
	

}
