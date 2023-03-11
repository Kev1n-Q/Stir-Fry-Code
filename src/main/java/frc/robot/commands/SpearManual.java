// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SpearSubsytem;

public class SpearManual extends CommandBase {
  private final SpearSubsytem spearSubsytem;
  private final double sSpeed;

  /** Creates a new SpearManual. */
  public SpearManual(SpearSubsytem spearSubsytem, double sSpeed) {
    this.sSpeed = sSpeed;
    this.spearSubsytem = spearSubsytem;

    addRequirements(spearSubsytem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    spearSubsytem.setSpearMotorSpeed(.2*sSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    spearSubsytem.setSpearMotorSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
