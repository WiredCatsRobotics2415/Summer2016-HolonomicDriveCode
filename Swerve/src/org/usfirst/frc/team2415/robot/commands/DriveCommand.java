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

		Robot.driveSubsystem.w1.set(0);
		Robot.driveSubsystem.w2.set(0);
		Robot.driveSubsystem.w3.set(0);

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
    	
		/*
		 * gets the target translational and rotational vectors
		 * from the controller. currently this only supports
		 * the krupczak controller
		 */
		
		/*TODO: Controller Toggle
		 * add a way to either distinguish between controllers
		 * or have some sort of variable that changes control
		 * schemes
		 */
    	double joyX, joyY, joyZ;
    	joyX = Robot.gamepad.getX();
    	joyY = Robot.gamepad.getY();
    	joyZ = Robot.gamepad.getZ();
    	
    	/*
    	 * basically all the kiwi math. simply put, it finds x
    	 * and y components for each wheel based off of the
    	 * translational and rotational vectors and adds them
    	 * all together #copypaste #thanks254
    	 */
    	double W1 = joyY * Math.cos(150) + joyX * Math.sin(150) + joyZ * RobotMap.W1_RADIUS;
    	double W2 = joyY * Math.cos(30) + joyX * Math.sin(30) + joyZ * RobotMap.W2_RADIUS;
    	double W3 = joyX * Math.sin(-90) + joyZ * RobotMap.W3_RADIUS;
    	
    	/*
    	 * normalizes velocities. basically if the code above
    	 * calculates speeds that are greater than one it'll
    	 * skew stuff and basically prevents the robot from
    	 * maintaining its translational vector while rotating.
    	 * this is to make that not happen.
    	 */
    	double max = Math.max(Math.abs(W1), Math.max(Math.abs(W2), Math.abs(W3)));
    	if(max > 1){
    		W1 /= max;
    		W2 /= max;
    		W3 /= max;
    	}
    	
    	Robot.driveSubsystem.w1.set(W1);	
    	Robot.driveSubsystem.w2.set(W2);	
    	Robot.driveSubsystem.w3.set(W3);
    	
    	
    }

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {

		Robot.driveSubsystem.w1.set(0);
		Robot.driveSubsystem.w2.set(0);
		Robot.driveSubsystem.w3.set(0);

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {

		Robot.driveSubsystem.w1.set(0);
		Robot.driveSubsystem.w2.set(0);
		Robot.driveSubsystem.w3.set(0);

	}
}
