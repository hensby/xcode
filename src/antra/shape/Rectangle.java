package antra.shape;

public class Rectangle implements Shape{

    double longEdge;
    double shortEdge;

    Rectangle(double longEdge, double shortEdge) {
        this.longEdge = longEdge;
        this.shortEdge = shortEdge;
    }

    @Override
    public double culArea() {
        double area = longEdge * shortEdge;
        System.out.println("Rectangles area is: " + area);
        return area;
    }

    @Override
    public boolean equals(Object obj) {
        Rectangle o = (Rectangle) obj;
        if(this.longEdge == o.longEdge && this.shortEdge == o.shortEdge) {
            System.out.println("Rectangles are equal");
            return true;
        }

        System.out.println("Rectangles are not equal");
        return false;
    }
}
