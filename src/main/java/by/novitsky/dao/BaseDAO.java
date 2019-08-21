package by.novitsky.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseDAO {

  /*public static final String DB_URL = "jdbc:postgresql://localhost:5432/carsforsale";
  public static final String USER = "postgres";
  public static final String PASS = "root";
  public static final String URL_PARAMS = DB_URL + "?user=" + USER +  "&password=" + PASS;*/
  //public static final String PROPERTIES_PATH = "src/main/resources/config.properties";
  public static final String PROPERTIES_PATH = "config.properties";

  private Properties properties;
  private String urlParams;
  private String dbUrl;
  private String user;
  private String password;
//ConfigurationManager.getProperty("path.page.login");


  private static BaseDAO baseDAO;

  static {
    baseDAO = new BaseDAO();
  }

  private BaseDAO() {
    properties = new Properties();
    try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(PROPERTIES_PATH)) {
      properties.load(is);
      dbUrl = properties.getProperty("db_url");
      user = properties.getProperty("user");
      password = properties.getProperty("password");
      urlParams = new StringBuffer()
          .append(dbUrl)
          .append("?user=")
          .append(user)
          .append("&password=")
          .append(password)
          .toString();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String getUrlParams() {
    return baseDAO.urlParams;
  }
}
