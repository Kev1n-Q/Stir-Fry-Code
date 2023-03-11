// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LimelightSubsystem extends SubsystemBase {

  private static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    
  private static double tx;
  private static int validTargets;
  private static double targetArea;

  private static int currentPipeline = Constants.VisionConstants.Default_Pipeline; // April Tags

  public void setPipeline(int pipeline) {
    currentPipeline = pipeline;
    table.getEntry("pipeline").setNumber(pipeline);
  }

  public int getCurrentPipeline() {
    return currentPipeline;
  }

  public void updateLimelightValues() {
    tx = table.getEntry("tx").getDouble(0.0);
    targetArea = table.getEntry("ta").getDouble(0.0);
    validTargets = table.getEntry("tv").getNumber(0).intValue();
  } 

  public double getTX() {
    return tx;
  }

  public double getTargetArea() {
    return targetArea;
  }

  public int hasValidTargets() {
    return validTargets;
  }

  /** Creates a new LimelightSubsystem. */
  public LimelightSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    updateLimelightValues();
  }
}
