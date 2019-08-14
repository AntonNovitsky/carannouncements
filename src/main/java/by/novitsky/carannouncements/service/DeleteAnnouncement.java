package by.novitsky.carannouncements.service;

import by.novitsky.carannouncements.dao.AnnouncementDAO;
import by.novitsky.carannouncements.entity.Announcement;

public class DeleteAnnouncement {

    public void service(int id){
        new AnnouncementDAO().deleteAnnouncement(id);
    }

}
