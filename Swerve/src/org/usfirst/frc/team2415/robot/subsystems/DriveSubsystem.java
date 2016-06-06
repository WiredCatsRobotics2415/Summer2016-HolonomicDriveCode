package org.usfirst.frc.team2415.robot.subsystems;

import org.usfirst.frc.team2415.robot.RobotMap;
import org.usfirst.frc.team2415.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private CANTalon[] swerveTR, swerveTL, swerveBR, swerveBL;
	
	public DriveSubsystem(){
		swerveTR = new CANTalon[]{new CANTalon(RobotMap.SWERVE_TR[0]),
				  				  new CANTalon(RobotMap.SWERVE_TR[1])};
		swerveTL = new CANTalon[]{new CANTalon(RobotMap.SWERVE_TL[0]),
				  				  new CANTalon(RobotMap.SWERVE_TL[1])};
		swerveBR = new CANTalon[]{new CANTalon(RobotMap.SWERVE_BR[0]),
				  				  new CANTalon(RobotMap.SWERVE_BR[1])};
		swerveBL = new CANTalon[]{new CANTalon(RobotMap.SWERVE_BL[0]),
				  				  new CANTalon(RobotMap.SWERVE_BL[1])};
		
		//set the mode of the rotation talons 
		//you should probably PID that idk
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveCommand());
    }
    
    public void setMotor(CANTalon[] swerveModule){
    	
    }
    
}

