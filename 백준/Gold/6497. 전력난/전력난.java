import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Road {
        int left;
        int right;
        int length;

        public Road(int left, int right, int length) {
            this.left = left;
            this.right = right;
            this.length = length;
        }
    }
    static int homeNum, roadNum;
    static int[] arr;
    static StringTokenizer line;
    static List<Road> list;

    // 최소 신장 트리 (Minimum Spanning Tree)
    // Spanning Tree 중에서 사용된 간선들의 가중치 합이 최소인 트리
    // MST 구현 방법은 주로 크러스컬 알고리즘 (Kruskal Algorithm), 프림 알고리즘 사용 (Prim Algorithm)
    // 시간 복잡도는 크러스컬의 경우 O(NlogN), 프림의 경우는 O(N^2)
    // 그래프 내의 적은 간선을 가지는 희소 그래프는 (Sparse Graph) 경우 크러스컬이 적합
    // 반면 간선이 많이 존재하는 밀집 그래프 (Dense Graph) 경우, 프림이 적합
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String condition = input.readLine();
        while (!condition.equals("0 0")) {
            line = new StringTokenizer(condition);
            homeNum = Integer.parseInt(line.nextToken());
            roadNum = Integer.parseInt(line.nextToken());
            arr = new int[homeNum];
            for (int i = 0; i < homeNum; i++) {
                arr[i] = i;
            }
            list = new ArrayList<>();
            for (int i = 0; i < roadNum; i++) {
                line = new StringTokenizer(input.readLine());
                int left = Integer.parseInt(line.nextToken());
                int right = Integer.parseInt(line.nextToken());
                int length = Integer.parseInt(line.nextToken());
                list.add(new Road(left, right, length));
            }

            System.out.println(maxSavings());
            condition = input.readLine();
        }
    }

    // 크러스컬 알고리즘
    // 그리디 알고리즘 (Greedy Algorithm)을 이용하여 MST 를 구하는 것.
    public static int maxSavings() {
        int max = 0;
        // 길이 기준으로 오름차순으로 정렬
        list.sort(Comparator.comparingInt(r -> r.length));
        for (Road road : list) {
            // 각 노드의 부모가 다르다면 합치고 이미 같은 부모를 갖고 있으면 전등 끄기
            if (find(road.left) != find(road.right)) {
                union(road);
            } else {
                max += road.length;
            }
        }

        return max;
    }

    public static void union(Road road) {
        arr[find(road.right)] = find(road.left);
    }

    public static int find(int index) {
        if (arr[index] == index) {
            return index;
        }

        return arr[index] = find(arr[index]);
    }
}