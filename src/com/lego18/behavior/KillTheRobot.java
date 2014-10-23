package com.lego18.behavior;

import com.lego18.Movement;
import com.lego18.MovementTypes;

import lejos.nxt.Button;
import lejos.robotics.subsumption.*;

public class KillTheRobot implements Behavior {

	public boolean takeControl() {
		return Button.ESCAPE.isDown();
	}

	public void suppress() {
	}

	public void action() {
		System.out.println("KillTheRobot");
		Movement.Move(MovementTypes.STOP);
		System.exit(0);
	}
}