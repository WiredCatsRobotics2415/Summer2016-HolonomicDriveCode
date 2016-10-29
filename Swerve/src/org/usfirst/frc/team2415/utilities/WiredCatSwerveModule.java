package org.usfirst.frc.team2415.utilities;

import edu.wpi.first.wpilibj.CANTalon;

public class WiredCatSwerveModule {
	
	CANTalon angleTalon, driveTalon;
	double xPosition, yPosition;
	
	public WiredCatSwerveModule(double[] info){
		driveTalon = new CANTalon((int)info[0]);
		angleTalon = new CANTalon((int)info[1]);
		xPosition = info[2];
		yPosition = info[3];
	}
	
	public void set(double speed, double angle){
		driveTalon.set(speed);
		angleTalon.set(angle);
	}
	
	public void stop(){
		driveTalon.set(0);
	}

}
