package by.novitsky.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

@Repository

@Transactional
public class BaseDao<T> implements Dao<T> {

  private SessionFactory sessionFactory;

  @Autowired
  public BaseDao(EntityManagerFactory factory) {
    this.sessionFactory = factory.unwrap(SessionFactory.class);
  }

  public Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  @Override
  public void saveOrUpdate(T t) {
    getSession().saveOrUpdate(t);
    //log.info("saveOrUpdate(t):" + t.getClass());
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED)
  public T get(Serializable id) {
    //log.info("Get class " + getPersistentClass() + " by id:" + id);
    Session session = getSession();
    //Transaction transaction = session.getTransaction();
    //transaction.begin();
    Class clazz = getPersistentClass();
    Object obj = session.get(clazz, id);
    T result = (T) obj;
    //transaction.commit();
    return result;
  }

  @Override

  @Transactional(propagation = Propagation.REQUIRED)
  public T get(T t, Serializable id) {
    //log.info("Get class "+ getPersistentClass() + " by id:" + id);
    return (T) getSession().get(t.getClass(), id);
  }

  @Override
  public T load(Serializable id) {
    //log.info("Load class by id:" + id);
    return (T) getSession().load(getPersistentClass(), id);
  }

  @Override
  public void refresh(T t) {
    getSession().refresh(t);
  }

  public void delete(T t) {
    getSession().delete(t);
  }

  private Class getPersistentClass() {
    return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
  }
}
