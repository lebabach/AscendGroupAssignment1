package assignment.domain.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GenericRepository<T extends GenericEntity> implements IGenericRepository<T> {
	List<T> list;

	public GenericRepository() {
		list = new ArrayList<T>();
	}

	@Override
	public T addElement(T t) {
		// TODO Auto-generated method stub
		list.add(t);
		return t;
	}

	private int getIndexElementBy(T t) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).id == t.id && list.get(i).isDeletedFlag == false) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public Optional<T> updateElement(T t) {
		// TODO Auto-generated method stub
		int index = getIndexElementBy(t);
		return index > 0 ? Optional.ofNullable(list.set(index, t)) : Optional.empty();
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return list.stream().filter(item -> item.isDeletedFlag == false).collect(Collectors.toList());
	}

	@Override
	public Optional<T> getElementById(int id) {
		// TODO Auto-generated method stub
		return list.stream().filter(item -> item.id == id && item.isDeletedFlag == false).findFirst();
	}

	@Override
	public void deleteElement(T t) {
		// TODO Auto-generated method stub

		int index = getIndexElementBy(t);
		if (index >= 0) {
			t.isDeletedFlag = true;
			list.set(index, t);
		}
	}

}
