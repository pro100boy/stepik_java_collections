import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
/*
2.Next, using ListIterator remove all items not starting with J and items beginning with J replace with the same elements but without the J ,for example JFrame -> Frame
Sample Input:
ImageButton JTextField JTextArea CheckBox JMenu

Sample Output:
Menu
TextArea
TextField
 */
public class Main9 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //lets go
        List<String> list = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());

        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext())
        {
            String s = listIterator.next();
            if (!s.startsWith("J")) listIterator.remove(); else listIterator.set(s.replaceFirst("J",""));
        }
        while (listIterator.hasPrevious())
            System.out.println(listIterator.previous());
    }
}
