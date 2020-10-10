public class TestCylinder {
    public static void main(String[] args) {
   
	//Constructed a Circle with Circle()
	//Run of the program should produce the following output:
	//Radius is 2.0, Color is yellow, Base area is (your answer)
	Circle cir = new Circle(2.0,"yellow");
	double radius = cir.getRadius();
	String color = cir.getColor();
	double area = cir.getArea();
	System.out.print("The circle has radius " + radius);
	System.out.print(", color " + color);
	System.out.print(", area " + area);
	System.out.println(" ");

	//Constructed a Cylinder with Cylinder()
	//Run of the program should produce the following output:
	//Radius is 1.0, Height is 1.0, Color is red, Base area is (your answer), Volume is (your answer)
	Cylinder cyl = new Cylinder();
	radius = cyl.getRadius();
        color = cyl.getColor();
        area = cyl.getArea();
	double height = cyl.getHeight();
	double volume = cyl.getVolume();
	System.out.print("The cylinder has radius " + radius);
        System.out.print(", color " + color);
	System.out.print(", height " + height);
        System.out.print(", Base area " + area);
	System.out.print(", volume " + volume);
	System.out.println(" ");

	//Constructed a Cylinder with Cylinder(height, radius)
	//Run of the program should produce the following output:
	//Radius is 2.0, Height is 5.0, Color is red, Base area is (your answer), Volume is (your answer)
	cyl = new Cylinder(5.0,2.0);
        radius = cyl.getRadius();
        color = cyl.getColor();
	height = cyl.getHeight();
        area = cyl.getArea();
        volume = cyl.getVolume();
        System.out.print("The cylinder has radius " + radius);
        System.out.print(", color " + color);
	System.out.print(", height " + height);
        System.out.print(", Base area " + area);
        System.out.print(", volume " + volume);
        System.out.println(" ");

    }
}