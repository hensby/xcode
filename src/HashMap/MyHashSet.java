package HashMap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

class MyHashSet {
    private List<Integer> list = null;

    /** Initialize your data structure here. */
    public MyHashSet() {
        list = new ArrayList<>();
    }

    public void add(int key) {
        if (!list.contains(key)) {
        list.add(key);
        }
    }

    public void remove(int key) {
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o2.compareTo(o1);
            }
        });
        int l = 0, r = list.size();
        while(l <= r) {
            int mid = ((r - l)>>>1);
            System.out.println(mid);
            if (list.get(mid) > key) {
                r = mid - 1;
            } else if (list.get(mid) < key){
                l = mid + 1;
            } else {
                list.remove(mid);
                break;
            }
        }

    }


    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return list.contains(key);
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        System.out.println(hashSet.list);
        hashSet.add(2);
        System.out.println(hashSet.list);
        System.out.println(hashSet.contains(1));    // returns true
        System.out.println(hashSet.contains(3));    // returns false (not found)
        hashSet.add(2);
        System.out.println(hashSet.list);
        System.out.println(hashSet.contains(2));    // returns true
        hashSet.remove(2);
        System.out.println(hashSet.list);
        System.out.println(hashSet.contains(2));    // returns false (already removed)
        System.out.println(hashSet.list);

    }
}