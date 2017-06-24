import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

/*
Given string as this "1 2 3 4 5....". reader read this string.
1.Separate elements with a space from str;
2.add all this numbers to head of Linkedlist;
3.remove 3 times the element at index 0;
4.sort the resulting list in ascending order and print all of its elements each on a new line;
Sample Input:
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
Sample Output:
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
 */
public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        //your code
        LinkedList<Integer> ll = new LinkedList<>(Arrays.stream(str.split("\\s")).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList()));
        ll.removeLast();
        ll.removeLast();
        ll.removeLast();
        ll.stream().forEach(System.out::println);
    }
}
