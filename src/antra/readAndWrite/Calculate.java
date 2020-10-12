package antra.readAndWrite;


import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Calculate {
    public static void main(String[] args) throws IOException {

        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);

        ReadThread1 reader = new ReadThread1(queue);
        WriteThread1 writer = new WriteThread1(queue);

        new Thread(reader).start();
        new Thread(writer).start();
    }


}
