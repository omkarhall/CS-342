
public class SUVBuilder extends CarBuilder{

	@Override
	public void buildSeats() {
		numSeats = 6;
	}

	@Override
	public void buildFrame() {
		frameSize = "Big frame";
	}

	@Override
	public void buildWheels() {
		wheelSize = 20;
	}

	@Override
	void buildEngine() {
		engineType = "V6";
	}

	
}
