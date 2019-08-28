package by.novitsky.dao;

import by.novitsky.entity.Car;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CarDAO implements DataAccessObject<Car> {

  @Override
  public List<Car> getAll() {
    return (List<Car>) HibernateSessionFactory.getSessionFactory().openSession().createQuery("From Car").list();
  }

  @Override
  public Car get(Integer input) {
    return HibernateSessionFactory.getSessionFactory().openSession().get(Car.class, input);
  }

  @Override
  public Car update(Car input) {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    session.update(input);
    transaction.commit();
    session.close();
    return get(input.getId());
  }

  @Override
  public Car create(Car input) {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    session.save(input);
    transaction.commit();
    session.close();
    return get(input.getId());
  }

  @Override
  public Car delete(Car input) {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    session.delete(input);
    transaction.commit();
    session.close();
    return input;
  }
}
