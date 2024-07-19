import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer line;
    static int row, column;
    static String[][] board;
    static boolean[][][][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        line = new StringTokenizer(input.readLine());
        row = Integer.parseInt(line.nextToken());
        column = Integer.parseInt(line.nextToken());
        board = new String[row][column];
        visit = new boolean[row][column][row][column];

        // 빨간 공은 0, 1 파란공은 2, 3 카운트는 4;
        int[] arr = new int[5];
        for (int i = 0; i < row; i++) {
            String tmp = input.readLine();
            for (int j = 0; j < column; j++) {
                String type = Character.toString(tmp.charAt(j));
                board[i][j] = type;
                if(type.equals("R")) {
                    arr[0] = i;
                    arr[1] = j;
                }

                if (type.equals("B")) {
                    arr[2] = i;
                    arr[3] = j;
                }
            }
        }

        System.out.println(bfs(arr));
    }

    public static Point move(int dir, int row, int column) {
        int nextRow = row;
        int nextColumn = column;
        while (true) {
            if (board[nextRow][nextColumn].equals("O")) {
                return new Point(nextRow, nextColumn);
            }

            if (board[nextRow][nextColumn].equals("#")) {
                return new Point(nextRow - dx[dir], nextColumn - dy[dir]);
            }

            nextRow += dx[dir];
            nextColumn += dy[dir];
        }
    }

    public static int bfs(int[] arr) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(arr);
        visit[arr[0]][arr[1]][arr[2]][arr[3]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < 4; i++) {
                Point red = move(i, current[0], current[1]);
                Point blue = move(i, current[2], current[3]);

                if (board[blue.x][blue.y].equals("O")) {
                    continue;
                }

                if (board[red.x][red.y].equals("O") && !board[blue.x][blue.y].equals("O")) {
                    return current[4] + 1;
                }

                if (red.x == blue.x && red.y == blue.y) {
                    switch (i) {
                        case 0 :
                            if (current[0] > current[2]) {
                                red = new Point(red.x + 1, red.y);
                            } else {
                                blue = new Point(blue.x + 1, blue.y);
                            }

                            break;
                        case 1 :
                            if (current[0] > current[2]) {
                                blue = new Point(blue.x - 1, blue.y);
                            } else {
                                red = new Point(red.x - 1, red.y);
                            }

                            break;
                        case 2 :
                            if (current[1] > current[3]) {
                                red = new Point(red.x, red.y + 1);
                            } else {
                                blue = new Point(blue.x, blue.y + 1);
                            }

                            break;
                        default:
                            if (current[1] > current[3]) {
                                blue = new Point(blue.x, blue.y - 1);
                            } else {
                                red = new Point(red.x, red.y - 1);
                            }
                    }
                }

                if (!visit[red.x][red.y][blue.x][blue.y]) {
                    visit[red.x][red.y][blue.x][blue.y] = true;
                    queue.offer(new int[]{red.x, red.y, blue.x, blue.y, current[4] + 1});
                }
            }
        }

        return -1;
    }
}