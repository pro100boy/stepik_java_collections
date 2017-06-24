import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main13 {
    /**
     * Given a list of strings, return a list of the strings, omitting any string length 4 or more.
     * ["a", "bbb", "cccc", "dddddd"] → ["a", "bbb"]
     * Sample Input:
     * its no long string
     * Sample Output:
     * its
     * no
     * @param strings
     * @return
     */
    public static List<String> noLongString(List<String> strings) {
        return strings.stream().filter(s -> s.length() < 4).collect(Collectors.toList());
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //lets go
        System.out.println(noLongString(Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList())));
    }
}
