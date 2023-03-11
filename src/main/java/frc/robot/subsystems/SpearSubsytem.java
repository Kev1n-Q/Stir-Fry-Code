// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SpearConstants;

public class SpearSubsytem extends SubsystemBase {
  private TalonFX m_SpearFalcon = new TalonFX(SpearConstants.kSpearDriveID);
  public SpearSubsytem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setSpearMotorSpeed(double sSpeed) {
    m_SpearFalcon.set(TalonFXControlMode.PercentOutput, sSpeed);
  }
}
