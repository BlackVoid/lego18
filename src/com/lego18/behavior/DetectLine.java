package com.lego18.behavior;

import com.lego18.Movement;
import com.lego18.MovementTypes;
import com.lego18.Utility;

import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Behavior;

public class DetectLine implements Behavior {

	private LightSensor lightSensor;
	private int lightBaseValue;
	private boolean suppressed = false;
	private long startT;

	public DetectLine(SensorPort port, boolean floodLight) {
		lightSensor = new LightSensor(port, floodLight);
		this.lightBaseValue = lightSensor.getNormalizedLightValue();
	}

	public boolean takeControl() {
		return !Utility.InInterval(lightSensor.getNormalizedLightValue(), this.lightBaseValue-140, this.lightBaseValue+140);
	}

	@Override
	public void action() {
		System.out.println("Line");
		suppressed = false;
		this.startT = System.currentTimeMillis();
		Movement.Move(MovementTypes.BACKWARD, 1000);
		
		while ((System.currentTimeMillis() - this.startT) < 1000 && !suppressed)
			Thread.yield();
		Movement.Move(MovementTypes.STOP);
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
