public class DessertShoppe {

    public static double tax_rate = 0.065;
    
    public static String store_name = "Xingfu Du";

    public static int max_size_of_item_name = 100;

    public static int width_of_cost_of_item = 10;

    public static String cents2dollarsAndCents(int n) {
	double num = n / 100.0;
	return String.valueOf(num);
    }    
}
