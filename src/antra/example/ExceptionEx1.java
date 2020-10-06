package antra.example;

public class ExceptionEx1 {  //runtime stack
    public static void main(String[] args) {
        System.out.println("int main before do stuff");
        doStuff();
        System.out.println("int main after do stuff");
    }

    public static void doStuff() {
        System.out.println("in do stuff before domorestuff");
        try {
            doMoreStuff();
        } catch (Exception e) {

        }
        System.out.println("in do stuff after domorestuff");
    }

    public static void doMoreStuff() {
//        try {
            System.out.println(2 / 0);
//        } catch (Exception e) {

//        }
        System.out.println("in do more stuff");
    }
}
