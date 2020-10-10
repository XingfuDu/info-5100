public class Circle {
    double radius;
    String color;
    
    Circle() {
	radius = 1.0;
	color = "red";
    }

    Circle(double r) {
	radius = r;
	color = "red";
    }

    Circle(double r, String c) {
	radius = r;
        color = c;
    }
     
    public double getRadius() {
	return radius;
    }

    public void setRadius(double r) {
	radius = r;
    }

    public String getColor() {
	return color;
    }

    public void setColor(String c) {
	color = c;
    }
    
    public double getArea() {
	return Math.PI * radius * radius;
    }
}
