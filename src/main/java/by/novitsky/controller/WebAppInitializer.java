package by.novitsky.controller;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext root =
        new AnnotationConfigWebApplicationContext();

    root.scan("by.novitsky");

    servletContext.addListener(new ContextLoaderListener(root));

    ServletRegistration.Dynamic appServlet;
    appServlet = servletContext.addServlet("Dispatcher", new DispatcherServlet(root));
    appServlet.setLoadOnStartup(1);
    appServlet.addMapping("/");

    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
