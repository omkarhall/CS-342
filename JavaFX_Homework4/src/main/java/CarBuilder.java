
public abstract class CarBuilder {
	int wheelSize;
	int numSeats;
	String frameSize;
	String engineType;

	abstract void buildSeats();
	abstract void buildFrame();
	abstract void buildWheels();
	abstract void buildEngine();
	
	final void buildCar() {
		buildSeats();
		buildFrame();
		buildWheels();
		buildEngine();
	}
}
