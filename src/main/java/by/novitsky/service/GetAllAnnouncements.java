package by.novitsky.service;


import by.novitsky.dao.AnnouncementDAO;
import by.novitsky.dto.AnnouncementDTO;

import java.util.List;
import java.util.stream.Collectors;

public class GetAllAnnouncements {

  public List<AnnouncementDTO> service() {
    List<AnnouncementDTO> result = new AnnouncementDAO().getAll().stream().map(x -> new AnnouncementDTO(x)).collect(Collectors.toList());
    return result;
  }


}
