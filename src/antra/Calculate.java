package antra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Calculate {

    public static int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();

        char lastOp = '+';
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i ++){
            if(arr[i] == ' ') continue;

            if(Character.isDigit(arr[i])){
                int tempNum = arr[i] - '0';
                while(++i < arr.length && Character.isDigit(arr[i])){
                    tempNum = tempNum * 10 + (arr[i] - '0');
                } i--;

                if(lastOp == '+') numStack.push(tempNum);
                else if(lastOp == '-') numStack.push(-tempNum);
                else numStack.push(res(lastOp, numStack.pop(), tempNum));
            } else lastOp = arr[i];
        }

        int ans = 0;
        for(int num : numStack) ans += num;
        return ans;
    }

    private static int res(char op, int a, int b){
        if(op == '+') return a + b;
        else return a - b;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(30);
        Future<ArrayList<String>> future = es.submit(new ReadThread("src/antra/input.txt"));
        ArrayList<String> input = future.get();
        System.out.println(input);

        ArrayList<String> result = new ArrayList<>();

        for(String s : input) {
            if(s.equals("")) continue;
            int res = calculate(s);
            result.add(s + " = " + res);
        }
        System.out.println(result);

        WriteThread wt = new WriteThread(result,"src/antra/output.txt");
        wt.start();
    }
}
