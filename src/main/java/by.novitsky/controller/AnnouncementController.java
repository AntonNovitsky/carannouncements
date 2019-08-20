package by.novitsky.controller;

import by.novitsky.entity.Announcement;
import by.novitsky.service.CreateAnnouncement;
import by.novitsky.service.GetAllAnnouncements;
import by.novitsky.service.GetAnnouncement;
import by.novitsky.validation.IdValidator;
import by.novitsky.validation.Validator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/announcements")
public class AnnouncementController {

    private static final String INVALID_ID_ERROR = "Invalid announcement id";
    private static final String ANNOUNCEMENT_NOT_FOUND ="Announcement with this id has not been found";


    @GetMapping(produces = "application/json")
    @ResponseBody
    public List<Announcement> allAnnouncements(){
        return new GetAllAnnouncements().service();
    }

    @GetMapping(value = "/{idString}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<String> getAnnouncement(@PathVariable String idString){
        Validator<String> validator = new IdValidator();

        if (validator.validate(idString)){
            Integer id = Integer.valueOf(idString);
            Announcement announcement = new GetAnnouncement().service(id);
            if (announcement == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ANNOUNCEMENT_NOT_FOUND);
            } else {
                return ResponseEntity.ok(announcement.toString());
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(INVALID_ID_ERROR);
        }

    }

    @PostMapping
    public void postAnnouncement(@RequestBody Announcement announcement){
        new CreateAnnouncement().service(announcement);
    }






}
