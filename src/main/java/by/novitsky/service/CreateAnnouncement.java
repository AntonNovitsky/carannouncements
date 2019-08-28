package by.novitsky.service;


import by.novitsky.dao.AnnouncementDAO;
import by.novitsky.dto.AnnouncementDTO;
import by.novitsky.entity.Announcement;

public class CreateAnnouncement {

  public AnnouncementDTO service(Announcement announcement) {
    return new AnnouncementDTO(new AnnouncementDAO().create(announcement));
  }

}
