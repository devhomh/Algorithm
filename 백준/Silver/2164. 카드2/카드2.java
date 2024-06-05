import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= num; i++) {
            queue.offer(i);
        }

        while (queue.size() != 1) {
            queue.poll();
            if (queue.size() == 1) {
                break;
            } else {
                queue.offer(queue.poll());
            }
        }

        System.out.println(queue.poll());
    }
}