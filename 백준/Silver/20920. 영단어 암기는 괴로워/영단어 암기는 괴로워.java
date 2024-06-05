import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer condition = new StringTokenizer(input.readLine());
        int num = Integer.parseInt(condition.nextToken());
        int length = Integer.parseInt(condition.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < num; i++) {
            String word = input.readLine();
            if (word.length() >= length) {
                map.put(word, map.getOrDefault(word, 1) + 1);
            }
        }

        PriorityQueue<String> priorityQueue = new PriorityQueue<>(
                (s1, s2) -> Objects.equals(map.get(s1), map.get(s2))
                        ? s1.length() == s2.length()
                            ? s1.compareTo(s2)
                            : s2.length() - s1.length()
                        : map.get(s2) - map.get(s1));
        for (String word : map.keySet()) {
            priorityQueue.offer(word);
        }

        StringBuilder result = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            result.append(priorityQueue.poll()).append("\n");
        }

        System.out.println(result);
    }
}