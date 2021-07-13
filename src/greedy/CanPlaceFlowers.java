package greedy;
//605
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if(len < n) return false;
        for(int i = 0; i < len; i++) {
            if(n == 0) return true;
            if(flowerbed[i] == 1) continue;
            boolean prev = i == 0? false: flowerbed[i - 1] == 1;
            boolean past = i == len - 1? false: flowerbed[i + 1] == 1;
            if(n > 0 && !prev && !past) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n == 0;
    }

    public static void main(String[] args) {
        CanPlaceFlowers c = new CanPlaceFlowers();
        int[] input = new int[]{1,0,0,0,1};
        int[] input1 = new int[]{1,0,1,0,1,0,0,0,0,0,1};

        int n = 2;
        System.out.println(c.canPlaceFlowers(input,n));
        System.out.println(c.canPlaceFlowers(input1,n));

    }
}
//605. Can Place Flowers
//        You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
//
//        Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.
//
//
//
//        Example 1:
//
//        Input: flowerbed = [1,0,0,0,1], n = 1
//        Output: true
//        Example 2:
//
//        Input: flowerbed = [1,0,0,0,1], n = 2
//        Output: false
//
//
//        Constraints:
//
//        1 <= flowerbed.length <= 2 * 104
//        flowerbed[i] is 0 or 1.
//        There are no two adjacent flowers in flowerbed.
//        0 <= n <= flowerbed.length