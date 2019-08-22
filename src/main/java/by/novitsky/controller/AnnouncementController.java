package by.novitsky.controller;

import by.novitsky.entity.Announcement;
import by.novitsky.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/announcements")
public class AnnouncementController {

  @GetMapping
  public List<Announcement> allAnnouncements() {
    return new GetAllAnnouncements().service();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Announcement getAnnouncement(@PathVariable Integer id) {

    Announcement announcement = new GetAnnouncement().service(id);
    if (!Optional.ofNullable(announcement).isPresent()) {
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
  @ResponseStatus(HttpStatus.OK)
  public void postAnnouncement(@RequestBody Announcement announcement) {
    new CreateAnnouncement().service(announcement);
  }

  @PutMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<String> updateAnnouncement(@RequestBody Announcement announcement, @PathVariable Integer id) {
    announcement.setId(id);
    new UpdateAnnouncement().service(announcement);
    return ResponseEntity.ok("");
  }

  @DeleteMapping(value = "/{id}")
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

}
