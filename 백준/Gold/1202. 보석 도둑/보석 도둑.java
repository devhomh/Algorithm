import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Jewelry {
        int weight;
        int price;

        public Jewelry(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(input.readLine());
        int jewelNum = Integer.parseInt(line.nextToken());
        int bagNum = Integer.parseInt(line.nextToken());

        PriorityQueue<Jewelry> jewelries = new PriorityQueue<>(
                (o1, o2) -> o1.weight == o2.weight
                        ? o2.price - o1.price
                        : o1.weight - o2.weight);
        for (int i = 0; i < jewelNum; i++) {
            line = new StringTokenizer(input.readLine());
            int weight = Integer.parseInt(line.nextToken());
            int price = Integer.parseInt(line.nextToken());
            jewelries.add(new Jewelry(weight, price));
        }

        int[] bags = new int[bagNum];
        for (int i = 0; i < bagNum; i++) {
            bags[i] = Integer.parseInt(input.readLine());
        }

        Arrays.sort(bags);
        long totalPrice = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int bag : bags) {
            while (!jewelries.isEmpty() && jewelries.peek().weight <= bag) {
                priorityQueue.add(jewelries.poll().price);
            }

            if (!priorityQueue.isEmpty()) {
                totalPrice += priorityQueue.poll();
            }
        }

        System.out.println(totalPrice);
    }
}