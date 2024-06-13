import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int row, column;
    static Point hole;
    static String[][] board;
    static boolean[][][][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer condition = new StringTokenizer(input.readLine());
        row = Integer.parseInt(condition.nextToken());
        column = Integer.parseInt(condition.nextToken());
        visit = new boolean[row][column][row][column];
        board = new String[row][column];
        int[] start = new int[5];
        for (int i = 0; i < row; i++) {
            String line = input.readLine();
            for (int j = 0; j < column; j++) {
                String element = Character.toString(line.charAt(j));
                if (element.equals("O")) {
                    hole = new Point(i, j);
                }

                if (element.equals("R")) {
                    start[0] = i;
                    start[1] = j;
                }

                if (element.equals("B")) {
                    start[2] = i;
                    start[3] = j;
                }

                board[i][j] = element;
            }
        }

        System.out.println(bfs(start));
    }

    public static int bfs(int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        start[4] = 1;
        queue.add(start);
        visit[start[0]][start[1]][start[2]][start[3]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[4] > 10) {
                return -1;
            }

            for (int i = 0; i < 4; i++) {
                int redRow = current[0];
                int redColumn = current[1];
                int blueRow = current[2];
                int blueColumn = current[3];
                boolean passRed = false;
                boolean passBlue = false;

                while (!board[redRow + dx[i]][redColumn + dy[i]].equals("#")) {
                    redRow += dx[i];
                    redColumn += dy[i];

                    if (redRow == hole.x && redColumn == hole.y) {
                        passRed = true;
                        break;
                    }
                }

                while (!board[blueRow + dx[i]][blueColumn + dy[i]].equals("#")) {
                    blueRow += dx[i];
                    blueColumn += dy[i];

                    if (blueRow == hole.x && blueColumn == hole.y) {
                        passBlue = true;
                        break;
                    }
                }

                if (passBlue) {
                    continue;
                }

                if (passRed && !passBlue) {
                    return current[4];
                }


                if(redRow == blueRow && redColumn == blueColumn) {
                    if (i == 0) {
                        if (current[0] > current[2]) {
                            redRow -= dx[i];
                        } else {
                            blueRow -= dx[i];
                        }
                    } else if (i == 1) {
                        if (current[0] > current[2]) {
                            blueRow -= dx[i];
                        } else {
                            redRow -= dx[i];
                        }
                    } else if (i == 2) {
                        if (current[1] > current[3]) {
                            redColumn -= dy[i];
                        } else {
                            blueColumn -= dy[i];
                        }
                    } else {
                        if (current[1] > current[3]) {
                            blueColumn -= dy[i];
                        } else {
                            redColumn -= dy[i];
                        }
                    }
                }

                if (!visit[redRow][redColumn][blueRow][blueColumn]) {
                    visit[redRow][redColumn][blueRow][blueColumn] = true;
                    queue.add(new int[] {redRow, redColumn, blueRow, blueColumn, current[4] + 1});
                }
            }
        }

        return -1;
    }
}