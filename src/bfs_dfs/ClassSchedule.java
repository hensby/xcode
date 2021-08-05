package bfs_dfs;

import java.util.*;

public class ClassSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<List<Integer>>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<Integer>());
        }
        for (int[] tmp: prerequisites) {
            indegree[tmp[0]] += 1;
            adjacency.get(tmp[1]).add(tmp[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for(int cur : adjacency.get(pre))
                if(--indegree[cur] == 0) queue.add(cur);
        }
        return numCourses == 0;

    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1,2},{0,1},{0,2},{2,3}};
        ClassSchedule classSchedule = new ClassSchedule();
        System.out.println(classSchedule.canFinish(numCourses, prerequisites));
    }
}
