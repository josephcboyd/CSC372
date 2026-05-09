public class Cone extends Shape {
	double radius;
    double height;
	Cone (double radius, double height) { //constructor for cone
		this.radius = radius;
        this.height = height;
    }
    @Override
    public double surface_area() {
        double calcArea = Math.PI * radius * (
                radius + Math.sqrt( //breaking down the formula by line to make it more readable
                    (Math.pow(height, 2) + Math.pow(radius, 2)
                )
            )
        );
    return calcArea;
    }

    @Override
    public double volume() {
        double calcVol = Math.PI * Math.pow(radius, 2) * (height / 3.0);
    return calcVol;
    }

    @Override
    public String toString() { //method to return a string for printing
        return "Cone:\nSurface Area: " + surface_area() + "\nVolume: " + volume();
    }

    
}   