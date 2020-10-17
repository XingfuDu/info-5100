public abstract class DessertItem extends java.lang.Object {

    protected java.lang.String name;
    
    DessertItem() {}
    
    DessertItem(java.lang.String name) {
        if (name.length() > DessertShoppe.max_size_of_item_name) {
            throw new ArithmeticException("item name too long");
        }
	this.name = name;
    }

    public java.lang.String getName() {
	return this.name;
    }
    
    public abstract int getCost();
     
}
