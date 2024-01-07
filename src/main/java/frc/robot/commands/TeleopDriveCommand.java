package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DrivetrainSubsystem;

public class TeleopDriveCommand extends Command {
    
    private final DrivetrainSubsystem drivetrainSubsystem;
    private final DoubleSupplier speedSupplier;
    private final DoubleSupplier rotationSupplier;

    public TeleopDriveCommand(DrivetrainSubsystem drivetrainSubsystem, DoubleSupplier speedSupplier, DoubleSupplier rotationSupplier) {
        this.drivetrainSubsystem = drivetrainSubsystem;
        this.speedSupplier = speedSupplier;
        this.rotationSupplier = rotationSupplier;

        addRequirements(drivetrainSubsystem);
    }

    @Override
    public void execute() {
        this.drivetrainSubsystem.arcadeDrive(speedSupplier.getAsDouble(), rotationSupplier.getAsDouble(), true);
    }

}
