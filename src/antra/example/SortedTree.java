package antra.example;

import java.util.Comparator;

public class SortedTree implements Comparator {
    @Override
    public int compare(Object o1, Object o2) { // cuz other method will take care by super object class
        Integer obj1 = (Integer) o1;
        Integer obj2 = (Integer) o2;

        if(obj1 < obj2) return 1;
        else if(obj1 > obj2) return -1;
        else return 0;
    }
}
