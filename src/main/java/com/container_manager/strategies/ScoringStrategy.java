package com.container_manager.strategies;

import com.container_manager.entities.Notification;
import com.container_manager.enums.TransactionType;
import com.container_manager.pattern.NotificationStrategy;

public class ScoringStrategy implements NotificationStrategy {
  private double score = 0;

  @Override
  public void handleNotification(Notification event) {
    if (event.getTransaction().getType() == TransactionType.VENTE) {
      score += event.getTransaction().getAmount();
    } else {
      score -= event.getTransaction().getAmount();
    }
    System.out.println("New score after transaction: " + score);
  }

  public double getScore() {
    return score;
  }
}