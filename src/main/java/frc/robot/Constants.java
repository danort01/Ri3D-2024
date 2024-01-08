package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class Constants {
    
    public static final class DrivetrainConstants {

        public static final int DEVICE_ID_LEFT_LEADER = 5;
        public static final int DEVICE_ID_LEFT_FOLLOWER = 1;
        public static final int DEVICE_ID_RIGHT_LEADER = 10;
        public static final int DEVICE_ID_RIGHT_FOLLOWER = 3;

    }

    public static final class IntakeConstants {

        public static final int DEVICE_ID_INTAKE = 4;

        public static final double INTAKE_SPEED = 1.0;
        public static final double OUTPUT_SPEED = -1.0;

    }

    public static final class FlywheelConstants {

        public static final int DEVICE_ID_LEFT_FLYWHEEL = 7;
        public static final int DEVICE_ID_RIGHT_FLYWHEEL = 6;

        public static final double LEFT_SPEED = 1.0;
        public static final double RIGHT_SPEED = 1.0;

        public static final int FLYWHEEL_SPIN_UP = 2;
        //public static final  int FLYWHEEL_STOP = Joystick.ButtonType kTop;
    }

    public static class ControllerConstants {
        public static final int DEVICE_ID_DRIVER_CONTROLLER = 0;
        public static final int DEVICE_ID_OPERATOR_CONTROLLER = 1;
    }
    
}
