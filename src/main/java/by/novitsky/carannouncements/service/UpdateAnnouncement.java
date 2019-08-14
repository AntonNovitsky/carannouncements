package by.novitsky.carannouncements.service;

import by.novitsky.carannouncements.dao.AnnouncementDAO;
import by.novitsky.carannouncements.entity.Announcement;

public class UpdateAnnouncement {

    public void service(Announcement announcement){
        new AnnouncementDAO().updateAnnouncement(announcement);
    }

}
