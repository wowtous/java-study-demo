package org.darebeat.demo.mapsort;

import java.util.Comparator;
import java.util.Map;

/**
 * Created by darebeat on 9/29/16.
 */
public class ValueComparator implements Comparator {
    Map map;

    public ValueComparator(Map map){
        this.map = map;
    }

    public int compare(Object o1, Object o2) {
        Comparable c1 = (Comparable) map.get(o1);
        Comparable c2 = (Comparable) map.get(o2);
        return c1.compareTo(c2);
    }
}
