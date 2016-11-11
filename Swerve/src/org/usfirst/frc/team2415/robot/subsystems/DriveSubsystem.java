package org.usfirst.frc.team2415.robot.subsystems;

import org.usfirst.frc.team2415.robot.RobotMap;
import org.usfirst.frc.team2415.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
	
	public CANTalon W1, W2, W3;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	
	public DriveSubsystem(){
		
		W1 = new CANTalon(RobotMap.W1_PORT);
		W2 = new CANTalon(RobotMap.W2_PORT);
		W3 = new CANTalon(RobotMap.W3_PORT);
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveCommand());
    }
    
}

