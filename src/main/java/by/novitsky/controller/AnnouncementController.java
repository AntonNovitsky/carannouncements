package by.novitsky.controller;

import by.novitsky.entity.Announcement;
import by.novitsky.service.NewGetAnnouncement;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/announcements")
public class AnnouncementController {


  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public void noSuchAnnouncement(HttpServletResponse resp) throws IOException {
    resp.getWriter().println("Per controller: no such announcement");
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(TypeMismatchException.class)
  public void numberFormatExceptionHandler(HttpServletResponse response, Exception exception) throws IOException {
    response.getWriter().println(exception.getMessage() + " " + exception.getClass());
    exception.printStackTrace();
  }

  private final NewGetAnnouncement newGetAnnouncement;

  @Autowired
  public AnnouncementController(NewGetAnnouncement newGetAnnouncement) {
    this.newGetAnnouncement = newGetAnnouncement;
  }

  @GetMapping("/mock")
  public Announcement mock(){
    return newGetAnnouncement.service(1);
  }
}
