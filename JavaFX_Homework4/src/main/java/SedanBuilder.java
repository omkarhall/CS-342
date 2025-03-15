
public class SedanBuilder extends CarBuilder{

	@Override
	public void buildSeats() {
		numSeats = 4;
	}

	@Override
	public void buildFrame() {
		frameSize = "Small frame";
	}

	@Override
	public void buildWheels() {
		wheelSize = 18;
	}

	@Override
	void buildEngine() {
		engineType = "V8";
	}
}
