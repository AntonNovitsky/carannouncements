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
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/announcements")
@Validated
public class AnnouncementController {

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public List<Announcement> allAnnouncements() {
    return new GetAllAnnouncements().service();
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public Announcement getAnnouncement(@PathVariable Integer id) {

    Announcement announcement = new GetAnnouncement().service(id);
    if (isNull(announcement)) {
            /*//First implementation
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ANNOUNCEMENT_NOT_FOUND);*/
            /*//Per exception
            throw new AnnouncementNotFoundExceptionPerException();*/
            /*//Per controller
            throw new AnnouncementNotFoundExceptionPerController();*/
      //Globally
      throw new AnnouncementNotFoundGlobal();
    }

    return announcement;


  }

  @PostMapping
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public void postAnnouncement(@RequestBody Announcement announcement) {
    new CreateAnnouncement().service(announcement);
  }

  @PutMapping(value = "/{id}")
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<String> updateAnnouncement(@RequestBody Announcement announcement, @PathVariable Integer id) {
    announcement.setId(id);
    new UpdateAnnouncement().service(announcement);
    return ResponseEntity.ok("");
  }

  @DeleteMapping(value = "/{id}")
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<String> deleteAnnouncement(@PathVariable Integer id) {
    new DeleteAnnouncement().service(id);
    return ResponseEntity.ok("");
  }

  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  @ExceptionHandler(AnnouncementNotFoundExceptionPerController.class)
  public void noSuchAnnouncement(HttpServletResponse resp) throws IOException {
    resp.getWriter().println("Per controller: no such announcement");
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public void typeMismatch(HttpServletResponse response) throws IOException {
    response.getWriter().println("Bad request - id have to be of type Integer : ");
  }

  private static <T> Boolean isNull(T input) {
    return input == null;
  }

}
