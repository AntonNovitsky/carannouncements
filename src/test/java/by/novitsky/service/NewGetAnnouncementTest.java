package by.novitsky.service;

import by.novitsky.dao.SessionFactoryConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class NewGetAnnouncementTest {

  @Test
  public void getAnnouncement(){
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(/*NewGetAnnouncement.class,*/ SessionFactoryConfig.class);
    NewGetAnnouncement dao = ctx.getBean(NewGetAnnouncement.class);
    System.out.println(dao.service(1));
  }

}