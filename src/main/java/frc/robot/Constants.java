// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final int driveController_ID = 0;
    public static final int mechanismController_ID = 1;


    public static final int kDPadUp = 0;
    public static final int kDPadDown = 180;
    public static final int kDPadRight = 90;
    public static final int kDPadLeft = 270;

    public static final int kLeft_Y = 1;
    public static final int kLeft_X = 0;
    public static final int kRight_X = 4;
    public static final int kRight_Y = 5;
    public static final int kLeft_Trigger = 2;
    public static final int kRight_Trigger = 3;

    public static final int kA_Button = 1;
    public static final int kLeft_Bumper = 5;
    public static final int kRight_Bumper = 6;
    public static final int kTwoWindowsButton = 7;
    public static final int kDriverFieldOrientedButtonIdx = 8;
    public static final int kYbutton = 4;
    public static final int kB_Button = 2;
    public static final int kX_Button = 3;
    public static final double kDeadband = 0.05;

    public static final double kEncoderTick2Meter = 1 /2048.0 * 0.1 * Math.PI;



    public  final static class DriveConstants {
    public static final int kFLDriveID = 1;
    public static final int kFRDriveID = 2;
    public static final int kBLDriveID = 3;
    public static final int kBRDriveID = 4;


    }

    public final static class PinchNTwistConstants {
        public static final int kSolenoidFoward = 0;
        public static final int kSolenoidReverse = 1;
    }

    public final static class SpearConstants {
        public static final int kSpearDriveID = 16;
        public static final double kSpearExtend = .3;
        public static final double kSpearRetract = .3;
        
        public static final double kPSpear = .2;
        public static final double kISpear = .002;
        public static final double kDSpear = 2;

        public static final double kSpearRatio = 1/10;
    }

    public final static class ElevatorConstants {
        public static final int kLeftElevatorDriveID = 6;
        public static final int kRightElevatorDriveID = 9;

        //PID magic
        public static final double kEP = .5;
        public static final double kEI = .005;
        public static final double kED = 5;
        public static final double kElevatorRatio = 1 /10;


        //Motion magic
        public static final double kEVelo = 0.5;
        public static final double kEAccel = Math.sqrt(kEVelo);

        //Setpoints for elevator
        public static final double kElevatorFloor = 2;
        public static final double kElevatorMid = 5;
        public static final double kElevatorHigh = 8;

        public static final double kElevatorManualFoward = .3;
        public static final double kElevatorManualReverse = -.3;

        public static final double kEncoderTick2Meter = 1 /2048.0 * ElevatorConstants.kElevatorRatio * Math.PI;
    }

    public final static class ElevatorDropConstants {
        public static final int kElevatorDropID = 8;
        public static final double kEDropRatio = 1 / 262.5;

        public static final double kElevatorManualRaise = .2;
        public static final double kElevatorManualDrop = -.2;

        public static final double kDropLimitSwitch = 0;
    }

    public static final class AutoAlignConstants{ // TUNE
        public static final double rotateSpeed = 0.25;
        public static final double driveSpeed = 0.25;
    //  public static final double maxDriveSpeed = 0.30; // max speed will not surpass X% full speed

        public static final double minTargetArea = 0.25;
        public static final double maxTargetArea = 3; 


        public static final double cubeMinTargetArea = 0.5;
        public static final double cubeMaxTargetArea = 3;

        public static final double coneMinTargetArea = 2;
        public static final double coneMaxTargetArea = 12;
    }

    public static final class VisionConstants{
        public static final int Cube_Pipeline = 0; 
        public static final int Cone_Pipeline = 1;
        public static final int Default_Pipeline = 0;
    }

}