package com.lego18;

import java.io.File;

import com.lego18.behavior.DetectEnemySound;
import com.lego18.behavior.DetectLine;
import com.lego18.behavior.KillTheRobot;
import com.lego18.behavior.KillTheRobotLost;
import com.lego18.behavior.KillTheRobotWin;
import com.lego18.behavior.SpinRobot;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Robot {
	public static int SpeedSlow = 60;
	public static int SpeedNormal = 80;
	public static int SpeedFast = 90; //90 = max
	
	public static final SensorPort UltraSoundSensor = SensorPort.S1;
	public static final SensorPort LightSensorPort = SensorPort.S2;
	public static final SensorPort FrontButtonPort = SensorPort.S3;
	public static final SensorPort BackButtonPort = SensorPort.S4;
	
	public static boolean Initialized = false;
	public static boolean turnRight = false;

	
	public static void main(String[] args) {
		//Add button listeners to determine which direction the robot should turn.
		Button.LEFT.addButtonListener(new ButtonListener() {
			public void buttonPressed(Button b) {
				Robot.Initialized = true;
				turnRight = false;
				
			}
			public void buttonReleased(Button b) {
				// TODO Auto-generated method stub
			}
		});
		Button.RIGHT.addButtonListener(new ButtonListener() {
			public void buttonPressed(Button b) {
				Robot.Initialized = true;
				turnRight = true;
			}
			public void buttonReleased(Button b) {
				// TODO Auto-generated method stub
			}
		});
		//Do nothing until direction is set.
		while(Robot.Initialized == false){}
		
		//Store when robot should start
		long startAt = System.currentTimeMillis()+5000;
		//Start floodlight, so it gives correct values when classes using it are initialized.
		(new LightSensor(LightSensorPort)).setFloodlight(true);
		//Sleep and wait for floodlight to turn on.
		Utility.Sleep(2000);
		
		//Initialize all behaviors.
		Behavior SpinRobotBehavior = new SpinRobot();
		Behavior DetectEnemySoundBehavior = new DetectEnemySound(UltraSoundSensor);
		Behavior DetectLineBehavior = new DetectLine(LightSensorPort, true);
		Behavior KillTheRobotBehavior = new KillTheRobot();
		
		//Add behaviors to array by priority (lower index = lower priority)
		Behavior [] bArray = {
				SpinRobotBehavior,
				DetectEnemySoundBehavior,
				DetectLineBehavior,
				KillTheRobotBehavior,
				};
		Arbitrator arby = new Arbitrator(bArray);
		
		//Sleep the time remaining
		Utility.Sleep(startAt-System.currentTimeMillis()-1000);
		
		//Start arbitrator
		arby.start();
	}
}
