package frc.robot.subsystems;

import static frc.robot.Constants.DrivetrainConstants.DEVICE_ID_LEFT_LEADER;
import static frc.robot.Constants.DrivetrainConstants.DEVICE_ID_LEFT_FOLLOWER;
import static frc.robot.Constants.DrivetrainConstants.DEVICE_ID_RIGHT_LEADER;
import static frc.robot.Constants.DrivetrainConstants.SPEED_LIMIT;
import static frc.robot.Constants.DrivetrainConstants.DEVICE_ID_RIGHT_FOLLOWER;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DrivetrainSubsystem extends SubsystemBase {

    private final DifferentialDrive differentialDrive;
    private double newSpeed;
    private double limit = 0.4;
    private boolean outreachMode = true;
    
    public DrivetrainSubsystem() {
        CANSparkMax leftLeader = new CANSparkMax(DEVICE_ID_LEFT_LEADER, MotorType.kBrushless);
        CANSparkMax leftFollower = new CANSparkMax(DEVICE_ID_LEFT_FOLLOWER, MotorType.kBrushless);
        CANSparkMax rightLeader = new CANSparkMax(DEVICE_ID_RIGHT_LEADER, MotorType.kBrushless);
        CANSparkMax rightFollower = new CANSparkMax(DEVICE_ID_RIGHT_FOLLOWER, MotorType.kBrushless);

        //caution: in future year migrate to elastic or a different software to Smartdashboard because of code crashes in this test version
        SmartDashboard.putBoolean("outreachMode", outreachMode);
        SmartDashboard.putNumber("Speed_Limit", limit);

        leftLeader.restoreFactoryDefaults();
        leftFollower.restoreFactoryDefaults();
        rightLeader.restoreFactoryDefaults();
        rightFollower.restoreFactoryDefaults();

        leftLeader.setIdleMode(IdleMode.kBrake);
        leftFollower.setIdleMode(IdleMode.kBrake);
        rightLeader.setIdleMode(IdleMode.kBrake);
        rightFollower.setIdleMode(IdleMode.kBrake);

        leftLeader.setInverted(true);
        leftFollower.setInverted(true);
        rightLeader.setInverted(false);
        rightFollower.setInverted(false);

        leftFollower.follow(leftLeader);
        rightFollower.follow(rightLeader);
        this.differentialDrive = new DifferentialDrive(leftLeader, rightLeader);
    }

    public void arcadeDrive(double speed, double rotation) {
        outreachMode = SmartDashboard.getBoolean("outreachMode", outreachMode);
        limit = SmartDashboard.getNumber("Speed_Limit", limit);
        if(outreachMode == true){
            newSpeed = speed*limit;
            rotation = 0;
        } else {
            newSpeed = speed*limit;
        }

        this.arcadeDrive(newSpeed, rotation, false);
    }

    public void arcadeDrive(double speed, double rotation, boolean squareInputs) {
        if(outreachMode == true){
            newSpeed = speed*limit;
            rotation = 0;
        } else {
            newSpeed = speed*limit;
        }
        this.differentialDrive.arcadeDrive(newSpeed, rotation, squareInputs);
    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        this.tankDrive(leftSpeed, rightSpeed, false);
    }

    public void tankDrive(double leftSpeed, double rightSpeed, boolean squareInputs) {
        this.differentialDrive.tankDrive(leftSpeed, rightSpeed, squareInputs);
    }

}
