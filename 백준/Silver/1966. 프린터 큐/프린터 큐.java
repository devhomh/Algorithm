import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            Queue<int[]> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++) {
                int importance = Integer.parseInt(st.nextToken());
                list.add(importance);
                queue.offer(new int[]{j, importance});
            }

            list = list.stream()
                    .sorted(Collections.reverseOrder())
                    .collect(Collectors.toList());
            int count = 0;

            for (int j = 0; j < num; j++) {
                while (Objects.nonNull(queue.peek()) && list.get(0) != queue.peek()[1]) {
                    queue.offer(queue.poll());
                }

                list.remove(0);
                int[] arr = queue.poll();
                count++;

                if (Objects.nonNull(arr) && arr[0] == index) {
                    break;
                }
            }

            result.append(count).append("\n");
        }

        System.out.println(result);
    }
}