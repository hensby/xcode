package Amazon_onsite;

import java.util.Random;

public class randomReturn {

    public static int randomReturnFunc(int percentage) {
        Random r = new Random();
        int num = r.nextInt(100);
        if (num < percentage) return 0;
        else return 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(randomReturnFunc(50));
        }
    }
}
