import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SavingsMethodTest {
	static MyMoney s1;
	
	@BeforeAll
	static void setup() {
		s1 = new MyMoney("values.txt", "values2.txt", 8, 8);
	}

	@Test
	void futureValueLumpSumTest() {
		assertEquals(5228, Math.round(SavingsFormulas.futureValueLumpSum(s1.getCashValues()[0],
				s1.getInterestValues()[0], 5)), "wrong value");
	}
	
	@Test
	void futureValueLumpSumTestTwo() {
		assertEquals(11336, Math.round(SavingsFormulas.futureValueLumpSum(s1.getCashValues()[1],
				s1.getInterestValues()[1], 10)), "wrong value");
	}
	
	@Test
	void futureValueLS_VariableInterestTest() {
		assertEquals(6422, Math.round(SavingsFormulas.futureValueLS_VariableInterest
				(s1.getCashValues()[0], s1.getInterestValues())), "wrong value");
	}
	
	@Test
	void futureValueLS_VariableInterestTestTwo() {
		assertEquals(38532, Math.round(SavingsFormulas.futureValueLS_VariableInterest
				(s1.getCashValues()[4], s1.getInterestValues())), "wrong value");
	}		
	
	@Test
	void compoundSavingsConstantTest() {
		assertEquals(107725, Math.round(SavingsFormulas.compoundSavingsConstant
				(s1.getCashValues()[3], s1.getInterestValues()[3], 5)), "wrong value");
	}
	
	@Test
	void compoundSavingsConstantTestTwo() {
		assertEquals(5526, Math.round(SavingsFormulas.compoundSavingsConstant(1000, 0.05, 5)),
				"wrong value");
	}
	
	@Test 
	void compoundSavingsVariableTest() {
		assertEquals(115278, Math.round(SavingsFormulas.compoundSavingsVariable(s1.getCashValues()
				, 0.05)), "wrong value");
	}
	
	@Test
	void compoundSavingsVariableTestTwo() {
		assertEquals(134984, Math.round(SavingsFormulas.compoundSavingsVariable(s1.getCashValues()
				, 0.10)), "wrong value");
	}
}
