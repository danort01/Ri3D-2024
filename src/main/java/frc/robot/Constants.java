package frc.robot;

public class Constants {
    
    public static final class DrivetrainConstants {

        public static final int DEVICE_ID_LEFT_LEADER = 2;
        public static final int DEVICE_ID_LEFT_FOLLOWER = 9;
        public static final int DEVICE_ID_RIGHT_LEADER = 3;
        public static final int DEVICE_ID_RIGHT_FOLLOWER = 4;
        public static final double SPEED_LIMIT = 0.4;//will be 0.5
    }

    public static final class IntakeConstants {

        public static final int DEVICE_ID_INTAKE_UPPER = 7;
        public static final int DEVICE_ID_INTAKE_LOWER = 0;

        public static final int CHANNEL_LIMIT_SWITCH = 0;

        public static final double INTAKE_SPEED = 1.0;
        public static final double SHOOT_SPEED = 1.0;

    }

    public static final class FlywheelConstants {

        public static final int DEVICE_ID_LEFT_FLYWHEEL = 10;
        public static final int DEVICE_ID_RIGHT_FLYWHEEL = 5;

        public static final double LEFT_SPEED = 1.0;
        public static final double RIGHT_SPEED = 1.0;

    }

    public static final class ClimbConstants {

        public static final int DEVICE_ID_CLIMB = 8;

    }

    public static final class ControlsConstants {

        public static final int PORT_NUMBER_DRIVER_LEFT_JOYSTICK = 0;
        public static final int PORT_NUMBER_DRIVER_RIGHT_JOYSTICK = 1;
        public static final int PORT_NUMBER_OPERATOR_JOYSTICK = 2;

        public static final int BUTTON_ID_TRIGGER = 1;

    }

}
