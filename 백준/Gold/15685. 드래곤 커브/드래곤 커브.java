import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        board = new boolean[101][101];
        StringTokenizer line;
        for (int i = 0; i < num; i++) {
            line = new StringTokenizer(input.readLine());
            int column = Integer.parseInt(line.nextToken());
            int row = Integer.parseInt(line.nextToken());
            int dir = Integer.parseInt(line.nextToken());
            int generation = Integer.parseInt(line.nextToken());

            draw(row, column, dir, generation);
        }

        int result = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (isSquare(i, j)) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    public static void draw(int row, int column, int dir, int generation) {
        List<Integer> list = new ArrayList<>();
        list.add(dir);

        for (int i = 1; i <= generation; i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                list.add((list.get(j) + 1) % 4);
            }
        }


        board[row][column] = true;
        for (int direction : list) {
            row += dx[direction];
            column += dy[direction];
            board[row][column] = true;
        }
    }

    public static boolean isSquare(int row, int column) {
            return board[row][column]
                    && board[row + 1][column]
                    && board[row][column + 1]
                    && board[row + 1][column + 1];
    }
}