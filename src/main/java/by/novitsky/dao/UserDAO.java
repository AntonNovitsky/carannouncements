package by.novitsky.dao;

import by.novitsky.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAO implements DataAccessObject<User> {

  public List<User> getAll(){
    return (List<User>) HibernateSessionFactory.getSessionFactory().openSession().createQuery("From User").list();
  }

  public User get(Integer id){
    return HibernateSessionFactory.getSessionFactory().openSession().get(User.class, id);
  }

  public User create(User user){
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    session.save(user);
    transaction.commit();
    session.close();
    return get(user.getId());
  }

  public User update(User user){
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    session.update(user);
    transaction.commit();
    session.close();
    return get(user.getId());
  }


  public User delete(User user){
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    session.delete(user);
    transaction.commit();
    session.close();
    return user;
  }

}
