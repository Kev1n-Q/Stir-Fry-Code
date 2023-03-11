// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmDropSubsystem;

public class ArmDropManual extends CommandBase {
  private final ArmDropSubsystem armDropSubsystem;
  private final double aSpeed;
  private final DigitalInput armStop;

  /** Creates a new ArmDropManual. */
  public ArmDropManual(ArmDropSubsystem armDropSubsystem, double aSpeed, DigitalInput armStop) {
    this.aSpeed = aSpeed;
    this.armDropSubsystem = armDropSubsystem;
    this.armStop = armStop;
    addRequirements(armDropSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (aSpeed > 0) {
      if (armStop.get()) {
        armDropSubsystem.ArmDropMotorSpeed(0);

      } else {
        armDropSubsystem.ArmDropMotorSpeed(aSpeed);
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
