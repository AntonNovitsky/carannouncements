package by.novitsky.service;


import by.novitsky.controller.AnnouncementNotFoundGlobal;
import by.novitsky.dao.AnnouncementDAO;
import by.novitsky.dto.AnnouncementDTO;
import by.novitsky.entity.Announcement;

import java.util.Optional;

public class GetAnnouncement {

  public AnnouncementDTO service(int id) {
    Announcement result = new AnnouncementDAO().get(id);
    if (!Optional.ofNullable(result).isPresent()){
      throw new AnnouncementNotFoundGlobal();
    }
    return new AnnouncementDTO(result);
  }

}
