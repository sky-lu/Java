// -----------------------------------------------------
// Assignment (2)
// © Honglin Lu
// Written by: (Honglin Lu 1930758)
// -----------------------------------------------------

package baseClasses;

public class Computer {
	
	//Attributes
	private String brand;
	private String model;
	private long SN;
	private double price;
	private static int numOfObj = 0;
	
	//Default constructor
	public Computer() {
		brand = "DELL";
		model = "Inspiron";
		SN = 1111111;
		price = 1000;
		numOfObj++;
	}
	
	//Fully Parameterized Constructor
	public Computer(String brand, String model, long sN, double price) {
		this.brand = brand;
		this.model = model;
		SN = sN;
		this.price = price;
		numOfObj++;
	}
	
	//Copy Constructor
	public Computer(Computer c) {
		brand = c.brand;
		model = c.model;
		SN = c.SN;
		price = c.price;
		numOfObj++;
	}

	// Getters and Setters
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public long getSN() {
		return SN;
	}

	public void setSN(long sN) {
		SN = sN;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	//To String
	@Override
	public String toString() {
		return "This computer's brand is " + brand + ", its model is " + model + ", its SN is " + SN + 
				", and its price is " + price;
	}
	
	
	public static int findNumberOfCreatedComputers() {
		return numOfObj;
	}

	//equals method
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj == null || this == null || this.getClass() != obj.getClass()) {
			return false;
		}else {
			Computer c = (Computer) obj;
			return (this.brand == c.brand && this.model == c.brand && this.price == this.price);
		}
	}
	
	
	
	
	
}
