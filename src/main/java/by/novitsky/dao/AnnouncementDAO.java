package by.novitsky.dao;

import by.novitsky.entity.Announcement;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public class AnnouncementDAO implements DataAccessObject<Announcement> {
  @Override
  public List<Announcement> getAll() {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    List<Announcement> result = (List<Announcement>) session.createQuery("From Announcement").list();
    return result;
  }

  @Override
  public Announcement get(Integer input) {
    return HibernateSessionFactory.getSessionFactory().openSession().get(Announcement.class, input);
  }

  @Override
  public Announcement update(Announcement input) {
    input.setDateLastChanged(LocalDateTime.now());
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    session.update(input);
    transaction.commit();
    session.close();
    return get(input.getId());
  }

  @Override
  public Announcement create(Announcement input) {
    input.setDateLastChanged(LocalDateTime.now());
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    session.save(input);
    transaction.commit();
    session.close();
    return get(input.getId());
  }

  @Override
  public Announcement delete(Announcement input) {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    session.delete(input);
    transaction.commit();
    session.close();
    return input;
  }
}
