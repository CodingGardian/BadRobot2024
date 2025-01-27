// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import com.revrobotics.CANSparkBase.IdleMode;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.XboxController.Button;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final class DriveConstants {
    // Driving Parameters - Note that these are not the maximum capable speeds of
    // the robot, rather the allowed maximum speeds
    public static final boolean kFieldOriented = true;
    public static final double kXSlewRateLimit = 2.2;
    public static final double kYSlewRateLimit = 2.2;
    public static final double kTurnSlewRateLimit = 2.2;
    public static final double kTeleMaxMetersPerSec = 10;
    

    public static final double kJoystickDeadzone = 0.1;
    public static final Button kLockAngleButton = Button.kX;
    public static final Button kTestMotorButton = Button.kLeftBumper;

    public static final double kMaxSpeedMetersPerSecond = 3.8;
    public static final double kMaxAngularSpeed = 1 * Math.PI; // radians per second

    public static final double kDirectionSlewRate = 1.2; // radians per second
    public static final double kMagnitudeSlewRate = 1.8; // percent per second (1 = 100%)
    public static final double kRotationalSlewRate = 100; // percent per second (1 = 100%)

    // Chassis configuration
    public static final double kTrackWidth = Units.inchesToMeters(24.75);
    // Distance between centers of right and left wheels on robot
    public static final double kWheelBase = Units.inchesToMeters(24.75);
    // Distance between front and back wheels on robot
    public static final SwerveDriveKinematics kDriveKinematics = new SwerveDriveKinematics(
        new Translation2d(kWheelBase / 2, kTrackWidth / 2),
        new Translation2d(kWheelBase / 2, -kTrackWidth / 2),
        new Translation2d(-kWheelBase / 2, kTrackWidth / 2),
        new Translation2d(-kWheelBase / 2, -kTrackWidth / 2));

    // Angular offsets of the modules relative to the chassis in radians
    public static final double kFrontLeftChassisAngularOffset = -Math.PI / 4;
    public static final double kFrontRightChassisAngularOffset = Math.PI / 4;
    public static final double kBackLeftChassisAngularOffset = 3 * Math.PI / 4;
    public static final double kBackRightChassisAngularOffset = -3 * Math.PI / 4;

    // SPARK MAX CAN IDs
    public static final int kFrontRightDrivingCanId = 11;
    public static final int kRearRightDrivingCanId = 21;
    public static final int kRearLeftDrivingCanId = 31;
    public static final int kFrontLeftDrivingCanId = 41;

    public static final int kFrontRightTurningCanId = 12;
    public static final int kRearRightTurningCanId = 22;
    public static final int kRearLeftTurningCanId = 32;
    public static final int kFrontLeftTurningCanId = 42;

    public static final int kFrontRightEncoderCanId = 13;
    public static final int kRearRightEncoderCanId = 23;
    public static final int kRearLeftEncoderCanId = 33;
    public static final int kFrontLeftEncoderCanId = 43;

    public static final boolean kGyroReversed = false;

    public static final double kPXYController = 0.077777;//need to change for comp bot
    public static final double kPThetaController = 0.77777;
    public static final boolean kBackRightAbsoluteEncoderReversed = false;
    public static final boolean kBackRightTurningEncoderReversed = false;
    public static final boolean kBackRightDriveEncoderReversed = false;
    public static final boolean kBackLeftDriveEncoderReversed = false;
    public static final boolean kBackLeftTurningEncoderReversed = false;
    public static final boolean kBackLeftAbsoluteEncoderReversed = false;
    public static final boolean kFrontRightAbsoluteEncoderReversed = true;
    public static final boolean kFrontRightTurningEncoderReversed = true;
    public static final boolean kFrontRightDriveEncoderReversed = true;
    public static final boolean kFrontLeftDriveEncoderReversed = true;
    public static final boolean kFrontLeftTurningEncoderReversed = true;
    public static final boolean kFrontLeftAbsoluteEncoderReversed = true;
    public static final long kBootupDelay = 1000;
    public static final double kTeleMaxRadiansPerSec = 40.0;
  }

  public static final class CLimberConstants {
    public static final double NavXClimberDeadzone = 5;
    public static final double ClimbSpeed = .5;
  }

  public static final class ModuleConstants {
    // Invert the turning encoder, since the output shaft rotates in the opposite direction of
    // the steering motor in the MAXSwerve Module.
    public static final boolean kTurningEncoderInverted = true;

    // Calculations required for driving motor conversion factors and feed forward
    public static final double kDrivingMotorFreeSpeedRps = NeoMotorConstants.kFreeSpeedRpm / 60;
    public static final double kWheelDiameterMeters = 0.0762;
    public static final double kWheelCircumferenceMeters = kWheelDiameterMeters * Math.PI;
    // 45 teeth on the wheel's bevel gear, 22 teeth on the first-stage spur gear, 15 teeth on the bevel pinion
    public static final double kDrivingMotorReduction = 8.14;
    public static final double kDriveWheelFreeSpeedRps = (kDrivingMotorFreeSpeedRps * kWheelCircumferenceMeters)
        / kDrivingMotorReduction;

    public static final double kDrivingEncoderPositionFactor = (kWheelDiameterMeters * Math.PI)
        / kDrivingMotorReduction; // meters
    public static final double kDrivingEncoderVelocityFactor = ((kWheelDiameterMeters * Math.PI)
        / kDrivingMotorReduction) / 60.0; // meters per second

    public static final double kTurningEncoderPositionFactor = (300 * Math.PI) / 7; // radians
    public static final double kTurningEncoderVelocityFactor = (300 * Math.PI) / 420; // radians per second

    public static final double kTurningEncoderPositionPIDMinInput = 0; // radians
    public static final double kTurningEncoderPositionPIDMaxInput = kTurningEncoderPositionFactor; // radians

    public static final double kDrivingP = 0.04;
    public static final double kDrivingI = 0;
    public static final double kDrivingD = 0;
    public static final double kDrivingFF = 1 / kDriveWheelFreeSpeedRps;
    public static final double kDrivingMinOutput = -1;
    public static final double kDrivingMaxOutput = 1;

    public static final double kTurningP = 0.005;
    public static final double kTurningI = 0;
    public static final double kTurningD = 0;
    public static final double kTurningFF = 1 / kDriveWheelFreeSpeedRps;
    public static final double kTurningMinOutput = -1;
    public static final double kTurningMaxOutput = 1;

    public static final IdleMode kDrivingMotorIdleMode = IdleMode.kBrake;
    public static final IdleMode kTurningMotorIdleMode = IdleMode.kBrake;

    public static final int kDrivingMotorCurrentLimit = 50; // amps
    public static final int kTurningMotorCurrentLimit = 20; // amps

    public static final double kDriveEncoderRot2Meter = 0;

    public static final double kDriveEncoderRPM2MeterPerSec = 0;

    public static final double kTurningEncoderRot2Rad = 0;

    public static final double kTurningEncoderRPM2RadPerSec = 0;

    public static final double kModuleDeadband = 0;
  }

  public static final class OIConstants {
    public static final int kDriverControllerPort = 0;
    public static final double kDriveDeadband = 0.05;
  }

  public static final class AutoConstants {
    public static final double kMaxSpeedMetersPerSecond = 3;
    public static final double kMaxAccelerationMetersPerSecondSquared = 3;
    public static final double kMaxAngularSpeedRadiansPerSecond = Math.PI;
    public static final double kMaxAngularSpeedRadiansPerSecondSquared = Math.PI;

    public static final double kPXController = 1;
    public static final double kPYController = 1;
    public static final double kPThetaController = 1;

    // Constraint for the motion profiled robot angle controller
    public static final TrapezoidProfile.Constraints kThetaControllerConstraints = new TrapezoidProfile.Constraints(
        kMaxAngularSpeedRadiansPerSecond, kMaxAngularSpeedRadiansPerSecondSquared);
  }

  public static final class NeoMotorConstants {
    public static final double kFreeSpeedRpm = 5676;
  }
}