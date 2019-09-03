package by.novitsky.controller;

import by.novitsky.dto.AnnouncementDTO;
import by.novitsky.dto.AnnouncementDTORequest;
import by.novitsky.service.AnnouncementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/announcements")
public class AnnouncementController {


  private AnnouncementService announcementService;

  @GetMapping
  public List<AnnouncementDTO> get(){
    return announcementService.get();
  }

  @GetMapping("/{id}")
  public AnnouncementDTO get(@PathVariable Integer id){
    return announcementService.get(id);
  }

  @PostMapping
  public AnnouncementDTO save(@RequestBody AnnouncementDTORequest announcementDTORequest){
    return announcementService.save(announcementDTORequest);
  }

  @PutMapping("/{id}")
  public AnnouncementDTO update(@RequestBody AnnouncementDTORequest announcementDTORequest, @PathVariable Integer id){
    return announcementService.update(announcementDTORequest, id);
  }

  @DeleteMapping("/{id}")
  public AnnouncementDTO delete(@PathVariable Integer id){
    return announcementService.delete(id);
  }

}
