package com.lego18.behavior;

import com.lego18.Movement;
import com.lego18.MovementTypes;
import com.lego18.Robot;

import lejos.robotics.subsumption.*;

public class SpinRobot implements Behavior {
	private boolean suppressed = false;

	public boolean takeControl() {
		return true;
	}

	public void suppress() {
		suppressed = true;
	}

	public void action() {
		System.out.println("SpinRobot");
		suppressed = false;
		Movement.Move(Robot.turnRight ? MovementTypes.SPIN_RIGHT : MovementTypes.SPIN_LEFT, Robot.SpeedSlow);
		while (!suppressed)
			Thread.yield();
		Movement.Move(MovementTypes.STOP);
	}
}