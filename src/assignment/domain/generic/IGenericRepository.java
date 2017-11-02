package assignment.domain.generic;

import java.util.List;
import java.util.Optional;

public interface IGenericRepository<T> {

	public T addElement(T t);

	public Optional<T> updateElement(T t);

	public List<T> findAll();

	public Optional<T> getElementById(int id);

	public void deleteElement(T t);

}
