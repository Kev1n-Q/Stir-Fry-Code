// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.LimelightSubsystem;

public class Pipeline0Command extends CommandBase {

  private final LimelightSubsystem limelightSubsystem;
  
  /** Creates a new Pipeline0Command. */
  public Pipeline0Command(LimelightSubsystem limelightSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.limelightSubsystem = limelightSubsystem;
    addRequirements(limelightSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    limelightSubsystem.setPipeline(Constants.VisionConstants.Cube_Pipeline); //  Pipeline 0
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
