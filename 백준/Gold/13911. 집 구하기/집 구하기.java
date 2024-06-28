import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
    static boolean[] owned;
    static Map<Integer, List<Node>> map = new HashMap<>();
    static int node, macLength, starLength;
    static int result = Integer.MAX_VALUE;
    static StringTokenizer line;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        line = new StringTokenizer(input.readLine());
        node = Integer.parseInt(line.nextToken());
        int vertex = Integer.parseInt(line.nextToken());

        // 지점이 있는 위치인지 체크하는 배열
        owned = new boolean[node + 1];

        // 도로 정보
        for (int i = 0; i < vertex; i++) {
            line = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(line.nextToken());
            int end = Integer.parseInt(line.nextToken());
            int value = Integer.parseInt(line.nextToken());
            map.computeIfAbsent(start, k -> new ArrayList<>()).add(new Node(end, value));
            map.computeIfAbsent(end, k -> new ArrayList<>()).add(new Node(start, value));
        }

        // 맥도날드 정보
        List<Integer> macList = new ArrayList<>();
        line = new StringTokenizer(input.readLine());
        int macNum = Integer.parseInt(line.nextToken());
        macLength = Integer.parseInt(line.nextToken());

        line = new StringTokenizer(input.readLine());
        for (int i = 0; i < macNum; i++) {
            int tmp = Integer.parseInt(line.nextToken());
            owned[tmp] = true;
            macList.add(tmp);
        }

        // 스타벅스 정보
        List<Integer> starList = new ArrayList<>();
        line = new StringTokenizer(input.readLine());
        int startNum = Integer.parseInt(line.nextToken());
        starLength = Integer.parseInt(line.nextToken());

        line = new StringTokenizer(input.readLine());
        for (int i = 0; i < startNum; i++) {
            int tmp = Integer.parseInt(line.nextToken());
            owned[tmp] = true;
            starList.add(tmp);
        }

        // 스타벅스와 맥도날드 지점들에서 모든 가능한 집까지의 최단거리
        int[] macDistance = dijkstra(macList);
        int[] starDistance = dijkstra(starList);

        calculate(macDistance, starDistance);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    public static void calculate(int[] macDistance, int[] starDistance) {
        for (int i = 1; i <= node; i++) {
            // 집을 구할수 있는 위치일 때
            if (!owned[i]) {
                // 맥세권이면서 스세권일 때의 최단거리 계산
                if (macDistance[i] <= macLength && starDistance[i] <= starLength) {
                    result = Math.min(result, macDistance[i] + starDistance[i]);
                }
            }
        }
    }

    // 다익스트라 알고리즘
    // 음의 가중치가 없는 그래프의 노드에서 '각 모든 노드'까지의 최단거리를 구하는 알고리즘
    // 우선순위 큐를 사용한다면 시간 복잡도는 O(N log n)
    public static int[] dijkstra(List<Integer> list) {
        int[] distance = new int[node + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // 거리가 가장 짧은 순으로 정렬한 우선순위 큐
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));

        // 각 지점들의 거리를 초기화 하고 우선순위 큐에 삽입
        for (int index : list) {
            distance[index] = 0;
            priorityQueue.offer(new Node(index, 0));
        }

        boolean[] visited = new boolean[node + 1];
        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();
            int currentDistance = current.distance;
            int currentIndex = current.index;
            if (visited[currentIndex]) continue;
            visited[currentIndex] = true;

            if (map.containsKey(currentIndex)) {
                // 현재 노드에 인접한 노드 리스트
                List<Node> neighbors = map.get(currentIndex);
                for (Node neighbor : neighbors) {
                    // 방문하지 않은 노드일 때
                    if (visited[neighbor.index]) {
                        continue;
                    }

                    int newDist = currentDistance + neighbor.distance;
                    // 해당 노드의 갈 수 있는 최단거리로 갱신
                    if (newDist < distance[neighbor.index]) {
                        distance[neighbor.index] = newDist;
                        priorityQueue.offer(new Node(neighbor.index, newDist));
                    }
                }
            }
        }

        return distance;
    }
}