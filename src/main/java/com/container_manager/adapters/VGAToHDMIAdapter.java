package com.container_manager.adapters;

import java.util.Map;

import com.container_manager.entities.Agent;

public class VGAToHDMIAdapter implements HDMI {
  private final VGADisplay vgaDisplay;

  public VGAToHDMIAdapter(VGADisplay vgaDisplay) {
    this.vgaDisplay = vgaDisplay;
  }

  @Override
  public void display(Map<String, Agent> data) {
    vgaDisplay.displayVGA(data);
  }
}
