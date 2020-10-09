package antra;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class WriteThread extends Thread {
    ArrayList<String> output;
    String path;

    public WriteThread(ArrayList<String> output, String path) {
        this.output = output;
        this.path = path;
    }

    @Override
    public void run() {
        try {
            File file = new File(path);
            if (!file.isFile()) {
                file.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            for (String l: output) {
                writer.write(l + "\r\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
