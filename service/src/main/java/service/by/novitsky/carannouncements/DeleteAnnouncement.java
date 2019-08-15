package service.by.novitsky.carannouncements;


import dao.by.novitsky.carannouncements.AnnouncementDAO;

public class DeleteAnnouncement {

    public void service(int id){
        new AnnouncementDAO().deleteAnnouncement(id);
    }

}
