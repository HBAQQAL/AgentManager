package com.container_manager.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.container_manager.adapters.HDMI;

public class AgentContainer {
  private static AgentContainer instance;
  private Map<String, Agent> agents;
  private List<HDMI> displays;

  private AgentContainer() {
    this.agents = new HashMap<>();
    this.displays = new ArrayList<>();
  }

  public static synchronized AgentContainer getInstance() {
    if (instance == null) {
      instance = new AgentContainer();
    }
    return instance;
  }

  public void addAgent(Agent agent) {
    agents.put(agent.getName(), agent);
  }

  public void removeAgent(String name) {
    agents.remove(name);

  }

  public Agent findAgent(String name) {
    return agents.get(name);
  }

  public void addDisplay(HDMI display) {
    displays.add(display);
    display.display(agents);
  }

  public void removeDisplay(HDMI display) {
    displays.remove(display);
  }

  private void notifyDisplays() {
    for (HDMI display : displays) {
      display.display(agents);
    }
  }

  public void displayState() {
    System.out.println("\n=== Container State ===");
    System.out.println("Number of agents: " + agents.size());
    System.out.println("Number of displays: " + displays.size());
    System.out.println("=====================\n");
  }
}
