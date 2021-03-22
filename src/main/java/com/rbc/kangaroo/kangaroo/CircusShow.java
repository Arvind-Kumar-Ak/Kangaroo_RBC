package com.rbc.kangaroo.kangaroo;

public class CircusShow {

	private int positionOfKangarooOne;
	private int velocityOfKangarooOne;
	private int positionOfKangarooTwo;
	private int velocityOfKangarooTwo;

	public int getPositionOfKangarooOne() {
		return positionOfKangarooOne;
	}

	public void setPositionOfKangarooOne(int positionOfKangarooOne) {
		this.positionOfKangarooOne = positionOfKangarooOne;
	}

	public int getVelocityOfKangarooOne() {
		return velocityOfKangarooOne;
	}

	public void setVelocityOfKangarooOne(int velocityOfKangarooOne) {
		this.velocityOfKangarooOne = velocityOfKangarooOne;
	}

	public int getPositionOfKangarooTwo() {
		return positionOfKangarooTwo;
	}

	public void setPositionOfKangarooTwo(int positionOfKangarooTwo) {
		this.positionOfKangarooTwo = positionOfKangarooTwo;
	}

	public int getVelocityOfKangarooTwo() {
		return velocityOfKangarooTwo;
	}

	public void setVelocityOfKangarooTwo(int velocityOfKangarooTwo) {
		this.velocityOfKangarooTwo = velocityOfKangarooTwo;
	}

	
	
	@Override
	public String toString() {
		return "CircusShow [positionOfKangarooOne=" + positionOfKangarooOne + ", velocityOfKangarooOne="
				+ velocityOfKangarooOne + ", positionOfKangarooTwo=" + positionOfKangarooTwo
				+ ", velocityOfKangarooTwo=" + velocityOfKangarooTwo + "]";
	}

}

