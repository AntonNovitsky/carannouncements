package by.novitsky.carannouncements.servlet;

import by.novitsky.carannouncements.entity.Announcement;
import by.novitsky.carannouncements.service.DeleteAnnouncement;
import by.novitsky.carannouncements.service.GetAnnouncement;
import by.novitsky.carannouncements.validation.IdValidator;
import by.novitsky.carannouncements.validation.Validator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/announcements/*")
public class AnnouncementServlet extends HttpServlet {

    public static final int BAD_REQUEST = 400;
    Validator validator = new IdValidator();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = getID(req);
        if ("".equals(idParam)){
            resp.sendRedirect("../announcements");
        } else {
            if(!validator.validate(idParam)){
                resp.setStatus(BAD_REQUEST);
                resp.sendError(400, "Invalid id parameter");
            } else {
                Integer id = Integer.valueOf(idParam);
                Announcement announcement = new GetAnnouncement().service(id);
                resp.getWriter().println(announcement);
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = getID(req);
        if (!validator.validate(idParam)){
            resp.setStatus(400);
            resp.sendError(400, "Invalid id parameter");
        } else {
            Integer id = Integer.valueOf(idParam);
            new DeleteAnnouncement().service(id);
        }
    }

    private String getID(HttpServletRequest req){
        return req.getPathInfo().substring(1);
    }

}
