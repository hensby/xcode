package antra.example;

public class CalculatorThread2 extends Thread {
    Calculator calculator;

    CalculatorThread2(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        calculator.calculate();
    }

}
