package antra.readAndWrite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

public class WriteThread1 extends Thread{

    protected BlockingQueue<String> blockingQueue = null;

    public WriteThread1(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(new File("src/antra/readAndWrite/outputFile.txt"));
            while(true){
                String buffer = blockingQueue.take();
                //Check whether end of file has been reached
                if(buffer.equals("EOF")){
                    break;
                }
                if(buffer.equals("")) continue;
                int res = CalculateMethod.calculate(buffer);
                writer.println(buffer + " = " + res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            writer.close();
        }

    }
}
