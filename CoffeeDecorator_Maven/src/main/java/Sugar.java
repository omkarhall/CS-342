
public class Sugar extends CoffeeDecorator{

	private double cost = .50;
	
	Sugar(Coffee specialCoffee){
		super(specialCoffee);
	}
	
	public double makeCoffee() {
		return specialCoffee.makeCoffee()+ addSugar();
	}
	
	private double addSugar() {
		
		System.out.println(" + sugar: $.50");
		
		return cost;
	}
	
	public String makeCoffeeString() {
		return specialCoffee.makeCoffeeString() + "\n + sugar: $.50";
	}
}
