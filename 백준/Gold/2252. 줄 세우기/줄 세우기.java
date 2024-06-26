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

            // 상위 노드가 자신일 때
            if (parent[right] == right) {
                // 앞의 숫자가 뒤의 숫자보다 밸류가 클 때 뒤의 숫자 밸류를 앞의 숫자 밸류보다 높여준다.
                if (arr[left] >= arr[right]) {
                    arr[right] = arr[left] + 1;
                }

                // 앞의 숫자의 상위 노드를 뒤의 숫자로 설정
                parent[left] = right;
            } else {
                increase(right);
            }
        }

        // 밸류가 작은 순으로 우선순위 정렬
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

    // 최상위 노드까지 밸류를 1씩 더해준다.
    public static void increase(int start) {
        arr[start]++;
    
        if (parent[start] != start) {
            increase(parent[start]);
        }
    }
}