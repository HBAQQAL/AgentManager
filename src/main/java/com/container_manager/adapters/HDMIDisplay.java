package com.container_manager.adapters;

import java.util.Map;

import com.container_manager.entities.Agent;

public class HDMIDisplay implements HDMI {
  @Override
  public void display(Map<String, Agent> data) {
    System.out.println("=== HDMI Display ===");
    data.forEach((name, agent) -> {
      System.out.println("Agent: " + name);
    });
    System.out.println("==================");
  }
}