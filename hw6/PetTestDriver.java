public class PetTestDriver {
    public static void main(String[] args) {
	Pet p = new Pet("Spot","Mary","Black and White");
	p.setSex(1);
	System.out.println(p);

	System.out.println("");
        Cat c = new Cat("Tom","Bob","Black","Short");
        c.setSex(3);
        System.out.println(c);

	System.out.println("");
        Dog d = new Dog("Spot","Susan","White","Medium");
        d.setSex(3);
        System.out.println(d);
    }
}