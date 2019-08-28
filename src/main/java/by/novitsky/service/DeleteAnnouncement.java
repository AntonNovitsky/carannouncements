package by.novitsky.service;


import by.novitsky.dao.AnnouncementDAO;
import by.novitsky.dto.AnnouncementDTO;
import by.novitsky.entity.Announcement;

public class DeleteAnnouncement {

  public AnnouncementDTO service(int id) {
    Announcement blankIdWrapper = new Announcement();
    blankIdWrapper.setId(id);
    return new AnnouncementDTO(new AnnouncementDAO().delete(blankIdWrapper));
  }

}
