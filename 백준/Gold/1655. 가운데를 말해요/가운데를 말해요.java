import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());

        StringBuilder result = new StringBuilder();
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        for (int i = 0; i < num; i++) {
            int tmp = Integer.parseInt(input.readLine());
            if (left.size() == right.size()) {
                left.add(tmp);
            } else {
                right.add(tmp);
            }

            if (!left.isEmpty() && !right.isEmpty()) {
                if (left.peek() > right.peek()) {
                    left.add(right.poll());
                    right.add(left.poll());
                }
            }

            result.append(left.peek()).append("\n");
        }

        System.out.println(result);
    }
}