package antra.example;

public class CauculatorEx {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        CalculatorThread1 c1 = new CalculatorThread1(calculator);
        CalculatorThread1 c2 = new CalculatorThread1(calculator);
        CalculatorThread1 c3 = new CalculatorThread1(calculator);

        c1.start();
        c2.start();
        c3.start();
    }
}
