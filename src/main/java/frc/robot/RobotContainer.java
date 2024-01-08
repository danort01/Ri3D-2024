// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.TeleopDriveCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.FlywheelSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import static frc.robot.Constants.ControllerConstants.DEVICE_ID_DRIVER_CONTROLLER;
import static frc.robot.Constants.ControllerConstants.DEVICE_ID_OPERATOR_CONTROLLER;
//import static frc.robot.Constants.FlywheelConstants.FLYWHEEL_SPIN_UP;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.Trigger;


public class RobotContainer {

  private final Joystick driverController = new Joystick(DEVICE_ID_DRIVER_CONTROLLER);
  private final Joystick operatorController = new Joystick(DEVICE_ID_OPERATOR_CONTROLLER);
  private final DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();
  private final FlywheelSubsystem flywheelSubsystem = new FlywheelSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

  public RobotContainer() {
    drivetrainSubsystem.setDefaultCommand(new TeleopDriveCommand(drivetrainSubsystem, driverController));

    configureBindings();
  }

  private void configureBindings() {
  /*new JoystickButton(operatorController, 2)
    .OnTrue(new InstantCommand(flywheelSubsystem::spinUp, flywheelSubsystem));*/
    /*new JoystickButton(operatorController, FLYWHEEL_STOP)
    .onTrue(new RunCommand(flywheelSubsystem::stop, flywheelSubsystem));*/
    //new JoystickButton(operatorController, 2).OnTrue(flywheelSubsystem.spinUp());
}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
