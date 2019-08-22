package by.novitsky.dao;

import java.util.List;

public interface DataAccessObject<T> {

  List<T> getAll();
  T get(T input);
  T update(T input);
  T create(T input);
  T delete(T input);

}
