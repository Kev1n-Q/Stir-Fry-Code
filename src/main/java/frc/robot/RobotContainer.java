// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.ElevatorConstants;
import frc.robot.Constants.SpearConstants;
import frc.robot.commands.Auto1;
import frc.robot.commands.AutoAlignCommand;
import frc.robot.commands.ElevatorManual;
//import frc.robot.commands.ElevatorPID;
import frc.robot.commands.JoystickControl;
import frc.robot.commands.Pipeline0Command;
import frc.robot.commands.Pipeline1Command;
import frc.robot.commands.SpearManual;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ElevatorManualSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.SpearPID;
import frc.robot.subsystems.SpearSubsytem;
import frc.robot.subsystems.The_Pinch_n_Twist;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain driveTrain = new DriveTrain();
  private final LimelightSubsystem limelightSubsystem = new LimelightSubsystem();
  private final The_Pinch_n_Twist the_Pinch_n_Twist = new The_Pinch_n_Twist();
  private final ElevatorSubsystem elevatorPID = new ElevatorSubsystem();
  private final SpearSubsytem spearSubsytem = new SpearSubsytem();
  private final ElevatorManualSubsystem elevatorManualSubsytem = new ElevatorManualSubsystem();


  private final CommandXboxController driveController = new CommandXboxController(Constants.driveController_ID);
  private final CommandXboxController mechanismController = new CommandXboxController(Constants.mechanismController_ID);

  private final Command auto1 = new Auto1(driveTrain, null, null);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {


   /*  driveTrain.setDefaultCommand(new JoystickControl(driveTrain, 
    () -> driveController.getRawAxis(Constants.LeftY),  
    () -> driveController.getRawAxis(Constants.rightX)));*/

    //pneumaticsModule.PneumaticsOn();    

    driveTrain.setDefaultCommand(new JoystickControl(driveTrain,
     () -> driveController.getRawAxis(Constants.kLeft_Y),
     () -> -driveController.getRawAxis(Constants.kRight_X)));

     elevatorManualSubsytem.setDefaultCommand(new ElevatorManual(elevatorManualSubsytem, mechanismController.getRawAxis(Constants.kLeft_Y)));
     spearSubsytem.setDefaultCommand(new SpearManual(spearSubsytem, mechanismController.getRawAxis(Constants.kRight_X)));
    
    
     //spearPID.setDefaultCommand(new SetSpearPos(0, spearPID));


    configureButtonBindings();
  }


  private void configureButtonBindings() {
    
   // final JoystickButton kLeftBumper = new JoystickButton(mechanism1Controller, Constants.kLeft_Bumper);
    // final JoystickButton kRightBumper = new JoystickButton(mechanism1Controller, Constants.kRight_Bumper);



    mechanismController.button(Constants.kA_Button).toggleOnTrue(Commands.startEnd(the_Pinch_n_Twist::pinchRetract, the_Pinch_n_Twist::pinchExtend, the_Pinch_n_Twist));

    //driveController.leftBumper().onTrue(new JoystickControl(driveTrain, 
    //() -> .05, () -> 0));

    mechanismController.leftBumper().onTrue(new SpearManual(
     spearSubsytem , SpearConstants.kSpearRetract));


    mechanismController.rightBumper().onTrue(new SpearManual(
      spearSubsytem, SpearConstants.kSpearExtend));

      // Switch pipelines 
    driveController.leftTrigger().onTrue(new Pipeline0Command(limelightSubsystem));
    driveController.rightTrigger().onTrue(new Pipeline1Command(limelightSubsystem)); 

    // run AutoAlignCommand
    driveController.x().onTrue(new AutoAlignCommand(driveTrain, limelightSubsystem));

    //mechanismController.povDown().onTrue(new ElevatorPID(elevatorPID, ElevatorConstants.kElevatorFloor));
    //mechanismController.povRight().onTrue(new ElevatorPID(elevatorPID, ElevatorConstants.kElevatorMid));
    //mechanismController.povUp().onTrue(new ElevatorPID(elevatorPID, ElevatorConstants.kElevatorHigh));

    //mechanismController.x().onTrue(new ElevatorManual(elevatorPID, ElevatorConstants.kElevatorManualFoward));
    //mechanismController.b().onTrue(new ElevatorManual(elevatorPID, ElevatorConstants.kElevatorManualReverse));

      
   // mechanismController.pov(Constants.kDPadDown).onTrue(new ElevatorControl(elevatorPID, ElevatorConstants.kElevatorFloor));
   // mechanismController.pov(Constants.kDPadRight).onTrue(new ElevatorControl(elevatorPID, ElevatorConstants.kElevatorMid));
   // mechanismController.pov(Constants.kDPadUp).onTrue(new ElevatorControl(elevatorPID, ElevatorConstants.kElevatorHigh));


  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {

    //Currently blank command, replace or fill in auto1 for autonomous period
    return auto1;
  }
}