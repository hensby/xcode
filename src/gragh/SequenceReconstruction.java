package gragh;

import java.util.*;

public class SequenceReconstruction {
    /**
     * 444.Sequence Reconstruction
     Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs.
     The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 104.
     Reconstruction means building a shortest common supersequence of the sequences in seqs
     (i.e., a shortest sequence so that all sequences in seqs are subsequences of it).
     Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.

     Example 1:

     Input:
     org: [1,2,3], seqs: [[1,2],[1,3]]

     Output:
     false

     Explanation:
     [1,2,3] is not the only one sequence that can be reconstructed,
     because [1,3,2] is also a valid sequence that can be reconstructed.
     Example 2:

     Input:
     org: [1,2,3], seqs: [[1,2]]

     Output:
     false

     Explanation:
     The reconstructed sequence can only be [1,2].
     Example 3:

     Input:
     org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]

     Output:
     true

     Explanation:
     The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
     Example 4:

     Input:
     org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]

     Output:
     true
     */
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        // key is node, value is outgoing nodes
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for (List<Integer> seq : seqs) {
            if (seq.size() == 1) {
                map.computeIfAbsent(seq.get(0), k -> {
                    indegree.put(k, 0);
//                    System.out.println("indegree1: " + indegree);
                    return new HashSet<>();
                });
            } else {
                for (int i = 1; i < seq.size(); i++) {
                    int prev = seq.get(i - 1), cur = seq.get(i);

                    map.computeIfAbsent(cur, k -> {
                        indegree.put(k, 0);
                        System.out.println("indegree2: " + indegree);
                        return new HashSet<>();
                    });

                    map.computeIfAbsent(prev, k -> {
                        indegree.put(k, 0);
                        return new HashSet<>();
                    });

                    // cur is the outgoing node of prev
                    if (map.get(prev).add(cur)) {
                        // increment indegree of cur
                        indegree.put(cur, indegree.get(cur) + 1);
                    }
                }
            }
        }
        System.out.println(map);
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > 1) {
                return false;
            }
            int cur = queue.poll();
            if (index == org.length || cur != org[index++]) {
                return false;
            }
            for (int next : map.get(cur)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        return index == org.length && index == map.size();
    }

    public static void main(String[] args) {
        int[] org = new int[] {1, 2, 3};
        int[] org1 = new int[] {4,1,5,2,6,3};
        List<List<Integer>> seqs = new LinkedList<>();
        List<Integer> tmp1 = Arrays.asList(1,2);
        List<Integer> tmp2 = Arrays.asList(1,3);
        List<Integer> tmp3 = Arrays.asList(2,3);
        seqs.add(tmp1);
        seqs.add(tmp2);
        seqs.add(tmp3);
        List<List<Integer>> seqs1 = new LinkedList<>();
        List<Integer> tmp11 = Arrays.asList(5,2,6,3);
        List<Integer> tmp12 = Arrays.asList(4,1,5,2);
        seqs1.add(tmp11);
        seqs1.add(tmp12);


        SequenceReconstruction sequenceReconstruction = new SequenceReconstruction();
        System.out.println(sequenceReconstruction.sequenceReconstruction(org, seqs));

    }
}
