package org.usfirst.frc.team2415.robot.commands;

import org.usfirst.frc.team2415.robot.Robot;
import org.usfirst.frc.team2415.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveCommand extends Command {

	public DriveCommand() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);

		requires(Robot.driveSubsystem);

	}

	// Called just before this Command runs the first time
	protected void initialize() {

		Robot.driveSubsystem.W1.set(0);
		Robot.driveSubsystem.W2.set(0);
		Robot.driveSubsystem.W3.set(0);

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
    	
    	double joyX, joyY, joyZ;
    	joyX = Robot.gamepad.getX();
    	joyY = Robot.gamepad.getY();
    	joyZ = Robot.gamepad.getZ();
    	
    	double W1 = joyY * Math.cos(150) + joyX * Math.sin(150) + joyZ * RobotMap.DRIVE_RADIUS;
    	double W2 = joyY * Math.cos(30) + joyX * Math.sin(30) + joyZ * RobotMap.DRIVE_RADIUS;
    	double W3 = joyX * Math.sin(-90) + joyZ * RobotMap.DRIVE_RADIUS;
    	
    	Robot.driveSubsystem.W1.set(W1);	
    	Robot.driveSubsystem.W2.set(W2);	
    	Robot.driveSubsystem.W3.set(W3);
    	
    	
    }

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {

		Robot.driveSubsystem.W1.set(0);
		Robot.driveSubsystem.W2.set(0);
		Robot.driveSubsystem.W3.set(0);

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {

		Robot.driveSubsystem.W1.set(0);
		Robot.driveSubsystem.W2.set(0);
		Robot.driveSubsystem.W3.set(0);

	}
}
