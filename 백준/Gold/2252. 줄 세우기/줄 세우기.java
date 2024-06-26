import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Student {
        int value;
        int id;

        public Student(int value, int id) {
            this.value = value;
            this.id = id;
        }
    }
    static int[] arr, parent;
    static StringTokenizer line;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        line = new StringTokenizer(input.readLine());
        int num = Integer.parseInt(line.nextToken());
        int count = Integer.parseInt(line.nextToken());

        arr = new int[num + 1];
        parent = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < count; i++) {
            line = new StringTokenizer(input.readLine());
            int left = Integer.parseInt(line.nextToken());
            int right = Integer.parseInt(line.nextToken());

            if (parent[right] == right) {
                if (arr[left] >= arr[right]) {
                    arr[right] = arr[left] + 1;
                }

                parent[left] = parent[right];
            } else {
                increase(right);
            }
        }

        PriorityQueue<Student> priorityQueue =
                new PriorityQueue<>(Comparator.comparingInt(s -> s.value));
        for (int i = 1; i <= num; i++) {
            priorityQueue.offer(new Student(arr[i], i));
        }

        StringBuilder result = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            result.append(priorityQueue.poll().id).append(" ");
        }

        System.out.println(result);
    }

    public static void increase(int start) {
        arr[start]++;

        if (parent[start] != start) {
            increase(parent[start]);
        }
    }
}