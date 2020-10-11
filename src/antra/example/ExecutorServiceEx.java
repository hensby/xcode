package antra.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceEx {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(); // one thread
        newSingleThreadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("int single thread");
            }
        });
        newSingleThreadExecutor.shutdown();

        ExecutorService newMultipleThreadExecutor = Executors.newScheduledThreadPool(3);


        List<Callable<String>> al=new ArrayList();
        for(int i = 1; i < 10; i++) {
            al.add(new Task3(i));
        }

        List<Future<String>> invokeAll = newMultipleThreadExecutor.invokeAll(al);
        for(Future f:invokeAll) {
            System.out.println(f.get());
        }
        newMultipleThreadExecutor.shutdown();

        //        newMultipleThreadExecutor.execute(new Runnable() {
//
//            @Override
//            public void run() {
//                System.out.println("int single thread");
//            }
//        });
//        newMultipleThreadExecutor.shutdown();

    }
}
