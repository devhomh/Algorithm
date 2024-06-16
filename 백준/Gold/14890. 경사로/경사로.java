import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int size, length;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer condition = new StringTokenizer(input.readLine());
        size = Integer.parseInt(condition.nextToken());
        length = Integer.parseInt(condition.nextToken());
        map = new int[size][size];
        for (int i = 0; i < size; i++) {
            map[i] = Stream.of(input.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int result = 0;
        for (int i = 0; i < size; i++) {
            int[] verticalClone = new int[size];
            for (int j = 0; j < size; j++) {
                verticalClone[j] = map[j][i];
            }

            if (possible(verticalClone)) {
                result++;
            }

            int[] horizontalClone = map[i].clone();
            if (possible(horizontalClone)) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static boolean possible(int[] arr) {
        boolean[] visit = new boolean[size];
        int current = 0;
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                current = arr[i];
                continue;
            }

            int next = arr[i];
            if (current != next) {
                if (i - length >= 0 && current == next - 1) {
                    for (int j = i - length; j < i; j++) {
                        if(arr[j] != current || visit[j]) {
                            return false;
                        }

                        visit[j] = true;
                    }

                    current = next;
                } else if (i + length - 1< size && current == next + 1) {
                    for (int j = 0; j < length; j++) {
                        if (arr[i + j] != next || visit[i + j]) {
                            return false;
                        }

                        visit[i + j] = true;
                    }

                    current = next;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}