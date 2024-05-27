import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num; i++) {
            int command = Integer.parseInt(input.readLine());
            if (command == 0) {
                if (priorityQueue.isEmpty()) {
                    result.append(0).append("\n");
                } else {
                    result.append(priorityQueue.remove()).append("\n");
                }
            } else {
                priorityQueue.add(command);
            }
        }

        System.out.println(result);
    }
}