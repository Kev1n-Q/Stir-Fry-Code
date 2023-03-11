// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveTrain extends SubsystemBase {

  //Establishes drive motor controllers
  private CANSparkMax frontLeftMotor = new CANSparkMax(DriveConstants.kFLDriveID, MotorType.kBrushless);
  private CANSparkMax frontRightMotor = new CANSparkMax(DriveConstants.kFRDriveID, MotorType.kBrushless);
  private CANSparkMax backLeftMotor = new CANSparkMax(DriveConstants.kBLDriveID, MotorType.kBrushless);
  private CANSparkMax backRightMotor = new CANSparkMax(DriveConstants.kBRDriveID, MotorType.kBrushless);


  //Consolidates left motors and right motors into motor groups through MotorControllerGroup
  private MotorControllerGroup m_leftSide = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
  private MotorControllerGroup m_rightSide = new MotorControllerGroup(frontRightMotor, backRightMotor);

  //Combines motor control groups into a DifferentialDrive function
  private DifferentialDrive arcDrive = new DifferentialDrive(m_leftSide, m_rightSide);


  public DriveTrain() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setArcadeSpeed (double moveSpeed, double rotateSpeed){
    arcDrive.arcadeDrive(moveSpeed, rotateSpeed);
    System.out.println("Drive speed: " + moveSpeed + ", Rotate Speed: " + rotateSpeed);
  }

  public void stop() {
    setArcadeSpeed(0, 0); 
  }
  
}