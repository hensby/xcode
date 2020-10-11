//package antra.example;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.Callable;
//import java.util.concurrent.Executor;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//
//public class ExecutorServiceEx {
//    public static void main(String[] args) {
//
//        ScheduledExecutorService newMultipleThreadExecutor = Executors.newScheduledThreadPool(5);
//
////        newMultipleThreadExecutor.execute(new Runnable() {
////
////            @Override
////            public void run() {
////                System.out.println("int one thread");
////            }
////        });
//        List<Callable<String>> al = new ArrayList<>();
//        for(int i = 1; i < 6; i++) {
//            al.add(new Task3(i));
//        }
//
//        newMultipleThreadExecutor.invokeAll(al);
//
//        newMultipleThreadExecutor.shutdown();
//    }
//}
