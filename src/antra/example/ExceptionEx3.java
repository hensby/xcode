package antra.example;

public class ExceptionEx3 {
    public static void main(String[] args) throws StudentNotFoundExcaption {
        throw new StudentNotFoundExcaption("not avaliable");
    }
}
