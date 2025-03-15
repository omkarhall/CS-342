import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MyTest {

	SedanBuilder sedan = new SedanBuilder();
	SUVBuilder suv = new SUVBuilder();
	
	@Test
	void testSedanBuildSeats() {
		sedan.buildSeats();
		assertEquals(4, sedan.numSeats, "wrong num of seats");
	}
	
	@Test
	void testSedanBuildFrame() {
		sedan.buildFrame();
		assertEquals("Small frame", sedan.frameSize, "wrong frame size");
	}
	
	@Test
	void testSedanBuildWheels() {
		sedan.buildWheels();
		assertEquals(18, sedan.wheelSize, "wrong wheel size");
	}
	
	@Test
	void testSedanEngineType() {
		sedan.buildEngine();
		assertEquals("V8", sedan.engineType, "wrong engine type");
	}
	
	@Test
	void testSedanBuildCar() {
		sedan.buildCar();
		assertEquals(4, sedan.numSeats, "wrong num of seats");
		assertEquals("Small frame", sedan.frameSize, "wrong frame size");
		assertEquals(18, sedan.wheelSize, "wrong wheel size");
	}
	
	@Test
	void testSUVBuildSeats() {
		suv.buildSeats();
		assertEquals(6, suv.numSeats, "wrong num of seats");
	}
	
	@Test
	void testSUVBuildFrame() {
		suv.buildFrame();
		assertEquals("Big frame", suv.frameSize, "wrong frame size");
	}
	
	@Test
	void testSUVBuildWheels() {
		suv.buildWheels();
		assertEquals(20, suv.wheelSize, "wrong wheel size");
	}
	
	@Test
	void testSUVEngineType() {
		suv.buildEngine();
		assertEquals("V6", suv.engineType, "wrong engine type");
	}
	
	@Test
	void testSUVBuildCar() {
		suv.buildCar();
		assertEquals(6, suv.numSeats, "wrong num of seats");
		assertEquals("Big frame", suv.frameSize, "wrong frame size");
		assertEquals(20, suv.wheelSize, "wrong wheel size");
	}

}
