package by.novitsky.cofiguration;

import java.util.ResourceBundle;


public class ConfigurationManager {

//  private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/pageconfig");
  private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

  private ConfigurationManager() {
  }

  public static String getProperty(String key) {
    return resourceBundle.getString(key);
  }
}