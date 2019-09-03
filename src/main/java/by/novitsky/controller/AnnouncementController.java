package by.novitsky.controller;

import by.novitsky.dto.AnnouncementDTO;
import by.novitsky.dto.AnnouncementDTORequest;
import by.novitsky.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/announcements")
public class AnnouncementController {


  @Autowired
  AnnouncementService getAnnouncement;

  @GetMapping
  public List<AnnouncementDTO> get(){
    return getAnnouncement.get();
  }

  @GetMapping("/{id}")
  public AnnouncementDTO get(@PathVariable Integer id){
    return getAnnouncement.get(id);
  }

  @PostMapping
  public AnnouncementDTO save(@RequestBody AnnouncementDTORequest announcementDTORequest){
    return getAnnouncement.save(announcementDTORequest);
  }

  @PutMapping("/{id}")
  public AnnouncementDTO update(@RequestBody AnnouncementDTORequest announcementDTORequest, @PathVariable Integer id){
    return getAnnouncement.update(announcementDTORequest, id);
  }

  @DeleteMapping("/{id}")
  public AnnouncementDTO delete(@PathVariable Integer id){
    return getAnnouncement.delete(id);
  }

}
