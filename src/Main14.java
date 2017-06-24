import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/*
Given string as "JButton Button JMenu..." to stdin of your programm

Add all elements from this string to List<String>
Next, using Stream API remove all items not starting with J and items beginning with J replace with the same elements but without the J ,for example JFrame -> Frame
next, print all the remaining elements in reverse order(using .println())
*in the lesson ListIterator. set() it was necessary to perform the same logic ,but using ListIterator. You can compare these 2 solutions

Sample Input:
ImageButton JTextField JTextArea CheckBox JMenu
Sample Output:
Menu
TextArea
TextField
 */
public class Main14 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //lets go
        List<String> list = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());

        list.stream()
                .filter(s -> s.startsWith("J"))
                .map(s -> s.replaceFirst("J", ""))
                .collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator().forEachRemaining(System.out::println);
    }
}
