package ArrayListStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindOrder {
    /*
    N students {0, ..., N-1} participate in a marathon. - You are given A[N] and A[i] = j means that student j finished just before student i.
    A[k] = -1 means that k is the first student. - No tie.
    List out the students in the order in which they finished the marathon.

    A[0] = -1
    A[1] = 0
    A[2] = 1
                  1
    input: A [-1, 0, 1]
    output: [0, 1, 2]
     */

    public int[] findOrder1(int[] A) {
        int a = A.length;
        int[] result = new int[a];
        int[] adjList = new int[a];
        Arrays.fill(adjList, -1);
        int cur = -1;
        for (int i = 0; i < a; i++){
            if(A[i] == -1){
                cur = i;
                continue;
            }
            adjList[A[i]] = i;
        }
        System.out.println(Arrays.toString(adjList));

        int count = -1;
        while (++count < a){
            result[count] = cur;
            cur = adjList[cur];

        }

        return result;
    }

    public int[] findOrder(int[] A) {
        if (A == null || A.length == 0) return null;
        Map<Integer, Integer> adjacency = new HashMap<>();
        int[] res = new int[A.length];
        int start = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == -1) {
                start = i;
                continue;
            }
            adjacency.put(A[i], i);
        }
        System.out.println(adjacency);
        int count = 0;
        while (count < A.length) {
            res[start] = count;
            start = adjacency.getOrDefault(start, -1);
            count++;
        }
        return res;
    }

        public static void main(String[] args) {
        FindOrder findOrder = new FindOrder();
        int[] A = new int[]{-1,0,1};
            System.out.println(Arrays.toString(findOrder.findOrder(A)));
    }
}
