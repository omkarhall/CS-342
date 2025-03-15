
public class SavingsFormulas {

	public static double futureValueLumpSum(double cash, double interest, int years) {
		return cash * Math.pow((1 + interest), years);
	}

	private static double variableInterestHelper(double cash, double values[], int i) {
		if (i == values.length - 1) {
			return cash * (1 + values[values.length - 1]);
		}
		cash = cash * (1 + values[i]);
		return variableInterestHelper(cash, values, i + 1);
	}

	public static double futureValueLS_VariableInterest(double cash, double values[]) {
		return variableInterestHelper(cash, values, 0);
	}
	
	public static double compoundSavingsConstant(double cash, double interest, double years) {
		return cash * ((Math.pow(1 + interest, years) - 1) / interest);
	}

	private static double compoundSavingsVariableHelper(double futureVal, double values[], 
			double interest, int i) {
		if (i == values.length) {
			return futureVal;
		}
		futureVal += (futureVal * interest) + values[i];
		return compoundSavingsVariableHelper(futureVal, values, interest, i + 1);
		
	}

	public static double compoundSavingsVariable(double values[], double interest) {
		return compoundSavingsVariableHelper(0, values, interest, 0); 
	}
}
