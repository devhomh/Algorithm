import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> queue = new LinkedList<>();

        int lineNum = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < lineNum; i++) {
            String line = br.readLine();

            if (line.startsWith("push")) {
                int num = Integer.parseInt(line.split(" ")[1]);
                queue.offer(num);
            }

            if (line.startsWith("pop")) {
                result.append(queue.isEmpty() ? -1 + "\n" : queue.poll() + "\n");
            }

            if (line.startsWith("size")) {
                result.append(queue.isEmpty() ? 0 + "\n" : queue.size() + "\n");
            }

            if (line.startsWith("empty")) {
                result.append(queue.isEmpty() ? 1 + "\n" : 0 + "\n");
            }

            if (line.startsWith("front")) {
                result.append(queue.isEmpty() ? -1 + "\n" : queue.peek() + "\n");
            }

            if (line.startsWith("back")) {
                result.append(queue.isEmpty() ? -1 + "\n" : queue.peekLast() + "\n");
            }
        }

        System.out.println(result);
    }
}
