import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int size;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(input.readLine());
        int[][] board = new int[size][size];
        StringTokenizer line;
        for (int i = 0; i < size; i++) {
            line = new StringTokenizer(input.readLine());
            for (int j = 0; j < size; j++) {
                board[i][j] = Integer.parseInt(line.nextToken());
            }
        }

        dfs(0, board);

        System.out.println(result);
    }

    public static void dfs(int depth, int[][] board) {
        if (depth == 5) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    result = Math.max(result, board[i][j]);
                }
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] copy = new int[size][size];
            for (int j = 0; j < size; j++) {
                System.arraycopy(board[j], 0, copy[j], 0, size);
            }
            move(copy, i);
            dfs(depth + 1, copy);
        }
    }

    public static void move(int[][] board, int direction) {
        boolean[][] merged = new boolean[size][size];
        switch (direction) {
            case 0:
                for (int j = 0; j < size; j++) {
                    for (int i = 1; i < size; i++) {
                        if (board[i][j] != 0) {
                            int row = i;
                            while (row > 0 && board[row - 1][j] == 0) {
                                board[row - 1][j] = board[row][j];
                                board[row][j] = 0;
                                row--;
                            }

                            if (row > 0 && board[row - 1][j] == board[row][j] && !merged[row - 1][j]) {
                                board[row - 1][j] *= 2;
                                board[row][j] = 0;
                                merged[row - 1][j] = true;
                            }
                        }
                    }
                }

                break;

            case 1:
                for (int j = 0; j < size; j++) {
                    for (int i = size - 2; i >= 0; i--) {
                        if (board[i][j] != 0) {
                            int row = i;
                            while (row < size - 1 && board[row + 1][j] == 0) {
                                board[row + 1][j] = board[row][j];
                                board[row][j] = 0;
                                row++;
                            }

                            if (row < size - 1 && board[row + 1][j] == board[row][j] && !merged[row + 1][j]) {
                                board[row + 1][j] *= 2;
                                board[row][j] = 0;
                                merged[row + 1][j] = true;
                            }
                        }
                    }
                }

                break;
            case 2:
                for (int i = 0; i < size; i++) {
                    for (int j = 1; j < size; j++) {
                        if (board[i][j] != 0) {
                            int col = j;
                            while (col > 0 && board[i][col - 1] == 0) {
                                board[i][col - 1] = board[i][col];
                                board[i][col] = 0;
                                col--;
                            }

                            if (col > 0 && board[i][col - 1] == board[i][col] && !merged[i][col - 1]) {
                                board[i][col - 1] *= 2;
                                board[i][col] = 0;
                                merged[i][col - 1] = true;
                            }
                        }
                    }
                }

                break;
            case 3:
                for (int i = 0; i < size; i++) {
                    for (int j = size - 2; j >= 0; j--) {
                        if (board[i][j] != 0) {
                            int col = j;
                            while (col < size - 1 && board[i][col + 1] == 0) {
                                board[i][col + 1] = board[i][col];
                                board[i][col] = 0;
                                col++;
                            }

                            if (col < size - 1 && board[i][col + 1] == board[i][col] && !merged[i][col + 1]) {
                                board[i][col + 1] *= 2;
                                board[i][col] = 0;
                                merged[i][col + 1] = true;
                            }
                        }
                    }
                }
        }
    }
}