package expeditors.backend.dao;

import java.util.List;
import java.util.Optional;

public interface BaseDAO<T> {

    boolean update(T updateObject);

    boolean delete(int id);

    T insert(T newObject);

    T findById(int id);

    List<T> findAll();

}
