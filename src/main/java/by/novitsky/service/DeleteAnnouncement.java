package by.novitsky.service;


import by.novitsky.dao.AnnouncementDAO;
import by.novitsky.entity.Announcement;

public class DeleteAnnouncement {

  public Announcement service(int id) {
    return new AnnouncementDAO().deleteAnnouncement(id);
  }

}
