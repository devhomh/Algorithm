import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(input.readLine());
        size = Integer.parseInt(line.nextToken());
        int min = Integer.parseInt(line.nextToken());
        int max = Integer.parseInt(line.nextToken());
        int[][] land = new int[size][size];
        for (int i = 0; i < size; i++) {
            land[i] = Stream.of(input.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int result = 0;
        while (true) {
            boolean end = true;
            boolean[][] visit = new boolean[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (!visit[i][j]) {
                        int sum = 0;
                        List<Point> union = new ArrayList<>();
                        Queue<Point> queue = new LinkedList<>();
                        visit[i][j] = true;
                        queue.add(new Point(i, j));
                        union.add(new Point(i, j));
                        sum += land[i][j];
                        while (!queue.isEmpty()) {
                            Point current = queue.poll();
                            for (int k = 0; k < 4; k++) {
                                int nextRow = current.x + dx[k];
                                int nextColumn = current.y + dy[k];

                                if (!isInRange(nextRow, nextColumn)) {
                                   continue;
                                }

                                if (!visit[nextRow][nextColumn]) {
                                    int dif = Math.abs(land[current.x][current.y] - land[nextRow][nextColumn]);
                                    if (dif >= min && dif <= max) {
                                        end = false;
                                        visit[nextRow][nextColumn] = true;
                                        queue.add(new Point(nextRow, nextColumn));
                                        union.add(new Point(nextRow, nextColumn));
                                        sum += land[nextRow][nextColumn];
                                    }
                                }
                            }
                        }

                        if (union.size() > 1) {
                            int avg = sum / union.size();
                            for (Point country : union) {
                                land[country.x][country.y] = avg;
                            }
                        }
                    }
                }
            }

            if (end) {
                break;
            } else {
                result++;
            }
        }

        System.out.println(result);
    }

    public static boolean isInRange(int row, int column) {
        return row >= 0 && column >= 0 && row < size && column < size;
    }
}