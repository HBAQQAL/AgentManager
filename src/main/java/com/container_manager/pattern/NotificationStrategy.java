package com.container_manager.pattern;

import com.container_manager.entities.Notification;

public interface NotificationStrategy {
  void handleNotification(Notification event);

}
