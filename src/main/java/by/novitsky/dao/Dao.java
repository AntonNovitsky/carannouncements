package by.novitsky.dao;

import org.hibernate.Session;

import java.io.Serializable;

public interface Dao<T> {
  void saveOrUpdate(T t);
  T get(Serializable id);
  T get(T t, Serializable id);
  T load(Serializable id);
  void delete(T t);
  void refresh(T t);
  Session getSession();
}
