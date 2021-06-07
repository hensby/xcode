package Amazon_oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MaxinumUnit {
    public static int getMaxUnit(int num, ArrayList<Integer> boxes, int unitSize, ArrayList<Integer> unitsPerBox, long truckSize){
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        int max = 0;
        for(int i=0;i<num;i++){
            int n= boxes.get(i);
            for(int j=0;j<n;j++){
                PQ.add(unitsPerBox.get(i));
                max+=PQ.peek();
                if(PQ.size()>truckSize){
                    max-=PQ.peek();
                    PQ.remove();
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ArrayList<Integer> boxes = new ArrayList<Integer>(){{add(1); add(2); add(3);}};
        ArrayList<Integer> unitsPerBox = new ArrayList<Integer>(){{add(1); add(2); add(3);}};
        System.out.println(getMaxUnit(3, boxes,3, unitsPerBox,3));
    }
}
