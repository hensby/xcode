import java.util.*;

// 策略树查找，第一个是查询点，按离根结点距离排序，res里是树的信息，parent+child+link属性。求搜索节点的叶子结点。
public class Huawei {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine();
//
        List<String> res = new ArrayList<>();
//        while(sc.hasNext()) {
//            res.add(sc.nextLine());
//        }
        String input = "A:10|E:2,3";
        res.add("A,B,30");
        res.add("A,E,10");
        res.add("B,C,50");
        res.add("B,D,30");
        res.add("E,F,3");
        res.add("E,K,2");
        res.add("F,G,30");
        res.add("F,H,0");
        res.add("H,I,PTN");
        res.add("H,J,IP");
        res.add("K,M,30");
        res.add("K,N,50");
        String[] query = input.split("\\|");
        Map<String, Map<String, String>> map = new HashMap<>();
        for (String re : res) {
            String[] tmp = re.split(",");
            System.out.println(Arrays.toString(tmp));
            Map<String, String> tmpMap;
            if (map.containsKey(tmp[0])) {
                tmpMap = map.get(tmp[0]);
            } else {
                tmpMap = new HashMap<>();
            }
            tmpMap.put(tmp[1], tmp[2]);
            map.put(tmp[0], tmpMap);
        }

        System.out.println(searchTree(map, query));
    }

    public static String searchTree(Map<String, Map<String, String>> map, String[] query) {
        List<String> res = new ArrayList<>();
        String tmpQuery = query[query.length - 1];
        String start = tmpQuery.split(":")[0];
        String[] paths = tmpQuery.split(":")[1].split(",");
        Queue<String> queue = new LinkedList<>();
        for(String path: paths) {
            Map<String, String> tmpMap = map.get(start);
            if(tmpMap.containsValue(path)) {
                for(String key: tmpMap.keySet()) {
                    if(tmpMap.get(key).equals(path)) {
                        queue.add(key);
                    }
                }
            }
        }
        while(!queue.isEmpty()) {
            String tmpStart = queue.poll();
            if(!map.containsKey(tmpStart)) {
                res.add(tmpStart);
            } else {
                Map<String, String> tmpMap = map.get(tmpStart);
                for(String s: tmpMap.keySet()) {
                    queue.add(s);
                }
            }
        }
        String[] tmpRes = res.toArray(new String[res.size()]);
        Arrays.sort(tmpRes);
        String stringRes = tmpRes[0];
        for(int i = 1; i < tmpRes.length; i++) {
            stringRes += ",";
            stringRes += tmpRes[i];
        }
        return stringRes;
    }
}
