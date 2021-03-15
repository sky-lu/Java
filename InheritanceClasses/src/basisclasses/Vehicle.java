package basisclasses;

public class Vehicle {
	private String name;
	private String bodyType;
	private int currentVelocity = 0;
	private int currentDirection = 0;
	
	//constructors
	public Vehicle() {
		this.name = "";
		this.bodyType = "";
		this.currentVelocity = 0;
		this.currentDirection = 0;
	}
	
	public Vehicle(String name, String bodyType) {
		this.name = name;
		this.bodyType = bodyType;
		
	}
	
   //methods to access to all attributes
	public String getName() {
		return name;
	}

	public String getBodyType() {
		return bodyType;
	}

	public int getCurrentVelocity() {
		return currentVelocity;
	}
	public int getCurrentDirection() {
		return currentDirection;
	}
	
	//steer method to change the current direction
	public void steer(int currentDirection) {
		this.currentDirection = currentDirection;
	}

    // move method to change direction and velocity
	public void move(int currentVelocity, int currentDirection) {
		this.currentVelocity = currentVelocity;
		this.currentDirection = currentDirection;
	}

	//stop method to break
	public void stop() {
		System.out.println("break");
	}
	

	
	
	
	
	
	
}
