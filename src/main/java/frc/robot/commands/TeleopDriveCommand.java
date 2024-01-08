package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TeleopDriveCommand extends Command {
    private final double SPEED_FACTOR = 0.25;
    private final DrivetrainSubsystem drivetrainSubsystem;
    private final Joystick driverController;

    public TeleopDriveCommand(DrivetrainSubsystem drivetrainSubsystem, Joystick driverController) {
        this.drivetrainSubsystem = drivetrainSubsystem;
        this.driverController = driverController;
        SmartDashboard.putNumber("SPEED_FACTOR", SPEED_FACTOR);
        addRequirements(drivetrainSubsystem);
        
    }
    public void execute(){
        drivetrainSubsystem.arcadeDrive(driverController.getY()*SPEED_FACTOR, driverController.getX()*SPEED_FACTOR);
        SmartDashboard.putNumber("Y drive value", driverController.getY()*SPEED_FACTOR);
        SmartDashboard.putNumber("X drive value", driverController.getX()*SPEED_FACTOR);
    }
}
