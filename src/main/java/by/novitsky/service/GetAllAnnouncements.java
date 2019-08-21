package by.novitsky.service;


import by.novitsky.entity.Announcement;
import by.novitsky.dao.AnnouncementDAO;

import java.util.List;

public class GetAllAnnouncements {

  public List<Announcement> service() {
    List<Announcement> result = new AnnouncementDAO().getAllAnnouncements();
    return result;
  }


}
