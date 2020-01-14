package gragh;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GetInportFile {

    Set<String> getTransitivelyImportedFile(String filename) {
        Queue<String> q = new LinkedList<>();
        q.add(filename);
        Set<String> visited = new HashSet<>();

        while (!q.isEmpty()) {
            String cur = q.remove();
            for (String imported : getTransitivelyImportedFile(cur)) {
                if (visited.add(imported)) {
                    q.add(imported);
                }
            }
        }
        return visited;
    }

}
