package org.darebeat.demo.mapsort;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by darebeat on 9/29/16.
 */
public class App {
    public static void main(String[] args) {
        Map map = new HashMap();

        map.put("d","9");
        map.put("w","8");
        map.put("a","1");
        map.put("f","4");
        map.put("h","6");
        map.put("h","2");

        System.out.println("Unsorted Map: "+map);
        System.out.println("Sorted Map By Values: "+MapSort.sortByValue(map));
        System.out.println("Sorted Map By Keys: "+MapSort.sortByKey(map));
    }
}
