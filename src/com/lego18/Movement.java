package com.lego18;

import lejos.nxt.Battery;
import lejos.nxt.Motor;
import lejos.nxt.MotorPort;

import com.lego18.MovementTypes;

/*
 * Class to abstract control of motor and make the code cleaner and easier to follow.
 */

public class Movement {
	public static void Move(MovementTypes type) {
		Movement.Move(type, Robot.SpeedNormal);
	}

	public static void Move(MovementTypes type, int Speed) {
		Speed = (int) Battery.getVoltage() * Speed;
		switch (type) {
			case STOP:
				MotorPort.A.controlMotor(Speed, MotorPort.STOP);
				MotorPort.C.controlMotor(Speed, MotorPort.STOP);
				MotorPort.B.controlMotor(Speed, MotorPort.STOP);
				break;
			case FORWARD:
				MotorPort.A.controlMotor(Speed, MotorPort.BACKWARD);
				MotorPort.C.controlMotor(Speed, MotorPort.BACKWARD);
				MotorPort.B.controlMotor(Speed, MotorPort.BACKWARD);
				break;
			case BACKWARD:
				MotorPort.A.controlMotor(Speed, MotorPort.FORWARD);
				MotorPort.C.controlMotor(Speed, MotorPort.FORWARD);
				MotorPort.B.controlMotor(Speed, MotorPort.FORWARD);
				break;
			case FORWARD_RIGHT:
				MotorPort.A.controlMotor((int) (Speed * 1.1), MotorPort.BACKWARD);
				MotorPort.C.controlMotor(Speed, MotorPort.BACKWARD);
				MotorPort.B.controlMotor(Speed, MotorPort.BACKWARD);
				break;
			case FORWARD_LEFT:
				MotorPort.A.controlMotor(Speed, MotorPort.BACKWARD);
				MotorPort.C.controlMotor((int) (Speed * 1.1), MotorPort.BACKWARD);
				MotorPort.B.controlMotor(Speed, MotorPort.BACKWARD);
				break;
			case BACKWARD_RIGHT:
				MotorPort.A.controlMotor((int) (Speed * 1.1), MotorPort.FORWARD);
				MotorPort.C.controlMotor(Speed, MotorPort.FORWARD);
				MotorPort.B.controlMotor(Speed, MotorPort.FORWARD);
				break;
			case BACKWARD_LEFT:
				MotorPort.A.controlMotor(Speed, MotorPort.FORWARD);
				MotorPort.C.controlMotor((int) (Speed * 1.1), MotorPort.FORWARD);
				MotorPort.B.controlMotor(Speed, MotorPort.FORWARD);
				break;
			case SPIN_LEFT:
				MotorPort.A.controlMotor(Speed, MotorPort.FORWARD);
				MotorPort.C.controlMotor(Speed, MotorPort.BACKWARD);
				MotorPort.B.controlMotor(Speed, MotorPort.STOP);
				break;
			case SPIN_RIGHT:
				MotorPort.A.controlMotor(Speed, MotorPort.BACKWARD);
				MotorPort.C.controlMotor(Speed, MotorPort.FORWARD);
				MotorPort.B.controlMotor(Speed, MotorPort.STOP);
				break;
			default:
				break;
		}
	}

	public static void SetSpeed(int Speed) {
		Motor.A.setSpeed(Speed);
		Motor.B.setSpeed(Speed);
		Motor.C.setSpeed(Speed);
	}

}
