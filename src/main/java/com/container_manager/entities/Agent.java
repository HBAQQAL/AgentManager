package com.container_manager.entities;

import java.util.ArrayList;
import java.util.List;

import com.container_manager.pattern.AgentObservable;
import com.container_manager.pattern.AgentObserver;
import com.container_manager.pattern.NotificationStrategy;

public class Agent implements AgentObserver, AgentObservable {
  private String name;

  private List<Transaction> transactions;

  private List<AgentObserver> observers;

  private NotificationStrategy strategy;

  public Agent(String name) {
    this.name = name;
    this.transactions = new ArrayList<>();
    this.observers = new ArrayList<>();

  }

  public Agent() {
  }

  @Override
  public void subscribe(AgentObserver observer) {
    if (!observers.contains(observer)) {
      observers.add(observer);
      System.out.println(((Agent) observer).getName() + " subscribed to " + this.name);
    }
  }

  @Override
  public void unsubscribe(AgentObserver observer) {
    observers.remove(observer);
    System.out.println(((Agent) observer).getName() + " unsubscribed from " + this.name);
  }

  @Override
  public void notifyObservers(Transaction transaction) {
    Notification event = new Notification(this.name, transaction);
    for (AgentObserver observer : observers) {
      observer.update(event);
    }
  }

  public void setStrategy(NotificationStrategy strategy) {
    this.strategy = strategy;
    System.out.println(this.name + " changed strategy to " + strategy.getClass().getSimpleName());
  }

  @Override
  public void update(Notification notification) {

    System.out.println("received new notification from " + notification.getName());
    strategy.handleNotification(notification);
  }

  public void addTransaction(Transaction transaction) {
    transactions.add(transaction);
    System.out.println("Added transaction to " + this.name);
    notifyObservers(transaction);
  }

  public String getName() {
    return this.name;
  }

}
