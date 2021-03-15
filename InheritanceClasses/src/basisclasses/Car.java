package basisclasses;

public class Car extends Vehicle {
	private int wheels;
	private int door;
	private int gears;
	private Boolean isManual;
	private int currentGears;
	
	
	public Car() {
		this.currentGears = 1;
		
	}
	
	//Constructor with all attributes
	public Car(String name, String bodyType, int currentVelocity, int currentDirection, int wheels, int door, int gears, Boolean isManual, int currentGears) {
		super(name, bodyType);
		super.move(currentVelocity, currentDirection);
		this.wheels = wheels;
		this.door = door;
		this.gears = gears;
		this.isManual = isManual;
		this.currentGears = currentGears;
	}

	public int getWheels() {
		return wheels;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public int getDoor() {
		return door;
	}

	public void setDoor(int door) {
		this.door = door;
	}

	public int getGears() {
		return gears;
	}

	public void setGears(int gears) {
		this.gears = gears;
	}

	public Boolean getIsManual() {
		return isManual;
	}

	public void setIsManual(Boolean isManual) {
		this.isManual = isManual;
	}

	public int getCurrentGears() {
		return currentGears;
	}

	
	public void changeGrear(int currentGears) {
		this.currentGears = currentGears;
	}
	
	public void changeVelocity(int currentVelocity , int currentDirection) {
		super.move(currentVelocity, currentDirection);
	}
	

}
