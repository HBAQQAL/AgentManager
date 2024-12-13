package com.container_manager.entities;

public class Notification {
  private final String agentName;
  private final Transaction transaction;

  public Notification(String name, Transaction transaction) {
    this.agentName = name;
    this.transaction = transaction;
  }

  public String getName() {
    return this.agentName;
  }

  public Transaction getTransaction() {
    return this.transaction;
  }

}
