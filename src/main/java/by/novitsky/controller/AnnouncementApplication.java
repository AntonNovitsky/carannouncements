package by.novitsky.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableConfigurationProperties
//@EnableTransactionManagement
@SpringBootApplication
@EnableSwagger2
@ComponentScan("by.novitsky")
@EntityScan("by.novitsky.entity")
public class AnnouncementApplication {

  public static void main(String[] args) {
    SpringApplication.run(AnnouncementApplication.class, args);
  }

}
