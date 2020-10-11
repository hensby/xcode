package antra.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceEx {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

//        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(); // one thread
//        newSingleThreadExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("int single thread");
//            }
//        });
//        newSingleThreadExecutor.shutdown();

        ExecutorService newMultipleThreadExecutor = Executors.newScheduledThreadPool(3);

//        newMultipleThreadExecutor.execute(new Runnable() {
//
//            @Override
//            public void run() {
//                System.out.println("int single thread");
//            }
//        });
//        newMultipleThreadExecutor.shutdown();

        List<Callable<String>> al=new ArrayList();
        for(int i = 1; i < 10; i++) {
            al.add(new Task3(i));
        }

        List<Future<String>> invokeAll = newMultipleThreadExecutor.invokeAll(al);
        for(Future f:invokeAll) {
            System.out.println(f.get());
        }
        newMultipleThreadExecutor.shutdown();

//        al.add(new Task3(1));
//        al.add(new Task3(2));
//        al.add(new Task3(3));
//        al.add(new Task3(4));
//        al.add(new Task3(5));
//        al.add(new Task3(6));
//        al.add(new Task3(7));
//        al.add(new Task3(8));
//        al.add(new Task3(9));
//        al.add(new Task3(10));


    }
}
