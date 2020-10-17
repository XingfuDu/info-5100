public class IceCream extends DessertItem {

    private double cost;

    IceCream(String name, double c) {
	super(name);
        if ( c > Math.pow(10,DessertShoppe.width_of_cost_of_item)) {
            throw new ArithmeticException("cost too high");
        }
	cost = c;
    }

    @Override 
    public int getCost() {
	return (int) Math.round(cost); 
    }  
}
