import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());

        StringTokenizer line;
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            line = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(line.nextToken());
            int end = Integer.parseInt(line.nextToken());
            
            list.add(new Point(start, end));
        }
        list.sort((o1, o2) -> o1.y == o2.y ?
                o1.x - o2.x
                : o1.y - o2.y);
        
        int count = 1;
        Point current = list.get(0);
        for (int i = 1; i < num; i++) {
            Point next = list.get(i);
            if (current.y <= next.x) {
                count++;
                current = next;
            }
        }

        System.out.println(count);
    }
}