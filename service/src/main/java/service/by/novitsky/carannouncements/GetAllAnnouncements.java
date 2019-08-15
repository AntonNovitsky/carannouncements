package service.by.novitsky.carannouncements;


import dao.by.novitsky.carannouncements.AnnouncementDAO;
import entity.by.novitsky.carannouncements.Announcement;

import java.util.List;

public class GetAllAnnouncements {

    public List<Announcement> service(){
        List<Announcement> result = new AnnouncementDAO().getAllAnnouncements();
        return result;
    }



}
