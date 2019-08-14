package by.novitsky.carannouncements.servlet;

import by.novitsky.carannouncements.validation.Validator;
import by.novitsky.carannouncements.validation.IdValidator;
import by.novitsky.carannouncements.entity.Announcement;
import by.novitsky.carannouncements.service.GetAllAnnouncements;
import by.novitsky.carannouncements.service.GetAnnouncement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = "/announcements")
public class AnnouncementListServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String idParam = req.getParameter("id");
       /* Optional.ofNullable(idParam)
                .filter(validator::validate)
                .map(Integer::valueOf)
                .map(v -> v.toString())
                .orElse(showAllAnnouncements(out).toString())*/
       /*Optional.ofNullable(idParam)
               .filter(validator::validate)
               .map(Integer::valueOf)
               .map(x -> getAnnouncement(x))
               .orElse(x -> getAnnouncements())*/
        List<Announcement> announcements = new GetAllAnnouncements().service();
        announcements.forEach(out::println);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Announcement result = new Announcement();
    }
}
