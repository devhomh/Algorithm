import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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

        List<Integer> endTime = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            Point next = priorityQueue.poll();
            boolean isInvolved = false;
            if (endTime.isEmpty()) {
                endTime.add(next.y);
            } else {
                for (int i = 0; i < endTime.size(); i++) {
                    if (next.x >= endTime.get(i)) {
                        isInvolved = true;
                        endTime.remove(i);
                        endTime.add(next.y);
                        break;
                    }
                }

                if (!isInvolved) {
                    endTime.add(next.y);
                }
            }
        }

        System.out.println(endTime.size());
    }
}