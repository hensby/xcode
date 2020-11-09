package antra.example;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ColleactionEx {

    public static void listImpl() {
//        ArrayList<Integer> a = new ArrayList<>(); // Object array ds// allow duplicate
//        Vector<Integer> a = new Vector<>(); // Resizeable array Data Structure, synchronized class
//        Stack<Integer> a = new Stack<>(); // LIFO synchronized class
        LinkedList<Integer> a = new LinkedList<>(); // double linked list
        a.add(11);
        a.add(23);
        a.add(34);
        a.add(93);

        // a.remove(11); // cannot work only can remove(Object) / remove(index)
        a.remove((Integer) 11);

//        for(int i: a) {
//            System.out.println(i);
//        }
        Iterator it = a.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println(a);
        List li = Collections.unmodifiableList(a); // unmodifiable cannot modify
        li.add(222);
    }

    public static void setImpl() {
//        HashSet<Object> hs = new HashSet<>(); // don't have duplicate // disordered // hashtable ds
        LinkedHashSet hs = new LinkedHashSet<>(); // ordered // linked list and hashtable ds
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
        TreeSet hs = new TreeSet<>(); // sorted follow balance tree DE
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
        HashMap hm = new HashMap(); // key cannot be duplicate // is unordered // hashtable DS
//        LinkedHashMap hm = new LinkedHashMap(); // in order // hashtable + LinkedList DS
//        ConcurrentHashMap hm = new ConcurrentHashMap(); // onetime, synchronized
        hm.put(1, "whc");
        hm.put(2, "henry");
        hm.put(3, "rick");
        hm.put(new Person("tom"), "new person");
//        hm.put(null, "ddd");   // support
//        hm.remove(null);
        System.out.println(hm);

        Set set = hm.keySet();
        Iterator it = set.iterator();
        while(it.hasNext()) {
            System.out.println(hm.get(it.next()));
            hm.put(99, "derrick");
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
//        System.out.println("4321".hashCode());
    }
}
