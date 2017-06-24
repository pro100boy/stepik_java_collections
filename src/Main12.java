import java.util.Comparator;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Main12 {
    /**
     * Modify and return the given map as follows:
     * if the first key % 2 != 0 return sub map from First Key inclusive to FirstKey+4 inclusive in descending order
     * else return sub map from LastKey-4 inclusive to the Last Key inclusive in descending order
     * Sample Input:
     * 1:one 2:two 3:three 4:four 5:five 6:six 7:seven
     * Sample Output:
     * 5 : five
     * 4 : four
     * 3 : three
     * 2 : two
     * 1 : one
     *
     * @param map
     */
    public static NavigableMap<Integer, String> getSubMap(NavigableMap<Integer, String> map) {
        Integer fKey = map.firstKey();
        NavigableMap<Integer, String> newMap = new TreeMap<>(Comparator.reverseOrder());
        if (fKey % 2 != 0)
            newMap.putAll(map.subMap(fKey, fKey + 5));
        else
            newMap.putAll(map.subMap(map.lastKey() - 4, map.lastKey()+1));
        return newMap;
    }

    public static void main(String[] args) {
        NavigableMap<Integer, String> map = new TreeMap(){
            {
                put(0, "zero");
                put(1, "one");
                put(2, "two");
                put(3, "three");
                put(4, "four");
                put(5, "five");
                put(6, "six");
                put(7, "seven");
            }
        };
        System.out.println(getSubMap(map));
    }
}
