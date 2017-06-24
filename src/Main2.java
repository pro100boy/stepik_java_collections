import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String allElements = reader.readLine();
        List<Integer> bigList = createBigList(allElements);

        ArrayList<Integer> div2list = new ArrayList<>();
        ArrayList<Integer> div3list = new ArrayList<>();
        ArrayList<Integer> otherlist = new ArrayList<>();

        //add the necessary elements from bigList to div2list,div3list,otherlist and sort all three lists
        for (Integer i : bigList) {
            int c = (i % 2 == 0 && i % 3 == 0) ? 0 : (i % 2 == 0 ? 1 : (i % 3 == 0 ? 2 : 3));
            switch (c) {
                case 0:
                    div2list.add(i);
                    div3list.add(i);
                    break;
                case 3:
                    otherlist.add(i);
                    break;
                case 2:
                    div3list.add(i);
                    break;
                case 1:
                    div2list.add(i);
                    break;
            }
        }
        //get result list from createListOfLists
        List<List<Integer>> resultList = createListOfLists(div2list, div3list, otherlist);

        //call printInLine() for resultList
        printInLine(resultList);
    }

    public static List<Integer> createBigList(String str) {
        return Arrays.stream(str.split("\\s")).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());
    }

    public static List<List<Integer>> createListOfLists(List<Integer> div2list, List<Integer> div3list, List<Integer> otherList) {
        //add all lists like items in resultList(list of lists) and return it, first-div2list, second-div3list, third-otherList
        return new ArrayList() {
            {
                add(div2list.stream().sorted(Integer::compareTo).collect(Collectors.toList()));
                add(div3list.stream().sorted(Integer::compareTo).collect(Collectors.toList()));
                add(otherList.stream().sorted(Integer::compareTo).collect(Collectors.toList()));
            }
        };
    }

    public static void printInLine(List<List<Integer>> resultList) {
        System.out.println(resultList);
    }
}
