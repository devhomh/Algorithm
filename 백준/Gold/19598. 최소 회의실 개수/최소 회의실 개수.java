import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static StringTokenizer line;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        PriorityQueue<Point> priorityQueue = new PriorityQueue<>(
                (p1, p2) -> p1.x == p2.x ? p1.y - p2.y : p1.x - p2.x);
        for (int i = 0; i < num; i++) {
            line = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(line.nextToken());
            int end = Integer.parseInt(line.nextToken());

            priorityQueue.offer(new Point(start, end));
        }

        PriorityQueue<Integer> endTime = new PriorityQueue<>();
        while (!priorityQueue.isEmpty()) {
            Point next = priorityQueue.poll();
            if (endTime.isEmpty()) {
                endTime.offer(next.y);
            } else {
                if (endTime.peek() <= next.x) {
                    endTime.poll();
                }
                
                endTime.offer(next.y);
            }
        }

        System.out.println(endTime.size());
    }
}