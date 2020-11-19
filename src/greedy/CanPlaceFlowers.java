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
        int n = 2;
        c.canPlaceFlowers(input,2);
    }
}
