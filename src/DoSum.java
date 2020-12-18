public class DoSum extends Thread {
// give an array of integer size n, Sum of all array element with multi thread,
// each thread could not handle more than 20 numbers, Find the sum of array.
    private int[] arr;

    private int low, high, partial;

    public DoSum(int[] arr, int low, int high) {
        this.arr = arr;
        this.low = low;
        this.high = Math.min(high, arr.length);
    }

    public int getPartialSum() {
        return partial;
    }

    public void run() {
        partial = sum(arr, low, high);
    }

    public static int sum(int[] arr) {
        return sum(arr, 0, arr.length);
    }

    public static int sum(int[] arr, int low, int high) {
        int total = 0;

        for (int i = low; i < high; i++) {
            total += arr[i];
        }

        return total;
    }

    public static int parallelSum(int[] arr) {
//        return parallelSum(arr, Runtime.getRuntime().availableProcessors());
        System.out.println((int) Math.ceil(arr.length * 1.0 / 20));
        int threadsNum = (int) Math.ceil(arr.length * 1.0 / 20);
        return parallelSum(arr, threadsNum);
    }

    public static int parallelSum(int[] arr, int threads) {
        int size = (int) Math.ceil(arr.length * 1.0 / threads);

        DoSum[] sums = new DoSum[threads];

        for (int i = 0; i < threads; i++) {
            sums[i] = new DoSum(arr, i * size, (i + 1) * size);
            sums[i].start();
        }

        try {
            for (DoSum sum : sums) {
                sum.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int total = 0;

        for (DoSum sum : sums) {
            total += sum.getPartialSum();
        }

        return total;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,9,7,8,7,8,56,65,6,56,56,5,6,56,56, 2, 1, 23, 3, 3, 3,4,5, 3, 4, 3, 4, 5, 4, 5,6,4, 5, 45, 23, 23, 2, 32, 3, 2, 12, 5, 46, 56, 76, 7, 63, 4, 34, 3, 43, 4, 34};
        System.out.println(parallelSum(input));
    }
}
