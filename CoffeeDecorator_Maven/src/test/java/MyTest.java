import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MyTest {

	@Test
	void basicCoffeeTest() {
		Coffee c1 = new BasicCoffee();
		assertEquals(3.99, c1.makeCoffee());
	}
	
	@Test
	void basicCoffeeTest2() {
		Coffee c1 = new BasicCoffee();
		assertEquals("Black Coffee: $3.99", c1.makeCoffeeString());
	}
	
	@Test
	void creamTest1() {
		Coffee c1 = new Cream(new ExtraShot(new BasicCoffee()));
		assertEquals(5.69, c1.makeCoffee());
	}
	
	@Test
	void creamTest2() {
		Coffee c1 = new Cream(new ExtraShot(new BasicCoffee()));
		assertEquals("Black Coffee: $3.99\n"
				+ " + extra shot: $1.20\n"
				+ " + cream: $.50", c1.makeCoffeeString());
	}
	
	@Test
	void biscottiTest1() {
		Coffee c1 = new Biscotti(new Cream(new ExtraShot(new BasicCoffee())));
		assertEquals(6.19, c1.makeCoffee());
	}
	
	@Test
	void biscottiTest2() {
		Coffee c1 = new Biscotti(new Cream(new ExtraShot(new BasicCoffee())));
		assertEquals("Black Coffee: $3.99\n"
				+ " + extra shot: $1.20\n"
				+ " + cream: $.50\n"
				+ " + biscotti: $.50", c1.makeCoffeeString());
	}
	
	@Test
	void extraShotTest1() {
		Coffee c1 = new ExtraShot(new Sugar(new Cream(new Biscotti(new BasicCoffee()))));
		assertEquals(6.69, c1.makeCoffee());
	}
	
	@Test
	void extraShotTest2() {
		Coffee c1 = new ExtraShot(new Sugar(new Cream(new Biscotti(new BasicCoffee()))));
		assertEquals("Black Coffee: $3.99\n"
				+ " + biscotti: $.50\n"
				+ " + cream: $.50\n"
				+ " + sugar: $.50\n"
				+ " + extra shot: $1.20", c1.makeCoffeeString());
	}
	
	@Test
	void allTest1() {
		Coffee c1 = new Cinnamon(new ExtraShot(new Sugar(new Cream(new Biscotti(new BasicCoffee())))));
		assertEquals(6.79, c1.makeCoffee());
	}
	
	@Test
	void allTest2() {
		Coffee c1 = new Cinnamon(new ExtraShot(new Sugar(new Cream(new Biscotti(new BasicCoffee())))));
		assertEquals("Black Coffee: $3.99\n"
				+ " + biscotti: $.50\n"
				+ " + cream: $.50\n"
				+ " + sugar: $.50\n"
				+ " + extra shot: $1.20\n"
				+ " + cinnamon: $.10", c1.makeCoffeeString());
	}
}
