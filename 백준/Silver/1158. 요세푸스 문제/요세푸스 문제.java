import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int num = Integer.parseInt(line[0]);
        int term = Integer.parseInt(line[1]);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= num; i++) {
            queue.offer(i);
        }

        StringBuilder result = new StringBuilder();
        result.append("<");

        while (queue.size() != 1) {
            for (int i = 0; i < term - 1; i++) {
                queue.offer(queue.poll());
            }

            result.append(queue.poll()).append(", ");
        }

        result.append(queue.poll()).append(">");

        System.out.println(result);
    }
}