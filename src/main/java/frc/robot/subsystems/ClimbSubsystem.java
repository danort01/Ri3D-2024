package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimbSubsystem extends SubsystemBase {

    private final CANSparkMax winch = new CANSparkMax(Constants.ClimbConstants.DEVICE_ID_CLIMB, MotorType.kBrushless);

    public ClimbSubsystem() {
        this.winch.restoreFactoryDefaults();

        this.winch.setIdleMode(IdleMode.kBrake);
    }

    public void set(double speed) {
        this.winch.set(speed);
    }
    
}
