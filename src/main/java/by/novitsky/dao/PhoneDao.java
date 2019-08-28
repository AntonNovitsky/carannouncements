package by.novitsky.dao;

import by.novitsky.entity.Phone;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PhoneDao implements DataAccessObject<Phone> {
  @Override
  public List<Phone> getAll() {
    return (List<Phone>) HibernateSessionFactory.getSessionFactory().openSession().createQuery("From Phone").list();
  }

  @Override
  public Phone get(Integer input) {
    return HibernateSessionFactory.getSessionFactory().openSession().get(Phone.class, input);
  }

  @Override
  public Phone update(Phone input) {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    session.update(input);
    transaction.commit();
    session.close();
    return get(input.getId());
  }

  @Override
  public Phone create(Phone input) {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    session.save(input);
    transaction.commit();
    session.close();
    return get(input.getId());
  }

  @Override
  public Phone delete(Phone input) {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    session.delete(input);
    transaction.commit();
    session.close();
    return input;
  }
}
