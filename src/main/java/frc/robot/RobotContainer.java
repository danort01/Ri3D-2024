// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static frc.robot.Constants.ControlsConstants.BUTTON_ID_TRIGGER;
import static frc.robot.Constants.ControlsConstants.PORT_NUMBER_DRIVER_LEFT_JOYSTICK;
import static frc.robot.Constants.ControlsConstants.PORT_NUMBER_DRIVER_RIGHT_JOYSTICK;
import static frc.robot.Constants.ControlsConstants.PORT_NUMBER_OPERATOR_JOYSTICK;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.FlywheelSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class RobotContainer {
  private final DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final FlywheelSubsystem flywheelSubsystem = new FlywheelSubsystem();
  private final ClimbSubsystem climbSubsystem = new ClimbSubsystem();

  private final CommandJoystick driverLeftJoystick = new CommandJoystick(PORT_NUMBER_DRIVER_LEFT_JOYSTICK);
  private final CommandJoystick driverRightJoystick = new CommandJoystick(PORT_NUMBER_DRIVER_RIGHT_JOYSTICK);
  private final CommandJoystick operatorJoystick = new CommandJoystick(PORT_NUMBER_OPERATOR_JOYSTICK);

  public RobotContainer() {
    drivetrainSubsystem.setDefaultCommand(new RunCommand(() -> this.drivetrainSubsystem.arcadeDrive(driverLeftJoystick.getY(), driverRightJoystick.getX(), true), this.drivetrainSubsystem));
    intakeSubsystem.setDefaultCommand(new RunCommand(this.intakeSubsystem::stop, this.intakeSubsystem));
    flywheelSubsystem.setDefaultCommand(new RunCommand(this.flywheelSubsystem::stop, this.flywheelSubsystem));
    climbSubsystem.setDefaultCommand(
        new RunCommand(() -> this.climbSubsystem.set(this.operatorJoystick.getY()), this.climbSubsystem));

    configureBindings();
  }

  private void configureBindings() {
    driverLeftJoystick.button(BUTTON_ID_TRIGGER)
        .whileTrue(new RunCommand(this.intakeSubsystem::intake, this.intakeSubsystem));
    driverRightJoystick.button(BUTTON_ID_TRIGGER).whileTrue(new RunCommand(() -> {
      this.flywheelSubsystem.spinUp();
      this.intakeSubsystem.shoot();
    }, this.flywheelSubsystem, this.intakeSubsystem));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
