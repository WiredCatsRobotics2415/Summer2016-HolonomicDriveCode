package org.usfirst.frc.team2415.utilities;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;

public class WiredCatSwerveModule {
	
	private CANTalon angleTalon, driveTalon;
	double xPosition, yPosition;
	
	public WiredCatSwerveModule(double[] info){
		driveTalon = new CANTalon((int)info[0]);
		angleTalon = new CANTalon((int)info[1]);
		angleTalon.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
		angleTalon.setPID(0.1, 0, 0);
		angleTalon.changeControlMode(TalonControlMode.Position);
		xPosition = info[2];
		yPosition = info[3];
	}
	
	public void set(double speed, double angle){
		driveTalon.set(speed);
		angleTalon.set(angle*4096/360);
	}
	
	public void stop(){
		driveTalon.set(0);
	}
	
	public double getAngleDegrees(){
		return angleTalon.getPulseWidthPosition()*360/4096;
	}
	
	public double getVelocity(){
		return driveTalon.getEncVelocity();
	}
	
	public void zeroEncoder(){
		angleTalon.setPulseWidthPosition(0);
	}

}
