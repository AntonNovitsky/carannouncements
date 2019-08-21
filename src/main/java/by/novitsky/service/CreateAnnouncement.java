package by.novitsky.service;


import by.novitsky.entity.Announcement;
import by.novitsky.dao.AnnouncementDAO;

public class CreateAnnouncement {

  public void service(Announcement announcement) {
    new AnnouncementDAO().createAnnouncement(announcement);
  }

}
