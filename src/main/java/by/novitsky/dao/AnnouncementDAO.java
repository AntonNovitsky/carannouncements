package by.novitsky.dao;

import by.novitsky.entity.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;

@Repository
@Qualifier("AnnouncementDao")
public class AnnouncementDAO extends BaseDao<Announcement> {

  @Autowired
  public AnnouncementDAO(EntityManagerFactory factory) {
    super(factory);
  }
}
