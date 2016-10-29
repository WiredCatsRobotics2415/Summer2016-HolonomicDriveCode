package org.usfirst.frc.team2415.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	//ROBOT DT SPECS
	public static final double DRIVETRAIN_WIDTH = 1;   //left to right
	public static final double DRIVETRAIN_LENGTH = 1;  //front to back
	public static final double[] TOP_LEFT_SWERVE_INFO = {1,1,1,1};  //driveport, angleport, xpos, ypos
	public static final double[] TOP_RIGHT_SWERVE_INFO = {2,2,2,2};
	public static final double[] BOTTOM_LEFT_SWERVE_INFO = {3,3,3,3};
	public static final double[] BOTTOM_RIGHT_SWERVE_INFO = {4,4,4,4};  //front to back
	
}
