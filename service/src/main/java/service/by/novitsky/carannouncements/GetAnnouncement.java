package service.by.novitsky.carannouncements;


import dao.by.novitsky.carannouncements.AnnouncementDAO;
import entity.by.novitsky.carannouncements.Announcement;

public class GetAnnouncement {

    public Announcement service(int id){
        Announcement result = new AnnouncementDAO().getAnnouncement(id);
        return result;
    }

}
