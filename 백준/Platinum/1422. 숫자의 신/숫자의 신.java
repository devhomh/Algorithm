import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(input.readLine());
        int num = Integer.parseInt(line.nextToken());
        int pick = Integer.parseInt(line.nextToken());

        PriorityQueue<String> cards = new PriorityQueue<>(
                (o1, o2) -> Integer.parseInt(o2) - Integer.parseInt(o1));
        for (int i = 0; i < num; i++) {
            cards.offer(input.readLine());
        }

        PriorityQueue<String> combination = new PriorityQueue<>(
                (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        while (pick != 0) {
            if (!cards.isEmpty()) {
                String card = cards.poll();
                combination.offer(card);
                pick--;
                if (pick > cards.size()) {
                    cards.offer(card);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while (!combination.isEmpty()) {
            result.append(combination.poll());
        }

        System.out.println(result);
    }
}