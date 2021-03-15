package basisclasses;

public class Outlander extends Car {
	private int roadServiceMonth;
	
	public Outlander(int roadServiceMonth) {
		this.roadServiceMonth = roadServiceMonth;
	}

	public int getRoadServiceMonth() {
		return roadServiceMonth;
	}

	public void setRoadServiceMonth(int roadServiceMonth) {
		this.roadServiceMonth = roadServiceMonth;
	}
	
	public void accelerate(float speed) {
		if(speed == 0) {
			System.out.println("stop");
		}else if(speed >= 1 && speed <= 20) {
			super.setGears(1);
		}else if(speed >= 21 && speed <= 30) {
			super.setGears(2);
		}else if(speed >= 31 && speed <= 50) {
			super.setGears(3);
		}else if(speed > 50) {
			super.setGears(4);
		}
	}

}
