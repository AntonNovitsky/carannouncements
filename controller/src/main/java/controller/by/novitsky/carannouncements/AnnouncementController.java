package controller.by.novitsky.carannouncements;

import entity.by.novitsky.carannouncements.Announcement;
import org.springframework.web.bind.annotation.*;
import service.by.novitsky.carannouncements.CreateAnnouncement;
import service.by.novitsky.carannouncements.GetAllAnnouncements;
import service.by.novitsky.carannouncements.GetAnnouncement;

import java.util.List;

@RestController
@RequestMapping("/announcements")
public class AnnouncementController {

    @GetMapping
    public List<Announcement> getListAnnouncements(){
        return new GetAllAnnouncements().service();
    }

    @GetMapping("/{id}")
    public Announcement getAnnouncement(@PathVariable Integer id){
        return new GetAnnouncement().service(id);
    }

    @PostMapping
    public void newAnnouncement(@RequestBody Announcement announcement){
        new CreateAnnouncement().service(announcement);
    }
}