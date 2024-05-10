import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static ArrayList<Point> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <9; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 0) {
                    list.add(new Point(i, j));
                }

                board[i][j] = num;
            }
        }

        dfs(0);
    }

    public static void dfs(int depth) {
        if (depth == list.size()) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    result.append(board[i][j]).append(" ");
                }
                result.append("\n");
            }

            System.out.println(result);
            System.exit(0);
        }

        for (int i = 1; i <= 9; i++) {
            if (isPossible(depth, i)) {
                board[list.get(depth).x][list.get(depth).y] = i;
                dfs(depth + 1);
                board[list.get(depth).x][list.get(depth).y] = 0;
            }
        }
    }

    public static boolean isPossible(int index, int num) {
        int row = list.get(index).x;
        int column = list.get(index).y;

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][column] == num) {
                return false;
            }
        }

        int squareRow = (row / 3) * 3;
        int squareColumn = (column / 3) * 3;
        for (int i = squareRow; i < squareRow + 3; i++) {
            for (int j = squareColumn; j < squareColumn + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}