package antra.shape;

public class Square implements Shape{
    double edge;

    Square(double edge) {
        this.edge = edge;
    }

    @Override
    public double culArea() {
        double area = edge * edge;
        System.out.println("square area is: " + area);
        return area;
    }

    @Override
    public boolean equals(Object obj) {
        Square o = (Square) obj;
        if(this.edge == o.edge) {
            System.out.println("Squares are equal");
            return true;
        }

        System.out.println("Squares are not equal");
        return false;
    }
}
