import java.io.IOException;
import java.util.*;

/*
On spliteratorWork( List<Double> lst ):
-using Spliterator add to List<Double> sqrts all square roots of items from lst ,if this item greater than 1
-use Math.sqrt(number) to find square root : Math.sqrt(4)-> 2.0
On print(List<Double> list):
-get spliterator() of given list
-divide spliterator into 2 parts ( use spliterator.trySplit())
-print all items which >=2 from first part (use .println())
-print empty string
-print all items which >=10 from second part (use .println())
*! remember when you use trySplit() method :
List<Integer> lst = new ArrayList<>(Arrays.asList(1,1,1,2,2,2,2));

Spliterator<Integer> split = lst.spliterator();
split.trySplit()...//-> 1 1 1 (its your first path of spliterator)
split...//2 2 2 2 (now split contains of second path)
Sample Input:
4 4 4 100 100 100
Sample Output:
2.0
2.0
2.0

10.0
10.0
10.0
 */
public class Main10 {
    public static List<Double> spliteratorWork(List<Double> lst) {
        List<Double> sqrs = new ArrayList<>();
        Spliterator<Double> spliterator = lst.spliterator();
        //Spliterator<Double> spliterator2 = spliterator.trySplit();
        // Check if splitting actually happened, then use it
        /*if(spliterator2 != null){
            while(spliterator2.tryAdvance((n) -> sqrs.add(Math.sqrt(n))));
        }*/
        // Original spliterator
        spliterator.forEachRemaining(
                (n) ->
                {
                    if (n > 1) sqrs.add(Math.sqrt(n));
                });

        return sqrs;
    }

    public static void print(List<Double> list) {
        Spliterator<Double> spliterator = list.spliterator();
        Spliterator<Double> spliterator2 = spliterator.trySplit();

        while (spliterator2.tryAdvance((n) -> {
            if (n >= 2) System.out.println(n);
        }));

        System.out.println();

        if (spliterator != null) {
            while (spliterator.tryAdvance((n) -> {
                if (n >= 10) System.out.println(n);
            }));
        }
    }

    public static void main(String[] args) throws IOException {
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //lets go
        List<Double> list = spliteratorWork(Arrays.stream(reader.readLine().split(" ")).mapToDouble(Double::valueOf).boxed().collect(Collectors.toList()));
        print(list);*/

        Queue<String> queue = new PriorityQueue<>();
        queue.offer("a");
        queue.offer("c");
        queue.offer("b");

        String name = queue.peek(); //a     acb
        String name1 = queue.poll(); //a    cb
        String name2 = queue.poll(); // b   c
        queue.offer(name); //ac

        queue.forEach(System.out::print);

        Deque<String> states = new ArrayDeque<String>();
        states.add("Germany");      // in tail
        states.add("France");       // in tail
        states.push("UK");      //  in head
        states.offerLast("Norway"); // in tail

        String sFirst = states.pop(); // head
        String s = states.peek();       // head
        String sLast = states.peekLast(); // last
        states.offer(sFirst);   // tail
        String s1 = states.pollLast(); // tail


        while (states.peek() != null) {
            System.out.print(states.pop());
        }
    }
}

