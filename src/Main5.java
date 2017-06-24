import java.util.*;

public class Main5 {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(3, 14, 16, 5, 13, 2, 20, 10, 6, 9));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18, 20));
        System.out.println(symDifference(set1, set2));
    }

    public static Set<Integer> symDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> set = new HashSet<>(set1);
        set.addAll(set2);

        Set<Integer> tmp = new HashSet<>(set1);
        tmp.retainAll(set2);
        set.removeAll(tmp);
        return set;
    }
}
