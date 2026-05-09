public class Cylinder extends Shape {
	double radius;
    double height;
	Cylinder (double radius, double height) { //constructor
		this.radius = radius;
        this.height = height;
    }
    @Override
    public double surface_area() { //surface area method for cylinder
        double calcArea = 2.0 * Math.PI * radius * height + 2.0 * Math.PI * Math.pow(radius, 2);
    return calcArea; //returning the surface area
    }

    @Override
    public double volume() { //volume method for cylinder
        double calcVol = Math.PI * Math.pow(radius, 2) * height;
    return calcVol; //returns volume
    }

    @Override
    public String toString() { //method to return a string for printing
        return "Cylinder:\nSurface Area: " + surface_area() + "\nVolume: " + volume();
    }

}   