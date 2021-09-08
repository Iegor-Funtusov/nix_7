package ua.com.alevel.service;

import ua.com.alevel.entity.BaseEntity;

import java.util.List;

public interface CrudService<E extends BaseEntity> {

    void create(E e);
    void update(E e);
    boolean existById(Long id);
    void delete(Long id);
    E findById(Long id);
    List<E> findAll();
}
