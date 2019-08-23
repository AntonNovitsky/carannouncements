package by.novitsky.service;

import by.novitsky.dao.AnnouncementDAO;
import by.novitsky.entity.Announcement;

public class UpdateAnnouncement {

  public Announcement service(Announcement announcement) {
    return new AnnouncementDAO().updateAnnouncement(announcement);
  }

}
