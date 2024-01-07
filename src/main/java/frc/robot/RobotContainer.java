// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static frc.robot.Constants.ControlsConstants.PORT_NUMBER_DRIVER_LEFT_JOYSTICK;
import static frc.robot.Constants.ControlsConstants.PORT_NUMBER_DRIVER_RIGHT_JOYSTICK;
import static frc.robot.Constants.ControlsConstants.PORT_NUMBER_OPERATOR_JOYSTICK;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import frc.robot.commands.TeleopDriveCommand;
import frc.robot.subsystems.DrivetrainSubsystem;

public class RobotContainer {
  private final DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();

  private final CommandJoystick driverLeftJoystick = new CommandJoystick(PORT_NUMBER_DRIVER_LEFT_JOYSTICK);
  private final CommandJoystick driverRightJoystick = new CommandJoystick(PORT_NUMBER_DRIVER_RIGHT_JOYSTICK);
  private final CommandJoystick operatorJoystick = new CommandJoystick(PORT_NUMBER_OPERATOR_JOYSTICK);

  public RobotContainer() {
    drivetrainSubsystem.setDefaultCommand(new TeleopDriveCommand(drivetrainSubsystem, driverLeftJoystick::getY, driverRightJoystick::getX));

    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
