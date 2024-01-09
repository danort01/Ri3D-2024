package frc.robot.subsystems;

import static frc.robot.Constants.IntakeConstants.DEVICE_ID_INTAKE_LOWER;
import static frc.robot.Constants.IntakeConstants.DEVICE_ID_INTAKE_UPPER;
import static frc.robot.Constants.IntakeConstants.CHANNEL_LIMIT_SWITCH;
import static frc.robot.Constants.IntakeConstants.INTAKE_SPEED;
import static frc.robot.Constants.IntakeConstants.SHOOT_SPEED;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

    private final CANSparkMax intakeUpper = new CANSparkMax(DEVICE_ID_INTAKE_UPPER, MotorType.kBrushless);
    private final WPI_TalonSRX intakeLower = new WPI_TalonSRX(DEVICE_ID_INTAKE_LOWER);
    private final DigitalInput limitSwitch = new DigitalInput(CHANNEL_LIMIT_SWITCH);

    public IntakeSubsystem() {
        this.intakeLower.configFactoryDefault();
        this.intakeUpper.restoreFactoryDefaults();

        this.intakeLower.setNeutralMode(NeutralMode.Brake);
        this.intakeUpper.setIdleMode(IdleMode.kBrake);

        this.intakeLower.setInverted(true);
    }

    private void set(double speed) {
        this.intakeUpper.set(speed);
        this.intakeLower.set(speed);
    }

    public void intake() {
        if (!limitSwitch.get()) {
            this.set(INTAKE_SPEED);
        } else {
            this.stop();
        }
    }

    public void shoot() {
        this.set(SHOOT_SPEED);
    }

    public void stop() {
        this.set(0.0);
    }

}
