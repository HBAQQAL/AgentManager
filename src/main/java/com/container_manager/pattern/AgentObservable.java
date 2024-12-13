package com.container_manager.pattern;

import com.container_manager.entities.Transaction;

public interface AgentObservable {
  void subscribe(AgentObserver observer);

  void unsubscribe(AgentObserver observer);

  void notifyObservers(Transaction transaction);
}
