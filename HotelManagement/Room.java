class Room {
	private int roomNumber;
	private boolean isOccupied;
	private double rate;

	public Room(int roomNumber, double rate) {
		this.roomNumber = roomNumber;
		this.isOccupied = false;
		this.rate = rate;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void occupyRoom() {
		isOccupied = true;
	}

	public void vacateRoom() {
		isOccupied = false;
	}

	public double getRate() {
		return rate;
	}

}
