package by.novitsky.service;


import by.novitsky.dao.AnnouncementDAO;
import by.novitsky.entity.Announcement;

public class GetAnnouncement {

    public Announcement service(int id){
        Announcement result = new AnnouncementDAO().getAnnouncement(id);
        return result;
    }

}
