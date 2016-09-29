package org.darebeat.demo.mapsort;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by darebeat on 9/29/16.
 */
public class MapSort {
    public static Map sortByValue(Map unsortMap){
        Map map = new TreeMap(new ValueComparator(unsortMap));
        map.putAll(unsortMap);
        return map;
    }

    public static Map sortByKey(Map unsortMap){
        Map map = new TreeMap();
        map.putAll(unsortMap);
        return map;
    }
}
