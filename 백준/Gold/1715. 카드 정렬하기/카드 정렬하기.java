import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < num; i++) {
            priorityQueue.add(Integer.parseInt(input.readLine()));
        }

        if (num == 1) {
            System.out.println(0);
            return;
        }

        int result = 0;
        while (priorityQueue.size() >= 2) {
            int sum = priorityQueue.remove() + priorityQueue.remove();
            result += sum;
            priorityQueue.add(sum);
        }

        System.out.println(result);
    }
}