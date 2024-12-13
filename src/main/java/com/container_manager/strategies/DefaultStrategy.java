package com.container_manager.strategies;

import com.container_manager.entities.Notification;
import com.container_manager.pattern.NotificationStrategy;

public class DefaultStrategy implements NotificationStrategy {
  @Override
  public void handleNotification(Notification event) {
    System.out.println("Default handling of notification from " + event.getName() +
        " with transaction amount: " + event.getTransaction().getAmount());
  }
}
