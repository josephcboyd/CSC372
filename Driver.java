public class Driver {
        public static void main(String[] args) {
        Shape cone = new Cone(7.0, 8.0);
        Shape ball = new Sphere( 2.0);
        Shape can = new Cylinder(3.0, 5.5);
        Shape[] shapes = {cone, ball, can}; //storing each in a list of shapes

        for (Shape s : shapes) { //looping through shapes and printing surface area and volume for each
            System.out.println(s.toString());
        }
    }
}
