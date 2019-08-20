package by.novitsky.service;


import by.novitsky.dao.AnnouncementDAO;
import by.novitsky.entity.Announcement;

public class CreateAnnouncement {

    public void service(Announcement announcement){
        new AnnouncementDAO().createAnnouncement(announcement);
    }

}
