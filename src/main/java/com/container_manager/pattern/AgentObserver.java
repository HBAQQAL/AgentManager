package com.container_manager.pattern;

import com.container_manager.entities.Notification;

public interface AgentObserver {
  public void update(Notification notification);
}
