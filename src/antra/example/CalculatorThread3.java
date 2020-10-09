package antra.example;

public class CalculatorThread3 extends Thread {
    Calculator calculator;

    CalculatorThread3(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        calculator.printRes(3);
    }

}
