package Amazon_oa;

import java.util.ArrayList;
import java.util.List;

public class ItemnsInContainers {

    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        int[] mem = new int[s.length()];
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '|') {
                mem[i] = count;
            } else {
                ++count;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < startIndices.size(); ++i) {
            int start = startIndices.get(i) - 1;
            int end = endIndices.get(i) - 1;

            while (start < end && s.charAt(start) != '|') ++start;
            while (start < end && s.charAt(end) != '|') --end;

            ans.add(mem[end] - mem[start]);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "|**|*|*";
        List<Integer> startIndices = new ArrayList<Integer>(){{add(1);add(1);}};
        List<Integer> endIndices =  new ArrayList<Integer>(){{add(5);add(6);}};
        System.out.println(numberOfItems(s, startIndices, endIndices));
    }
}

//          Example:
//        s = '|**|*|*'
//        startIndices = [1,1]
//        endIndices = [5,6]
//
//        The String has a total 2 closed compartments, one with 2 items and one with 1 item. For the first par of indices, (1,5), the substring is '|**|*'. There are 2 items in a compartment.
//        For the second pair of indices, (1,6), the substring is '|**|*|' and there 2+1=3 items in compartments.
//        Both of the answers are returned in an array. [2,3].


