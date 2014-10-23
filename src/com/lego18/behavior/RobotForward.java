package com.lego18.behavior;

import com.lego18.Movement;
import com.lego18.MovementTypes;

import lejos.robotics.subsumption.*;

public class RobotForward implements Behavior {
	private boolean suppressed = false;

	public boolean takeControl() {
		return true;
	}

	public void suppress() {
		suppressed = true;
	}

	public void action() {
		System.out.println("RobotForward");
		suppressed = false;
		Movement.Move(MovementTypes.FORWARD);
		while (!suppressed)
			Thread.yield();
		Movement.Move(MovementTypes.STOP);
	}
}