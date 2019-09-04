package by.novitsky.dao;

import by.novitsky.entity.Announcement;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import springfox.documentation.annotations.Cacheable;

import java.util.Optional;

@Repository
public interface AnnouncementRepository extends PagingAndSortingRepository<Announcement, Integer> {

  @Cacheable("announcements")
  Optional<Announcement> findById(Integer id);

}
