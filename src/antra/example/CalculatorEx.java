package antra.example;

public class CalculatorEx {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        CalculatorThread1 c1 = new CalculatorThread1(calculator);
        CalculatorThread2 c2 = new CalculatorThread2(calculator);
        CalculatorThread3 c3 = new CalculatorThread3(calculator);

        c1.start();
        c2.start();
        c3.start();
    }
}
