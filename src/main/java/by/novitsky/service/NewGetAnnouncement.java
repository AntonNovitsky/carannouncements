package by.novitsky.service;

import by.novitsky.dao.Dao;
import by.novitsky.entity.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NewGetAnnouncement {

  Dao<Announcement> dao;

  @Autowired
  public NewGetAnnouncement(@Qualifier("AnnouncementDao") Dao dao){
    this.dao = dao;
  }



  public Announcement service(Integer id){
    return dao.get(id);
  }

}
