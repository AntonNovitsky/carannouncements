package by.novitsky.service;


import by.novitsky.entity.Announcement;
import by.novitsky.dao.AnnouncementDAO;

public class CreateAnnouncement {

  public Announcement service(Announcement announcement) {
    return new AnnouncementDAO().createAnnouncement(announcement);
  }

}
