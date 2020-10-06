package antra;

public class SecondLargestNum {

    public static int secondLargest (int[] a) { // second largest num
        if(a.length < 2) return Integer.MIN_VALUE;// conner case
        int first = a[0], second = Integer.MIN_VALUE;
        for(int i: a) {
            if(i < first && i > second) {
                second = i;
            } else if(i > first) {
                second = first;
                first = i;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 4, 5, 10, 23, 9, 12, 8, 21, 1, 3};
//        int[] a = new int[]{1};
        System.out.println(secondLargest(a));

    }
}
