package by.novitsky.service;

import java.util.List;

public interface Service <T, V> {
  List<T> get();
  T get(Integer id);
  List<T> getPaginated(int page, int size);
  T save(V input);
  T update(V input, Integer id);
  T delete(Integer id);

}
