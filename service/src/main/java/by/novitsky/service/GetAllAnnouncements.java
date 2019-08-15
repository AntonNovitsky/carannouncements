package by.novitsky.service;


import by.novitsky.dao.AnnouncementDAO;
import by.novitsky.entity.Announcement;

import java.util.List;

public class GetAllAnnouncements {

    public List<Announcement> service(){
        List<Announcement> result = new AnnouncementDAO().getAllAnnouncements();
        return result;
    }



}
