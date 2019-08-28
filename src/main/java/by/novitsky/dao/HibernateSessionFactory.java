package by.novitsky.dao;

import by.novitsky.cofiguration.ConfigurationManager;
import by.novitsky.entity.Announcement;
import by.novitsky.entity.Car;
import by.novitsky.entity.Phone;
import by.novitsky.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Optional;

public class HibernateSessionFactory {
  private static SessionFactory sessionFactory;
  private static Session session;

  private HibernateSessionFactory() {}

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
      try {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.driver_class", ConfigurationManager.getProperty("spring.datasource.driver-class-name"));
        configuration.setProperty("hibernate.connection.url", ConfigurationManager.getProperty("spring.datasource.url"));
        configuration.setProperty("hibernate.connection.username", ConfigurationManager.getProperty("spring.datasource.username"));
        configuration.setProperty("hibernate.connection.password", ConfigurationManager.getProperty("spring.datasource.password"));
        configuration.setProperty("hibernate.connection.pool_size","1");
        configuration.setProperty("hibernate.current_session_context_class", "thread");
        configuration.setProperty("hibernate.show_sql","false");
        configuration.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Phone.class);
        configuration.addAnnotatedClass(Car.class);
        configuration.addAnnotatedClass(Announcement.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
      } catch (Exception e) {
        e.printStackTrace();
        }
      }
    return sessionFactory;
    }

    public static Session getSession(){
      if (!Optional.ofNullable(session).isPresent()){
        if(!Optional.ofNullable(sessionFactory).isPresent()){
          getSessionFactory();
        }
        session = sessionFactory.openSession();
      }
      return session;
    }
}
