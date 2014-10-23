package com.lego18;

public class Utility {
	public static boolean InInterval(int value, int min, int max){
		return min < value && value < max;
	}
	
	public static void Sleep(int ms){
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void Sleep(long ms){
		Utility.Sleep((int) ms);
	}
}
