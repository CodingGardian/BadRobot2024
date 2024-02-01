// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

import java.util.function.DoubleSupplier;

/** An example command that uses an example subsystem. */
public class ShootCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ShooterSubsystem m_subsystem;

  private final double m_power;
  private DoubleSupplier m_powerSupplier;

  /**
   * Creates a new ShootCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ShootCommand(ShooterSubsystem subsystem, double power) {
    m_subsystem = subsystem;
    m_power = power;
    m_powerSupplier = new DoubleSupplier() {public double getAsDouble() {return m_power;}};
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  public ShootCommand(ShooterSubsystem subsystem, DoubleSupplier power) {
    m_subsystem = subsystem;
    m_powerSupplier = power;
    m_power = m_powerSupplier.getAsDouble();

    addRequirements(subsystem);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_subsystem.runShooter(m_powerSupplier.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.stopMotors(m_subsystem.m_leftMotor, m_subsystem.m_rightMotor);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
