package by.novitsky.dao;

import by.novitsky.entity.Announcement;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepository extends PagingAndSortingRepository<Announcement, Integer> {

}
