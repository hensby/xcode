package antra;

import java.util.Arrays;

public class TargetArray {
    int[] res;
    public int[] createTargetArray(int[] nums, int[] index) {
        if(nums == null || index == null || nums.length != index.length) return new int[0];
        this.res = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            swap(index[i], nums[i]);
            res[index[i]] = nums[i];
        }
        return res;
    }

    public void swap(int index, int num) {
        for(int i = res.length - 1; i > index; i--) {
            res[i] = res[i - 1];
        }
    }

    public static void main(String[] args) {
        //int[] nums =new int[] {0,1,2,3,4}, index = new int[] {0,1,2,2,1};
        int[] nums =new int[] {1,2,3,4,0}, index = new int[] {0,1,2,3,0};
        System.out.println(Arrays.toString(new TargetArray().createTargetArray(nums, index)));
    }
}
