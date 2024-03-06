package ru.vsuet.bank.repository;

import java.util.List;
public interface Repository<T> {
    void save(T source);
    void delete(T target);
    List<T> list();
    T find(Long id);
}
