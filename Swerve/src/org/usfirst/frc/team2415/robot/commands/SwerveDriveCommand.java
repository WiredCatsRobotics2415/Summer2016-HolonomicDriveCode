package org.usfirst.frc.team2415.robot.commands;

import org.usfirst.frc.team2415.robot.Robot;
import org.usfirst.frc.team2415.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SwerveDriveCommand extends Command {
	
	double L = RobotMap.DRIVETRAIN_LENGTH;
	double W = RobotMap.DRIVETRAIN_WIDTH;
	double R = Math.sqrt(L*L+W*W);

    public SwerveDriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.swerveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.swerveSubsystem.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double FWD = Robot.gamepad.rightY(); //forward direction
    	double STR = Robot.gamepad.rightX(); //strafe right direction
    	double RCW = Robot.gamepad.yaw();    //rotation clockwise
    	 
    	
    	double A = STR - RCW*(L/R);
    	double B = STR + RCW*(L/R);
        double C = FWD - RCW*(W/R);
        double D = FWD + RCW*(W/R);
        
        double ws1 = Math.sqrt(B*B+C*C);
        double ws2 = Math.sqrt(B*B+D*D);
        double ws3 = Math.sqrt(A*A+D*D);
        double ws4 = Math.sqrt(A*A+C*C);

        double wa1 = Math.atan2(B, C)*180/Math.PI;
        double wa2 = Math.atan2(B, D)*180/Math.PI;
        double wa3 = Math.atan2(A, D)*180/Math.PI;
        double wa4 = Math.atan2(A, C)*180/Math.PI;
        
        //normalizes speeds
        double max=ws1; 
        if(ws2>max)max=ws2; 
        if(ws3>max)max=ws3; 
        if(ws4>max)max=ws4; 
        if(max>1){
        	ws1/=max; 
        	ws2/=max; 
        	ws3/=max; 
        	ws4/=max;
        }
        
        Robot.swerveSubsystem.set(Robot.swerveSubsystem.topRight, ws1, wa1);
        Robot.swerveSubsystem.set(Robot.swerveSubsystem.topLeft, ws2, wa2);
        Robot.swerveSubsystem.set(Robot.swerveSubsystem.bottomRight, ws3, wa3);
        Robot.swerveSubsystem.set(Robot.swerveSubsystem.bottomLeft, ws4, wa4);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
