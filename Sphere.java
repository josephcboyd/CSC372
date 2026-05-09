public class Sphere extends Shape {
	double radius;
	Sphere (double radius) { //constructor for Sphere, only needs one attribute for both calculations
		this.radius = radius;
    }
    @Override
    public double surface_area() {
        double calcArea = 4.0 * Math.PI * Math.pow(radius, 2);
    return calcArea;
    }

    @Override
    public double volume() {
        double calcVol = (4.0/3.0) * Math.PI * Math.pow(radius, 3);
    return calcVol;
    }

    @Override
    public String toString() { //method to return a string for printing
        return "Sphere: \nSurface Area: " + surface_area() + "\nVolume: " + volume();
    }

}   