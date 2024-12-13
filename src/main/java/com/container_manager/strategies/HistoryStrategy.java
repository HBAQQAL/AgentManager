package com.container_manager.strategies;

import java.util.ArrayList;
import java.util.List;

import com.container_manager.entities.Notification;
import com.container_manager.entities.Transaction;
import com.container_manager.pattern.NotificationStrategy;

public class HistoryStrategy implements NotificationStrategy {
  private final List<Transaction> history = new ArrayList<>();

  @Override
  public void handleNotification(Notification event) {
    history.add(event.getTransaction());
    System.out.println("Added transaction to history. Total transactions: " + history.size());
  }

  public List<Transaction> getHistory() {
    return new ArrayList<>(history);
  }
}
