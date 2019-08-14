package by.novitsky.carannouncements.service;

import by.novitsky.carannouncements.dao.AnnouncementDAO;
import by.novitsky.carannouncements.entity.Announcement;

public class GetAnnouncement {

    public Announcement service(int id){
        Announcement result = new AnnouncementDAO().getAnnouncement(id);
        return result;
    }

}
