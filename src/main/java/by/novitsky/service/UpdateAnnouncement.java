package by.novitsky.service;

import by.novitsky.dao.AnnouncementDAO;
import by.novitsky.entity.Announcement;

public class UpdateAnnouncement {

  public void service(Announcement announcement) {
    new AnnouncementDAO().updateAnnouncement(announcement);
  }

}
