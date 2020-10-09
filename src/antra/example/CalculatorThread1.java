package antra.example;

public class CalculatorThread1 extends Thread {
    Calculator calculator;

    CalculatorThread1(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        calculator.printRes(1);
    }

}
