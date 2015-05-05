package agh.musicapplication.mappdao;

import java.io.Serializable;
import java.util.List;

public interface Crudable<T extends Object> {
    
    void insert(T entity);

    T find(Serializable id);

    List<T> findAll();

    void update(T entity);

    void delete(T entity);

    void deleteById(Serializable id);

    void deleteAll();
}
