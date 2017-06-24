import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main11 {
    /*
    Modify and return the given map as follows: if the key "a" has a value, set the key "b" to have that same value. In all cases remove the key "c",leaving the rest of the map unchanged.
    {"a":"abstraction","b":"boolean","c":"xyz"} -> {"a":"abstraction","b":"abstraction"}
    Sample Input:
    a:Abstraction,b:Boolean,c:xyz
    Sample Output:
    a : Abstraction
    b : Abstraction
     */
    public static Map<String, String> mapShare(Map<String, String> map) {
        String aValue = map.getOrDefault("a", null);

        if (!Objects.isNull(aValue) && map.containsKey("b") && map.containsKey("c")) {
            map.put("b", aValue);
            map.remove("c");
        }
        return map;
    }

    /*
    Given an array of strings,

    On wordCount() : return a SortedMap<String, Integer> with a key for each different string, with the value the number of times that string appears in the array.

    On printMap(): Using System.out.println() print all items of the Map ("key : value")

    Sample Input:
    a b b c d a b

    Sample Output:
    a : 2
    b : 3
    c : 1
    d : 1
     */
    public static SortedMap<String, Integer> wordCount(String[] strings) {
        SortedMap<String, Integer> map = new TreeMap<>(Comparator.naturalOrder());
        for (String s : strings)
            map.compute(s, (string, integer) -> (integer == null) ? 1 : ++integer);

        return map;
    }

    public static void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> m : map.entrySet()){
            System.out.printf("%s : %d%n", m.getKey(), m.getValue());
        }
    }

    public static void main(String[] args) throws IOException {
        Map<String, String> map = new HashMap() {{
            put("a", "Abstraction");
            put("b", "Boolean");
            put("c", "xyz");
            put("b1", "sdhfdoolean");
        }};
        System.out.println(mapShare(map));

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        printMap(wordCount(reader.readLine().split(" ")));
    }
}
