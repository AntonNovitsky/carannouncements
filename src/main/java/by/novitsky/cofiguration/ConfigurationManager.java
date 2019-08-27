package by.novitsky.cofiguration;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.util.Properties;


public class ConfigurationManager {

  private final static Properties properties;

  public static final String DB_URL = "spring.datasource.url";
  public static final String DB_USERNAME = "spring.datasource.username";
  public static final String DB_PASSWORD = "spring.datasource.password";
  public static final String URL_PATH_CONCAT_USER = "?user=";
  public static final String URL_PATH_CONCAT_PASSWORD = "&password=";

  static{
    YamlPropertiesFactoryBean applicationProperties = new YamlPropertiesFactoryBean();
    applicationProperties.setResources(new ClassPathResource("application.yaml"));
    properties = applicationProperties.getObject();
  }

  private ConfigurationManager() {
  }

  public static String getProperty(String key) {
    return properties.getProperty(key);
    //return resourceBundle.getString(key);
  }

  public static String getUrl(){
    return new StringBuffer()
        .append(getProperty(DB_URL))
        .append(URL_PATH_CONCAT_USER)
        .append(getProperty(DB_USERNAME))
        .append(URL_PATH_CONCAT_PASSWORD)
        .append(getProperty(DB_PASSWORD))
        .toString();
  }
}