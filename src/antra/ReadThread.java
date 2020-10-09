package antra;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ReadThread implements Callable<ArrayList<String>> {
    String path;

    ReadThread(String path) {
        this.path = path;
    }

    private ArrayList<String> input = new ArrayList<>();

    public ArrayList<String> getList() {
        try {
            FileInputStream file = new FileInputStream(path);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file));
            String str = null;
            while((str = bufferedReader.readLine()) != null  ) {
                if(str.equals("")) continue;
                input.add(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return input;
    }

    public ArrayList<String> getInput() {
        return input;
    }

    public void setInput(ArrayList<String> input) {
        this.input = input;
    }

    @Override
    public ArrayList<String> call() throws Exception {
        return getList();
    }
}
