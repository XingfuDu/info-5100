public class Checkout extends java.lang.Object {

    private int number_of_items;
    private DessertItem[] DItem;
    
    Checkout() {
	number_of_items = 0;
	DItem = new DessertItem[0];
    }
    
    public int numberOfItems() {
	return number_of_items;
    }
    
    public void enterItem(DessertItem item) {
	if (DItem.length == 0) {
	    DItem = new DessertItem[number_of_items+1];
	    DItem[number_of_items] = item;
	    number_of_items++;
	    return ;
	}
	DessertItem[] temp = new DessertItem[number_of_items+1];
	for (int i = 0; i < number_of_items; i++) {
	    temp[i] = DItem[i];
	}
	temp[number_of_items] = item;
	DItem = temp;
	number_of_items++;
    }
    
    public void clear() {
	number_of_items = 0;
	DItem = new DessertItem[0];
    }

    public int totalCost() {
	int totalCost = 0;
	for (int i = 0; i < number_of_items; i++) {
	    totalCost = totalCost + DItem[i].getCost();
        }
	return totalCost;
    }

    public int totalTax() {
	int totalCost = 0;
        for (int i = 0; i < number_of_items; i++) {
	    totalCost = totalCost + DItem[i].getCost();
	}
        return (int) Math.round(totalCost * DessertShoppe.tax_rate);
    }

    @Override
    public String toString() {
	String line1 = DessertShoppe.store_name+" Dessert Shoppe";
	String line2 = "\n-------------------------------";
	String content = "";
	for (int i = 0; i < number_of_items; i++) {
	    if (DItem[i] instanceof Candy) {
		content += "\n" + String.valueOf(((Candy) DItem[i]).getWeight()) + " lbs. @ "
		    + DessertShoppe.cents2dollarsAndCents((int) ((Candy) DItem[i]).getPrice_per_pound())
		    + " /lb.";
	    }
            if (DItem[i] instanceof Cookie) {
                content += "\n" + String.valueOf(((Cookie) DItem[i]).getNum()) + "  @ "
                    + DessertShoppe.cents2dollarsAndCents((int) ((Cookie) DItem[i]).getPrice_per_dozen())
                    + " /dz.";
            }
            content += "\n" + DItem[i].getName() + " " 
		+ DessertShoppe.cents2dollarsAndCents(DItem[i].getCost());
        }
	String costandtax = "\nTax " + DessertShoppe.cents2dollarsAndCents(totalTax())
	    +"\nTotalCost " + DessertShoppe.cents2dollarsAndCents(totalCost()+totalTax());

	return line1+line2+"\n"+content+costandtax;
    }   
}