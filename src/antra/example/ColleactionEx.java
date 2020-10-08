package antra.example;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ColleactionEx {

    public static void listImpl() {
        //        List<Integer> a = new ArrayList<>();
//        Vector<Integer> a = new Vector<>();
//        Stack<Integer> a = new Stack<>();
        LinkedList<Integer> a = new LinkedList<>();
        a.add(11);
        a.add(23);
        a.add(34);
        a.add(93);
        System.out.println(a);
        List li = Collections.unmodifiableList(a); // unmodifiable
        li.add(222);
    }

    public static void setImpl() {
        HashSet<Object> hs = new HashSet<>(); // not have duplicate
        hs.add(23);
        hs.add(22);
        hs.add(33);
        hs.add(2);
        hs.add(111);
        hs.add(23);
        hs.add(new Person("e"));

        System.out.println(hs);
    }

    public static void treeSetImpl() {
        TreeSet<Object> hs = new TreeSet<>(); // sorted follow balance tree DE
        hs.add(23);
        hs.add(22);
        hs.add(33);
        hs.add(2);
        hs.add(111);
        hs.add(23);
//        hs.add(new Person("e")); // can only have one type of object// homogeneous object 同质的
        System.out.println(hs);

    }

    public static void mapEx() {
        HashMap hm = new HashMap(); // key cannot be duplicate // is unordered
//        LinkedHashMap hm = new LinkedHashMap(); // in order
//        ConcurrentHashMap hm = new ConcurrentHashMap(); // onetime, synchronized
        hm.put(1, "whc");
        hm.put(2, "henry");
        hm.put(3, "rick");
        hm.put(new Person("tom"), "new person");
        hm.put(null, "ddd");
        hm.remove(null);
        System.out.println(hm);

        Set set = hm.keySet();
        Iterator it = set.iterator();
        while(it.hasNext()) {
            System.out.println(hm.get(it.next()));
//            hm.put(1, "whc");
        }
        Map map = Collections.synchronizedMap(hm);
        System.out.println(map);
    }

    public static void hashTableEx() {
        Hashtable hm = new Hashtable();// 16 bucked, synchronized
        hm.put(1, "whc");
        hm.put(2, "henry");
        hm.put(3, "rick");
        hm.put(new Person("tom"), "new person");
        System.out.println(hm);
    }

    public static void main(String[] args) {
//        listImpl();
//        setImpl();
//        treeSetImpl();
        mapEx();
//        hashTableEx();
    }
}
