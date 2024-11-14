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
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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

  //private boolean outreachMode = true;
  //private double limit = 0.4;

  public RobotContainer() {
    /*SmartDashboard.putBoolean("outreachMode", outreachMode);
    SmartDashboard.putNumber("Speed_Limit", limit);

    outreachMode = SmartDashboard.getBoolean("outreachMode", outreachMode);
    limit = SmartDashboard.getNumber("Speed_Limit", limit);*/

    drivetrainSubsystem.setDefaultCommand(Commands.run(
        () -> this.drivetrainSubsystem.arcadeDrive(driverLeftJoystick.getY(),driverLeftJoystick.getX()),
        this.drivetrainSubsystem));

    /*if(!outreachMode){
      //everything but drive taken out
      intakeSubsystem.setDefaultCommand(Commands.run(this.intakeSubsystem::stop, this.intakeSubsystem));
      flywheelSubsystem.setDefaultCommand(Commands.run(this.flywheelSubsystem::stop, this.flywheelSubsystem));
      climbSubsystem.setDefaultCommand(
          Commands.run(() -> this.climbSubsystem.set(this.operatorJoystick.getY()), this.climbSubsystem));
    }*/
    configureBindings();
  }

  private void configureBindings() {
    /* 
    SmartDashboard.putBoolean("outreachMode", true);
    SmartDashboard.putNumber("Speed_Limit", limit);
    if(!outreachMode){
      driverLeftJoystick.button(BUTTON_ID_TRIGGER)
          .whileTrue(Commands.run(this.intakeSubsystem::intake, this.intakeSubsystem));
      driverRightJoystick.button(BUTTON_ID_TRIGGER).whileTrue(Commands.run(() -> {
        this.flywheelSubsystem.spinUp((-this.driverRightJoystick.getThrottle() + 1.0) / 2.0);
        this.intakeSubsystem.shoot();
      }, this.flywheelSubsystem, this.intakeSubsystem));
    }
    */
  }
  /* 
  public Command getAutonomousCommand() {
    return Commands.run(() -> {
      this.flywheelSubsystem.spinUp(1.0);
      this.intakeSubsystem.shoot();
    }, this.flywheelSubsystem, this.intakeSubsystem).withTimeout(2).andThen(Commands.run(() -> drivetrainSubsystem.arcadeDrive(-0.25, 0, false), drivetrainSubsystem).withTimeout(3.0));
  
  }
  */
}
