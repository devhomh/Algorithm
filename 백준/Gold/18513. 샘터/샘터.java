import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static class Fountain {
        int location;
        int distance;

        public Fountain(int location, int distance) {
            this.location = location;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(input.readLine());
        int fountainNum = Integer.parseInt(line.nextToken());
        int homeNum = Integer.parseInt(line.nextToken());

        // 샘물의 위치 기록
        int[] fountains = Stream.of(input.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 샘의 위치와 집의 위치를 기록할 Set 에 샘의 위치를 넣고 BFS 를 돌리기 위해 Queue 에 삽입
        Set<Integer> exist = new HashSet<>();
        Queue<Fountain> queue = new LinkedList<>();
        for (int i = 0; i < fountainNum; i++) {
            int location = fountains[i];
            exist.add(location);
            queue.offer(new Fountain(location, 1));
        }


        long unhappiness = 0;
        while (!queue.isEmpty() && homeNum != 0) {
            Fountain fountain = queue.poll();
            int location = fountain.location;
            int distance = fountain.distance;
            for (int i = 0; i < 2; i++) {
                int next = i == 0
                        ? location + 1
                        : location - 1;

                if (!exist.contains(next)) {
                    exist.add(next);
                    unhappiness += distance;
                    homeNum--;
                    queue.offer(new Fountain(next, distance + 1));
                }

                if (homeNum == 0) {
                    break;
                }
            }
        }

        System.out.println(unhappiness);
    }
}