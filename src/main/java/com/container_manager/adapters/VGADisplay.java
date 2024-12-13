package com.container_manager.adapters;

import java.util.Map;

import com.container_manager.entities.Agent;

public class VGADisplay {
  public void displayVGA(Map<String, Agent> data) {
    System.out.println("=== VGA Display ===");
    data.forEach((name, agent) -> {
      System.out.println("Agent: " + name);
    });
    System.out.println("==================");
  }
}