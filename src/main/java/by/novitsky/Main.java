package by.novitsky;

import by.novitsky.cofiguration.ConfigurationManager;

public class Main {
  public static void main(String[] args) {
    System.out.println(ConfigurationManager.getProperty("db.url"));
  }
}
