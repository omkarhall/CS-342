import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MyMoneyTest {
	
	static MyMoney m1;
	static MyMoney m2;
	static MyMoney m3;
	static int iter;
	static int iter2;
	static int iter3;
	static int iter4;
	static double[] testInterest = {.055, .075, .045, .09, .10, .065, .035, .025};
	
	@BeforeAll
	static void setup() {
		iter = 0;
		iter2 = 0;
		iter3 = 0;
		iter4 = 0;
		m1 = new MyMoney("values.txt", 8, 1);
		m2 = new MyMoney("values2.txt", 8, 2);
		m3 = new MyMoney("values.txt", "values2.txt", 8, 8);
	}
	
	@ParameterizedTest
	@ValueSource(doubles = {4000, 5500, 15000, 18000, 24000, 9000, 11000, 12000})
	void constructorOneTest(double val) {
		assertEquals(m1.getCashValues()[iter], val, "Wrong values in cashValues");
		assertNull(m1.getInterestValues(), "interestValues should be null");
		iter++;
	}
	
	@Test
	void constructorOneTestTwo() {
		assertArrayEquals(testInterest, m2.getInterestValues(), "Wrong values in interestValues");
		assertNull(m2.getCashValues(), "cashValues should be null");
	}
	
	@ParameterizedTest
	@ValueSource(doubles = {4000, 5500, 15000, 18000, 24000, 9000, 11000, 12000})
	void constructorTwoTest(double val) {
		assertEquals(m3.getCashValues()[iter2], val, "Wrong values in cashValues");
		iter2++;
	}
	
	@Test
	void constructorTwoTestTwo() {
		assertArrayEquals(testInterest, m3.getInterestValues(), "Wrong values in interestValues");
	}
	
	@Test
	void lumpSum_ConstantRateTest() {
		assertEquals(5228, Math.round(m3.lumpSum_ConstantRate(m3.getCashValues()[0],
				m3.getInterestValues()[0], 5)), "wrong value");
	}
	
	@Test
	void lumpSum_ConstantRateTestTwo() {
		assertEquals(11336, Math.round(m3.lumpSum_ConstantRate(m3.getCashValues()[1],
				m3.getInterestValues()[1], 10)), "wrong value");
	}
	
	@Test
	void lumpSum_VariableRateTest() {
		assertEquals(6422, Math.round(m3.lumpSum_VariableRate(m3.getCashValues()[0])), 
				"wrong value");
	}
	
	@Test
	void lumpSum_VariableRateTestTwo() {
		assertEquals(38532, Math.round(m3.lumpSum_VariableRate(m3.getCashValues()[4])), 
				"wrong value");
	}
	
	@Test
	void compoundSavings_sameContributionTest() {
		assertEquals(107725, Math.round(m3.compoundSavings_sameContribution
				(m3.getCashValues()[3], m3.getInterestValues()[3], 5)), "wrong value");
	}
	
	@Test
	void compoundSavings_sameContributionTestTwo() {
		assertEquals(5526, Math.round(m3.compoundSavings_sameContribution(1000, 0.05, 5)), 
				"wrong value");
	}
	
	@Test
	void compoundSavings_variableContributionTest() {
		assertEquals(115278, Math.round(m3.compoundSavings_variableContribution(0.05)), 
				"wrong value");
	}
	
	@Test
	void compoundSavings_variableContributionTestTwo() {
		assertEquals(134984, Math.round(m3.compoundSavings_variableContribution(0.10)), 
				"wrong value");
	}
	
	@ParameterizedTest
	@ValueSource(doubles = {4000, 5500, 15000, 18000, 24000, 9000, 11000, 12000})
	void getCashValuesTest(double val) {
		assertEquals(m3.getCashValues()[iter3], val, "Wrong values in cashValues");
		iter3++;
	}
	
	@ParameterizedTest
	@ValueSource(doubles = {4000, 5500, 15000, 18000, 24000, 9000, 11000, 12000})
	void getCashValuesTestTwo(double val) {
		assertEquals(m1.getCashValues()[iter4], val, "Wrong values in cashValues");
		iter4++;
	}
	
	@Test
	void getInterestValuesTest() {
		assertArrayEquals(testInterest, m2.getInterestValues(), "Wrong values in interestValues");
	}
	
	@Test
	void getInterestValuesTestTwo() {
		assertArrayEquals(testInterest, m3.getInterestValues(), "Wrong values in interestValues");
	}
}
