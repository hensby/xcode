package Amazon_oa;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SlowestKey {
    public char slowestKey(int[][] input) {
        Arrays.sort(input, (i1, i2)-> i1[1] - i2[1]);
        int[] map = new int[26];
        for(int i = 0; i < input.length; i++) {
            if(i == 0) map[input[i][0]] = input[i][1];
            else {
                map[input[i][0]] += input[i][1] - input[i - 1][1];
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((l1, l2) -> map[l2] - map[l1]);
        for(int[] tmp: input) {
            pq.add(tmp[0]);
        }
        System.out.println(Arrays.toString(map));
        char res = (char) (pq.poll() + 'a');
        return res;
    }

    public static void main(String[] args) {
        SlowestKey slowestKey = new SlowestKey();
        int[][] input = new int[][] {{0, 2}, {1, 5}, {0, 9}, {2, 19}};
        System.out.println(slowestKey.slowestKey(input));
    }
}
//    第二题是 slowest key
//        https://medium.com/codingwithale ... python-a002ef802bff
//        给一堆tuple, [(0,1),(0,5),(1,10)] 这样，tuple第一个是字母，0-25对应a-z,第二个是秒数。让输出时间最长的字母（只有一个）
//        这题卡了半天，有一个case死活过不去，换了种写法用sort就过了。。不知道为啥