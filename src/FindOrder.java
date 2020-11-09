import java.util.Arrays;

public class FindOrder {
    /*
    N students {0, ..., N-1} participate in a marathon. - You are given A[N] and A[i] = j means that student j finished just before student i.
    A[k] = -1 means that k is the first student. - No tie.
    List out the students in the order in which they finished the marathon.

    A[0] = -1
    A[1] = 0
    A[2] = 1

    input: A [-1, 0, 1]
    output: [0, 1, 2]
     */

    public int[] findOrder1(int[] A) {
        int a = A.length;
        int[] result = new int[a];
        int[] adjList = new int[a];
        Arrays.fill(adjList, -1);
        System.out.println(adjList);
        int cur = -1;
        for (int i = 0; i < a; i++){
            if(A[i] == -1){
                cur = i;
                continue;
            }
            adjList[A[i]] = i;
        }
        int count = -1;
        while (++count < a){
            result[count] = cur;
            cur = adjList[cur];

        }

        return result;
    }

    public static void main(String[] args) {
        FindOrder findOrder = new FindOrder();
        int[] A = new int[]{-1,0,1};
        System.out.println(findOrder.findOrder1(A));
    }
}
