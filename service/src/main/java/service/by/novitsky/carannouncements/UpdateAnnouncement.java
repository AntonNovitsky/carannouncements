package service.by.novitsky.carannouncements;

import dao.by.novitsky.carannouncements.AnnouncementDAO;
import entity.by.novitsky.carannouncements.Announcement;

public class UpdateAnnouncement {

    public void service(Announcement announcement){
        new AnnouncementDAO().updateAnnouncement(announcement);
    }

}
