package by.novitsky.cofiguration;

import java.util.ResourceBundle;


public class ConfigurationManager {

  private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

  private ConfigurationManager() {
  }

  public static String getProperty(String key) {
    return resourceBundle.getString(key);
  }
  public static String getUrl(){
    return new StringBuffer()
        .append(getProperty("db.url"))
        .append("?user=")
        .append(getProperty("user"))
        .append("&password=")
        .append(getProperty("password"))
        .toString();
  }
}