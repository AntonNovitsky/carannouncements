package by.novitsky.controller;

import by.novitsky.entity.Announcement;
import by.novitsky.service.GetAllAnnouncements;
import by.novitsky.service.GetAnnouncement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/announcements")
public class AnnouncementController {

    @GetMapping(produces = "application/json")
    public @ResponseBody String allAnnouncements(){
        return new GetAllAnnouncements().service().toString();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public @ResponseBody ResponseEntity<String> getAnnouncement(@PathVariable Integer id){
        Announcement announcement = new GetAnnouncement().service(id);
        if (announcement == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.ok(announcement.toString());
        }
    }

    @PostMapping
    public void postAnnouncement(){

    }






}
