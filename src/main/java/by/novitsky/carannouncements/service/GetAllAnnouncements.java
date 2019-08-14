package by.novitsky.carannouncements.service;

import by.novitsky.carannouncements.dao.AnnouncementDAO;
import by.novitsky.carannouncements.entity.Announcement;

import java.util.List;

public class GetAllAnnouncements {

    public List<Announcement> service(){
        List<Announcement> result = new AnnouncementDAO().getAllAnnouncements();
        return result;
    }



}
