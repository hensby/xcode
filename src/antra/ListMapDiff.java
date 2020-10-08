package antra;

import java.util.*;

public class ListMapDiff {

    public static List<Integer> getDiff(List<Integer> list, Map<String, String> map) {

        for(String key : map.keySet()) {
            try {
                int tmp = Integer.parseInt(map.get(key));
                if(list.contains(tmp)) {
                    list.remove((Integer) tmp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,10));
        Map<String, String> map = new HashMap<>(){};
        map.put("A", "1");
        map.put("B", "2");
        map.put("C", "10");
        System.out.println(getDiff(list, map));
    }
}
