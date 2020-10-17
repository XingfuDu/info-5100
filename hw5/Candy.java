public class Candy extends DessertItem {

    private double weight;
    
    private double price_per_pound;

    Candy(String name, double w, double p) {
	super(name);
	price_per_pound = p;
	weight = w;
    }
    
    public double getWeight() {
	return weight;
    }
    
    public double getPrice_per_pound() {
	return price_per_pound;
    }

    @Override 
    public int getCost() {
	int cost = (int) Math.round(weight * price_per_pound);
	if ( cost > Math.pow(10,DessertShoppe.width_of_cost_of_item)) {
	    throw new ArithmeticException("cost too high");
        }
	return cost; 
    }  
}