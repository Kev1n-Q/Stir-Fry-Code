// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.LimelightSubsystem;

public class AutoAlignCommand extends CommandBase {

  private final DriveTrain driveTrain;
  private final LimelightSubsystem limelightSubsystem;
  
  /** Creates a new AutoAlignCommand. */
  public AutoAlignCommand(DriveTrain driveTrain, LimelightSubsystem limelightSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveTrain = driveTrain;
    this.limelightSubsystem = limelightSubsystem;
    addRequirements(driveTrain, limelightSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    limelightSubsystem.setPipeline(Constants.VisionConstants.Default_Pipeline); // pipeline 0 (ATags)
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

     // this will run periodically 
     limelightSubsystem.updateLimelightValues(); 

     double tx = limelightSubsystem.getTX(); 
     double targetArea = limelightSubsystem.getTargetArea(); 
     double validTargets = limelightSubsystem.hasValidTargets();
     
     double currentPipeline = limelightSubsystem.getCurrentPipeline();

      
    // CUBES
    if (currentPipeline == 0) { 
      if (validTargets == 1) {
        // targetArea == 0.5 && targetArea == 3
        if (targetArea >= Constants.AutoAlignConstants.cubeMinTargetArea && targetArea <= Constants.AutoAlignConstants.cubeMaxTargetArea) { // if within this range, run this
          if (Math.abs(tx) <= 0.5 && targetArea >= 2) {
            driveTrain.stop(); // if tx is less than or equal to 0.5, it means we're really close -> stop
            System.out.println("You're good to go! - READY"); 
          } else if (tx > 0.5) {  // if tx is > 0.5, run this 
              if (targetArea < 2) {
                driveTrain.setArcadeSpeed(Constants.AutoAlignConstants.driveSpeed, -Constants.AutoAlignConstants.rotateSpeed);
                System.out.println("NOT GOOD DISTANCE - NOT ALIGNED"); 
              } else if (targetArea >= 2) {
                driveTrain.setArcadeSpeed(0, -Constants.AutoAlignConstants.rotateSpeed);
                System.out.println("GOOD DISTANCE - NOT ALIGNED)"); 
              }  
          } else if (tx < -0.5) { // if tx is < -0.5 (left) ** more to the left than 0.5, ** then run this
              if (targetArea < 2) { // figure out where negative and positive rotations go****
              driveTrain.setArcadeSpeed(Constants.AutoAlignConstants.driveSpeed, Constants.AutoAlignConstants.rotateSpeed);
              System.out.println("NOT GOOD DISTANCE - NOT ALIGNED");
            } else if (targetArea >= 2) {
              driveTrain.setArcadeSpeed(0, Constants.AutoAlignConstants.rotateSpeed);
              System.out.println("GOOD DISTANCE - NOT ALIGNED"); 
            }
          } 
        } 
  
        else { // else, we're too far, don't do anything (switch to DefaultDriveCommand!)
          driveTrain.stop(); 
          System.out.println("Not in range!!! GET CLOSER"); 
        }  
      } else {
        driveTrain.stop();
      }
    } 
    
    // CONES
    else if (currentPipeline == 1) { 
      if (validTargets == 1) {
        // targetArea == 0.5 && targetArea == 3
        if (targetArea >= Constants.AutoAlignConstants.coneMinTargetArea && targetArea <= Constants.AutoAlignConstants.coneMaxTargetArea) { // if within this range, run this
          if (Math.abs(tx) <= 0.5 && targetArea >= 2) {
            driveTrain.stop(); // if tx is less than or equal to 0.5, it means we're really close -> stop
            System.out.println("You're good to go! - READY"); 
          } else if (tx > 0.5) {  // if tx is > 0.5, run this 
              if (targetArea < 2) {
                driveTrain.setArcadeSpeed(Constants.AutoAlignConstants.driveSpeed, -Constants.AutoAlignConstants.rotateSpeed);
                System.out.println("NOT GOOD DISTANCE - NOT ALIGNED"); 
              } else if (targetArea >= 2) {
                driveTrain.setArcadeSpeed(0, -Constants.AutoAlignConstants.rotateSpeed);
                System.out.println("GOOD DISTANCE - NOT ALIGNED)"); 
              }  
          } else if (tx < -0.5) { // if tx is < -0.5 (left) ** more to the left than 0.5, ** then run this
              if (targetArea < 2) { // figure out where negative and positive rotations go****
              driveTrain.setArcadeSpeed(Constants.AutoAlignConstants.driveSpeed, Constants.AutoAlignConstants.rotateSpeed);
              System.out.println("NOT GOOD DISTANCE - NOT ALIGNED");
            } else if (targetArea >= 2) {
              driveTrain.setArcadeSpeed(0, Constants.AutoAlignConstants.rotateSpeed);
              System.out.println("GOOD DISTANCE - NOT ALIGNED"); 
            }
          } 
        } 
  
        else { // else, we're too far, don't do anything (switch to DefaultDriveCommand!)
          driveTrain.stop(); 
          System.out.println("Not in range!!! GET CLOSER"); 
        }  
      } else {
        driveTrain.stop();
      }
    } 

  }
  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

}
