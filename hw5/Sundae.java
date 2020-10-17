public class Sundae extends IceCream {

    Sundae(String name, double c1, String t, double c2) {
	super(t + " Sundae with \n"+name,c1+c2);
        if ( c1+c2 > Math.pow(10,DessertShoppe.width_of_cost_of_item)) {
            throw new ArithmeticException("cost too high");
        }
    }

    @Override 
    public int getCost() {
	return (int) Math.round(super.getCost()); 
    }  
}
