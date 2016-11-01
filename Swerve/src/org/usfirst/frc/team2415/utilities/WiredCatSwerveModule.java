package org.usfirst.frc.team2415.utilities;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;

public class WiredCatSwerveModule {
	
	private CANTalon angleTalon, driveTalon;
	double xPosition, yPosition;
	
	/**
	 * constructor for the Swerve Module
	 * 
	 * @param info [port of drive talon, port of angle talon, 
	 * 		  its x position relative to the center of the DT, 
	 * 		  its y position relative to the center of the DT ]
	 */
	public WiredCatSwerveModule(double[] info){
		driveTalon = new CANTalon((int)info[0]);
		angleTalon = new CANTalon((int)info[1]);
		angleTalon.changeControlMode(TalonControlMode.Position);
		angleTalon.set(0);
		angleTalon.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
		angleTalon.setPID(0.1, 0, 0);
		angleTalon.enable();
		xPosition = info[2];
		yPosition = info[3];
	}
	
	/**
	 * sets the velocity vector (magnitude and direction). 
	 * 
	 * @param speed value from [-1, 1]; relative speed of motor
	 * @param angle value ranging from [-180, 180]; angle of the wheel in degrees.
	 * 	      converts degrees to ticks
	 */
	public void set(double speed, double angle){
		driveTalon.set(speed);
		if (angle <= 180) angleTalon.set(angle*4096/360);
		else angleTalon.set(angle*4096/360 + 4096);
	}
	
	/**
	 * stops the drive talon from moving
	 */
	public void stop(){
		driveTalon.set(0);
	}
	
	/**
	 * 
	 * @return the angle of the wheel in degrees; range [-180, 180]
	 */
	public double getAngleDegrees(){
		return Math.abs((angleTalon.getPulseWidthPosition()*360/4096)) % 360 - 180;
	}
	
	/**
	 * 
	 * @return the velocity of the drive talon
	 */
	public double getVelocity(){
		return driveTalon.getEncVelocity();
	}
	
	/**
	 * zeroes the magnetic encoder
	 */
	public void zeroEncoder(){
		angleTalon.setPulseWidthPosition(0);
	}
	
	/**
	 * 
	 * @param setpoint the desired angle of the wheel
	 * @return the difference between the current position and the desired position
	 */
	public double error(double setpoint){
    	return setpoint - getAngleDegrees();
    }
	
	/**
	 * same as error function just normalizes the angle (spits out error for shortest path)
	 * @param setpoint the desired angle (in degrees) of the wheel
	 * @return the difference between the current position and the desired position via shortest path
	 */
	public double normalizedError(double setpoint){
    	double error = error(setpoint);
    	if(error > 180) return error -= 360;
    	else if(error < -180 ) return error += 360;
    	else return error;
    }

}
