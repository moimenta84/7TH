package com.juego7th.repository;
import java.io.Serializable;
import java.util.List;
public interface RepositoryImplements<T, ID extends Serializable>{

    String create(T entity);
    void update(T entity);
    void delete(ID id);
    T getfindById(ID id);
    List<T> findAll();
}
