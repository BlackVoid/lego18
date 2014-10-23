package com.lego18.behavior;

import java.io.File;

import com.lego18.Movement;
import com.lego18.MovementTypes;
import com.lego18.Robot;

import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.*;

public class DetectEnemySound implements Behavior {
	private boolean suppressed = false;
	private UltrasonicSensor sonar;

	public DetectEnemySound(SensorPort usp) {
		sonar = new UltrasonicSensor(usp);
	}

	public boolean takeControl() {
		return sonar.getDistance() < 100;
	}

	public void suppress() {
		suppressed = true;
	}

	public void action() {
		System.out.println("EnemySound");
		suppressed = false;
		Movement.Move(MovementTypes.FORWARD, Robot.SpeedFast);
		while (sonar.getDistance() < 100 && !suppressed)
			Thread.yield();
		Movement.Move(MovementTypes.STOP, Robot.SpeedFast);
	}
}