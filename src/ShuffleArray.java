import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {

    //384
//    private int[] array;
//    private int[] original;
//
//    Random rand = new Random();
//
//    private int randRange(int min, int max) {
//        int res = rand.nextInt(max - min) + min;
//        System.out.println(min + " " + max + " " + res);
//        return res;
//    }
//
//    private void swapAt(int i, int j) {
//        int temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//    }
//
//    public ShuffleArray(int[] nums) {
//        array = nums;
//        original = nums.clone();
//    }
//
//    public int[] reset() {
//        array = original;
//        original = original.clone();
//        return original;
//    }
//
//    public int[] shuffle() {
//        for (int i = 0; i < array.length; i++) {
//            swapAt(i, randRange(i, array.length));
//        }
//        return array;
//    }


    int[] origin;
    int[] cur;
    int len;
    Random rand = new Random();
    public ShuffleArray(int[] nums) {
        origin = nums;
        cur = origin.clone();
        len = nums.length;
    }

    public int getRandom(int min, int max) {
        return rand.nextInt(max - min) + min;

    }

    public void swap(int x, int y) {
        int tmp = cur[x];
        cur[x] = cur[y];
        cur[y] = tmp;
        // return;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        cur = origin;
        origin = origin.clone();
        return cur;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = 0; i < len; i++) {
            int ran = getRandom(i, len);
            swap(i, ran);
        }
        return cur;
    }

    public static void main(String[] args) {
        ShuffleArray obj = new ShuffleArray(new int[] { 1, 2, 3, 4, 5});
        int[] param_1 = obj.reset();
        int[] param_2 = obj.shuffle();
        System.out.println(Arrays.toString(param_1));
        System.out.println(Arrays.toString(param_2));
    }
}
