package by.novitsky.controller;

import by.novitsky.entity.Announcement;
import by.novitsky.service.CreateAnnouncement;
import by.novitsky.service.DeleteAnnouncement;
import by.novitsky.service.GetAllAnnouncements;
import by.novitsky.service.GetAnnouncement;
import by.novitsky.service.UpdateAnnouncement;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/announcements")
@Validated
public class AnnouncementController {

    private static final String INVALID_ID_ERROR = "Invalid announcement id";
    private static final String ANNOUNCEMENT_NOT_FOUND ="Announcement with this id has not been found";


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Announcement> allAnnouncements(){
        return new GetAllAnnouncements().service();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> getAnnouncement(@PathVariable Integer id){

        Announcement announcement = new GetAnnouncement().service(id);
        if (announcement == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ANNOUNCEMENT_NOT_FOUND);
        } else {
           return ResponseEntity.ok(announcement);
        }

    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<String> postAnnouncement(@RequestBody Announcement announcement){
        new CreateAnnouncement().service(announcement);
        return ResponseEntity.ok("");
    }

    @PutMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<String> updateAnnouncement(@RequestBody Announcement announcement, @PathVariable Integer id){
        announcement.setId(id);
        new UpdateAnnouncement().service(announcement);
        return ResponseEntity.ok("");
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteAnnouncement(@PathVariable Integer id){
        new DeleteAnnouncement().service(id);
        return ResponseEntity.ok("");
    }

}
