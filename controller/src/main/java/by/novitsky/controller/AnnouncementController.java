package by.novitsky.controller;

import by.novitsky.entity.Announcement;
import org.springframework.web.bind.annotation.*;
import by.novitsky.service.CreateAnnouncement;
import by.novitsky.service.GetAllAnnouncements;
import by.novitsky.service.GetAnnouncement;

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