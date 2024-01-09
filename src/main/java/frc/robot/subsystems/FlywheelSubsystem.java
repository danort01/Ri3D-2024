package frc.robot.subsystems;

import static frc.robot.Constants.FlywheelConstants.DEVICE_ID_LEFT_FLYWHEEL;
import static frc.robot.Constants.FlywheelConstants.DEVICE_ID_RIGHT_FLYWHEEL;
import static frc.robot.Constants.FlywheelConstants.LEFT_SPEED;
import static frc.robot.Constants.FlywheelConstants.RIGHT_SPEED;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FlywheelSubsystem extends SubsystemBase {

    private final CANSparkMax leftFlywheel = new CANSparkMax(DEVICE_ID_LEFT_FLYWHEEL, MotorType.kBrushless);
    private final CANSparkMax rightFlywheel = new CANSparkMax(DEVICE_ID_RIGHT_FLYWHEEL, MotorType.kBrushless);
    
    public FlywheelSubsystem() {
        this.leftFlywheel.restoreFactoryDefaults();
        this.rightFlywheel.restoreFactoryDefaults();

        this.leftFlywheel.setInverted(true);
        this.rightFlywheel.setInverted(false);

        this.leftFlywheel.setIdleMode(IdleMode.kCoast);
        this.rightFlywheel.setIdleMode(IdleMode.kCoast);
    }

    public void spinUp(double speed) {
        this.leftFlywheel.set(speed);
        this.rightFlywheel.set(speed);
    }

    public void stop() {
        this.leftFlywheel.set(0.0);
        this.rightFlywheel.set(0.0);
    }

}
