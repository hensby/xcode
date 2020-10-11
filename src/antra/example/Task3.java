package antra.example;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

public class Task3 implements Callable {

    int i;
    public Task3(int i) {
        this.i=i;
    }

    @Override
    public String call() throws Exception {
        LocalDateTime myDateObj = LocalDateTime.now();

        return "Thread" + i + myDateObj;
    }
}
