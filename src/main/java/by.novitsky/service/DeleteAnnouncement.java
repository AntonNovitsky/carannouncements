package by.novitsky.service;


import by.novitsky.dao.AnnouncementDAO;

public class DeleteAnnouncement {

    public void service(int id){
        new AnnouncementDAO().deleteAnnouncement(id);
    }

}
