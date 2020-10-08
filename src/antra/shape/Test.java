package antra.shape;

public class Test {
    public static void main(String[] args) {
        Circle c1 = new Circle(1.0);
        Circle c2 = new Circle(1.0);
        Circle c3 = new Circle(1.4);
        System.out.println(c1.culArea());
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3) + "\n");

        Rectangle r1 = new Rectangle(1.5, 2.0);
        Rectangle r2 = new Rectangle(1.5, 2.0);
        Rectangle r3 = new Rectangle(1.5, 2.5);

        System.out.println(r1.culArea());
        System.out.println(r1.equals(r2));
        System.out.println(r1.equals(r3) + "\n");

        Square s1 = new Square(1.5);
        Square s2 = new Square(1.5);
        Square s3 = new Square(3.9);

        System.out.println(s1.culArea());
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
    }

}
