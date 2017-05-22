package dao;

import java.util.List;

public interface BaseDao<T> {

    T add(T entity);

    T update(T updateEntity);

    boolean delete(T id);

    List<T> getAllRecords();

    T getDetailsById(Long id);
}
