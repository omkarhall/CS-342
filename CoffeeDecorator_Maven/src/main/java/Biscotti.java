
public class Biscotti extends CoffeeDecorator {

	private double cost = .50;
	Biscotti(Coffee specialCoffee){
		super(specialCoffee);
	}
	
	public double makeCoffee() {
		return specialCoffee.makeCoffee()+ addBiscotti();
	}
	
	private double addBiscotti() {
		
		System.out.println(" + biscotti: $.50");
		
		return cost;
	}
	
	public String makeCoffeeString() {
		return specialCoffee.makeCoffeeString() + "\n + biscotti: $.50";
	}
}
