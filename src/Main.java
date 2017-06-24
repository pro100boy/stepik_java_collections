import java.util.Arrays;
import java.util.List;

public class Main {

    public static Integer maxElem(List<Integer> list){
        //enter your code
        int max = list.stream().max(Integer::compareTo).get();
        return max;
    }

    /*
    find the longest string in list
     -if you use method max of class Collections : don't forget to implement a comparator for this method
       Collections.max(list, (s1,s2)->{...})
       by default, this method compares strings alphabetically!
    -of course you can use other approaches(for example comparison in a for-loop)
    replace all list items with this row
    return modified list
     */
    static List<String> changeList(List<String> list){
        //paste your code here
        String s = list.stream().sorted((e1, e2) -> e1.length() > e2.length() ? -1 : 1).findFirst().get();
        list.replaceAll(e->s);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(changeList(Arrays.asList("qwrq", "aaaaaa", "bbb")));
    }
}
