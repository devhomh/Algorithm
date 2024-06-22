import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Unit implements Comparable<Unit>{
        int value;
        int count;

        public Unit(int value, int count) {
            this.value = value;
            this.count = count;
        }

        @Override
        public int compareTo(Unit o) {
            return this.count == o.count
                    ? this.value - o.value
                    : this.count - o.count;
        }
    }
    static StringTokenizer line;
    static Map<Integer, Integer> map;
    static PriorityQueue<Unit> priorityQueue;
    static int[][] matrix;
    static int rowLength = 3;
    static int columnLength = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        line = new StringTokenizer(input.readLine());
        int row = Integer.parseInt(line.nextToken()) - 1;
        int column = Integer.parseInt(line.nextToken()) - 1;
        int target = Integer.parseInt(line.nextToken());

        matrix = new int[100][100];
        for (int i = 0; i < 3; i++) {
            line = new StringTokenizer(input.readLine());
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = Integer.parseInt(line.nextToken());
            }
        }

        int result = 0;
        while (result <= 100 && matrix[row][column] != target) {
            if (rowLength >= columnLength) {
                calR();
            } else {
                calL();
            }

            result++;
        }

        System.out.println(result > 100 ? -1 : result);
    }

    public static void calR() {
        List<Map<Integer, Integer>> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < rowLength; i++) {
            map = new HashMap<>();
            for (int j = 0; j < columnLength; j++) {
                if (matrix[i][j] != 0) {
                    map.put(matrix[i][j], map.getOrDefault(matrix[i][j], 0) + 1);
                }
            }

            list.add(map);
            max = Math.max(max, map.size() * 2);
        }

        columnLength = max;

        for (int i = 0; i < rowLength; i++) {
            map = list.get(i);
            priorityQueue = new PriorityQueue<>();
            map.forEach((key, value) -> priorityQueue.offer(new Unit(key, value)));

            int count = 0;
            while (!priorityQueue.isEmpty() && count <= 99) {
                Unit unit = priorityQueue.poll();
                matrix[i][count++] = unit.value;
                matrix[i][count++] = unit.count;
            }

            while (count <= 99) {
                matrix[i][count++] = 0;
            }
        }
    }

    public static void calL() {
        List<Map<Integer, Integer>> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < columnLength; i++) {
            map = new HashMap<>();
            for (int j = 0; j < rowLength; j++) {
                if (matrix[j][i] != 0) {
                    map.put(matrix[j][i], map.getOrDefault(matrix[j][i], 0) + 1);
                }
            }

            list.add(map);
            max = Math.max(max, map.size() * 2);
        }

        rowLength = max;
        for (int i = 0; i < columnLength; i++) {
            for (int j = 0; j < 100; j++) {
                matrix[j][i] = 0;
            }
        }

        for (int i = 0; i < columnLength; i++) {
            map = list.get(i);
            priorityQueue = new PriorityQueue<>();
            map.forEach((key, value) -> priorityQueue.offer(new Unit(key, value)));

            int count = 0;
            while (!priorityQueue.isEmpty() && count <= 99) {
                Unit unit = priorityQueue.poll();
                matrix[count++][i] = unit.value;
                matrix[count++][i] = unit.count;
            }

            while (count <= 99) {
                matrix[count++][i] = 0;
            }
        }
    }
}