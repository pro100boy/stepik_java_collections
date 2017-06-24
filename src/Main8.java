import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class Main8 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //lets go
        List<String> list = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());

        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext())
        {
            String s = listIterator.next();
            System.out.println(!s.equalsIgnoreCase("Hip") ? s : s.concat("\nHop"));
        }
    }
}
