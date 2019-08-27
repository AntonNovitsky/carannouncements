package by.novitsky.controller;

import by.novitsky.entity.Announcement;
import by.novitsky.service.*;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/announcements")
public class AnnouncementController {

  @GetMapping
  public List<Announcement> allAnnouncements(HttpServletRequest request) {
    List<Announcement> result = new GetAllAnnouncements().service();
    return result;
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
  public Announcement postAnnouncement(@RequestBody Announcement announcement) {
    return new CreateAnnouncement().service(announcement);
  }

  @PutMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Announcement updateAnnouncement(@RequestBody Announcement announcement, @PathVariable Integer id) {
    announcement.setId(id);
    return new UpdateAnnouncement().service(announcement);
  }

  @DeleteMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Announcement deleteAnnouncement(@PathVariable Integer id) {
    return new DeleteAnnouncement().service(id);
  }

  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  @ExceptionHandler(AnnouncementNotFoundExceptionPerController.class)
  public void noSuchAnnouncement(HttpServletResponse resp) throws IOException {
    resp.getWriter().println("Per controller: no such announcement");
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(TypeMismatchException.class)
  public void numberFormatExceptionHandler(HttpServletResponse response, Exception exception) throws IOException {
    response.getWriter().println(exception.getMessage() + " " + exception.getClass());
    exception.printStackTrace();
  }

}
