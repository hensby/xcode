package antra.shape;

public class Circle implements Shape {

    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double culArea() {
        double area = radius * radius * Math.PI;
        System.out.println("Circle area is: " + area);

        return area;
    }

    @Override
    public boolean equals(Object obj) {
        Circle o = (Circle) obj;
        if(this.radius == o.radius) {
            System.out.println("Circles are equal");
            return true;
        }
        System.out.println("Circles are not equal");
        return false;
    }
}
