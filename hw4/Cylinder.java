public class Cylinder extends Circle {
    double height;

    Cylinder() {
	super();
	height = 1.0;
    }
    
    Cylinder(double h) {
	super();
	height = h;
    }

    Cylinder(double h, double r) {
	super(r);
	height = h;
    }

    Cylinder(double h, double r, String c) {
	super(r,c);
	height = h;
    }
    
    public double getHeight() {
	return height;
    }

    public void setHeight(double h)  {
	height = h;
    }

    public double getVolume() {
	return getArea() * height;
    }

    // Override the getArea() method inherited from superclass Circle
    @Override
    public double getArea() {
	return 2.0 * Math.PI * radius * (radius + height);
    }
}