import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Station {
        int distance;
        int quantity;

        public Station(int distance, int quantity) {
            this.distance = distance;
            this.quantity = quantity;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());

        StringTokenizer line;
        List<Station> stations = new ArrayList<>();
        boolean[] visit = new boolean[num];
        for (int i = 0; i < num; i++) {
            line = new StringTokenizer(input.readLine());
            int distance = Integer.parseInt(line.nextToken());
            int quantity = Integer.parseInt(line.nextToken());
            stations.add(new Station(distance, quantity));
        }

        stations.sort(Comparator.comparingInt(s -> s.distance));

        line = new StringTokenizer(input.readLine());
        int arrival = Integer.parseInt(line.nextToken());
        int tank = Integer.parseInt(line.nextToken());
        // 첫 지점까지 갈 수 없으면 -1 출력
        if (tank < stations.get(0).distance) {
            System.out.println(-1);
            return;
        }

        int count = 0;
        PriorityQueue<Station> select = new PriorityQueue<>((s1, s2) -> s2.quantity - s1.quantity);
        for (int i = 1; i < num; i++) {
            select.offer(stations.get(i - 1));
            Station next = stations.get(i);
            while (!select.isEmpty() && next.distance > tank) {
                count++;
                tank += select.poll().quantity;
            }

            // 충전했음에도 중간에 다음 주유소 갈 거리보다 연료가 부족하면 -1 출력
            if (next.distance > tank) {
                System.out.println(-1);
                return;
            }
        }

        select.offer(stations.get(num - 1));
        while (!select.isEmpty() && arrival > tank) {
            count++;
            tank += select.poll().quantity;
        }

        // 충전했음에도 중간에 다음 주유소 갈 거리보다 연료가 부족하면 -1 출력
        System.out.println(arrival > tank ? -1 : count);
    }
}