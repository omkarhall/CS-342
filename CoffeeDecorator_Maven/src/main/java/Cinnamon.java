
public class Cinnamon extends CoffeeDecorator {

	private double cost = .10;
	Cinnamon(Coffee specialCoffee){
		super(specialCoffee);
	}
	
	public double makeCoffee() {
		return specialCoffee.makeCoffee()+ addCinnamon();
	}
	
	private double addCinnamon() {
		
		System.out.println(" + cinnamon: $.10");
		
		return cost;
	}
	
	public String makeCoffeeString() {
		return specialCoffee.makeCoffeeString() + "\n + cinnamon: $.10";
	}
}
