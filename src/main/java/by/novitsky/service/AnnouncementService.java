package by.novitsky.service;

import by.novitsky.dao.AnnouncementRepository;
import by.novitsky.dao.CarRepository;
import by.novitsky.dto.AnnouncementDTO;
import by.novitsky.dto.AnnouncementDTORequest;
import by.novitsky.entity.Announcement;
import by.novitsky.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnnouncementService {

  private AnnouncementRepository repository;
  private CarRepository carRepository;

  @Autowired
  public AnnouncementService(AnnouncementRepository repository, CarRepository carRepository) {
    this.repository = repository;
    this.carRepository = carRepository;
  }

  public List<AnnouncementDTO> get(){
    Iterable<Announcement> announcements = repository.findAll();
    List<AnnouncementDTO> result = new ArrayList<>();
    for (Announcement temp: announcements){
      result.add(new AnnouncementDTO(temp));
    }
    return result;
  }

  public AnnouncementDTO get(Integer id){
    Announcement announcement = repository.findById(id)
        .orElseThrow(() -> new RuntimeException(this.getClass() + " : No such announcement"));
    return new AnnouncementDTO(announcement);
  }

  public AnnouncementDTO save(AnnouncementDTORequest announcementDTORequest){
    Announcement announcement;
    if (!Optional.ofNullable(announcementDTORequest.getId()).isPresent()){
      announcement = new Announcement();
    } else {
      announcement = repository.findById(announcementDTORequest.getId()).orElse(new Announcement());
    }
    announcement.setDateCreated(LocalDateTime.now());
    Boolean isActive = announcementDTORequest.getIsActive();
    announcement.setActive(Optional.ofNullable(isActive).orElse(true));
    if (announcement.getCar() == null){
      Car car = carRepository.findById(announcementDTORequest.getCarID()).orElseThrow(RuntimeException::new);
      announcement.setCar(car);
    }
    announcement = repository.save(announcement);
    AnnouncementDTO result = new AnnouncementDTO(announcement);
    return result;
  }

  public AnnouncementDTO update(AnnouncementDTORequest announcementDTORequest, Integer id){
    announcementDTORequest.setId(id);
    return this.save(announcementDTORequest);
  }

  public AnnouncementDTO delete(Integer id){
    AnnouncementDTO result = new AnnouncementDTO(repository.findById(id).orElse(new Announcement()));
    repository.deleteById(id);
    return result;
  }

  public List<AnnouncementDTO> getPaginated(int page, int size){
    Page<Announcement> pageObj = repository.findAll(PageRequest.of(page, size));
    List<AnnouncementDTO> result = new ArrayList<>();
    for(Announcement temp: pageObj){
      result.add(new AnnouncementDTO(temp));
    }
    return result;
  }

}
