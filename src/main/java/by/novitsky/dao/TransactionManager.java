package by.novitsky.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManagerFactory;

public class TransactionManager {

  private EntityManagerFactory entityManagerFactory;

  @Autowired
  public TransactionManager(EntityManagerFactory entityManagerFactory){
    this.entityManagerFactory = entityManagerFactory;
  }
}
