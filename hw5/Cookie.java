public class Cookie extends DessertItem {

    private int number;
    
    private double price_per_dozen;

    Cookie(String name, int num, double p) {
	super(name);
	number = num;
	price_per_dozen = p;
    }

    public int getNum() {
	return number;
    }

    public double getPrice_per_dozen() {
	return price_per_dozen;
    }

    @Override 
    public int getCost() {
	int cost = (int) Math.round(number * price_per_dozen / 12.0);
	if ( cost > Math.pow(10,DessertShoppe.width_of_cost_of_item)) {
            throw new ArithmeticException("cost too high");
        }
	return cost;
    }  
}
