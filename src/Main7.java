import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main7 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //lets go
        List<Integer> list = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::valueOf).boxed().filter(i -> i % 2 != 0).sorted().collect(Collectors.toList());
        list.stream().forEach(System.out::println);
    }
}
