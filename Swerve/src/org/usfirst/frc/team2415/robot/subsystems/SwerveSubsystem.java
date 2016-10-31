package org.usfirst.frc.team2415.robot.subsystems;

import org.usfirst.frc.team2415.robot.RobotMap;
import org.usfirst.frc.team2415.robot.commands.SwerveDriveCommand;
import org.usfirst.frc.team2415.utilities.WiredCatSwerveModule;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SwerveSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public WiredCatSwerveModule topLeft, topRight, bottomRight, bottomLeft;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new SwerveDriveCommand());
    	
    }
    
    public SwerveSubsystem(){
    	topLeft = new WiredCatSwerveModule(RobotMap.TOP_LEFT_SWERVE_INFO);
    	topRight = new WiredCatSwerveModule(RobotMap.TOP_RIGHT_SWERVE_INFO);
    	bottomLeft = new WiredCatSwerveModule(RobotMap.BOTTOM_LEFT_SWERVE_INFO);
    	bottomRight = new WiredCatSwerveModule(RobotMap.BOTTOM_RIGHT_SWERVE_INFO);
    }
    
    public void stop(){
    	topLeft.stop();
    	topRight.stop();
    	bottomLeft.stop();
    	bottomRight.stop();
    }
    
    public void set(WiredCatSwerveModule mod, double speed, double angle){
    	mod.set(speed, angle);
    }
    
    public void updateStatus(){
    	SmartDashboard.putNumber("Top Left Angle", topLeft.getAngleDegrees());
    	SmartDashboard.putNumber("Top Right Angle", topRight.getAngleDegrees());
    	SmartDashboard.putNumber("Bottom Left Angle", bottomLeft.getAngleDegrees());
    	SmartDashboard.putNumber("Bottom Right Angle", bottomRight.getAngleDegrees());
    }
}

