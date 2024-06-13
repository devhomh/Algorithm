import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int size, result, dir;
    static Deque<Point> snake = new LinkedList<>();
    static boolean[][] board, map;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(input.readLine());
        map = new boolean[size][size];
        board = new boolean[size][size];

        int appleNum = Integer.parseInt(input.readLine());
        StringTokenizer line;
        for (int i = 0; i < appleNum; i++) {
            line = new StringTokenizer(input.readLine());
            int row = Integer.parseInt(line.nextToken());
            int column = Integer.parseInt(line.nextToken());
            map[row - 1][column - 1] = true;
        }

        board[0][0] = true;
        snake.add(new Point(0, 0));
        int cmdNum = Integer.parseInt(input.readLine());
        for (int i = 0; i < cmdNum; i++) {
            line = new StringTokenizer(input.readLine());
            int second = Integer.parseInt(line.nextToken());
            String cmd = line.nextToken();

            process(second, cmd);
        }

        while (true) {
            result++;
            Point head = snake.peek();
            if (isOver(head)) {
                System.out.println(result);
                return;
            }

            int row = head.x + dx[dir];
            int column = head.y + dy[dir];
            if (map[row][column]) {
                snake.offerFirst(new Point(row, column));
                board[row][column] = true;
                map[row][column] = false;
            } else {
                move();
            }
        }
    }

    public static void process(int second, String cmd) {
        // second 만큼 현재 방향으로 이동
        while (result != second && !snake.isEmpty()) {
            result++;
            Point head = snake.peek();
            if (isOver(head)) {
                System.out.println(result);
                System.exit(0);
            }

            int row = head.x + dx[dir];
            int column = head.y + dy[dir];
            if (map[row][column]) {
                snake.offerFirst(new Point(row, column));
                board[row][column] = true;
                map[row][column] = false;
            } else {
                move();
            }
        }

        // 방향 틀기
        if (cmd.equals("L")) {
            dir = dir == 0 ? 3 : dir - 1;
        } else {
            dir = dir == 3 ? 0 : dir + 1;
        }
    }

    public static void move() {
        if (!snake.isEmpty()) {
            Point head = snake.peek();
            snake.offerFirst(new Point(head.x + dx[dir], head.y + dy[dir]));
            board[head.x + dx[dir]][head.y + dy[dir]] = true;
        }

        Point tail = snake.pollLast();
        board[tail.x][tail.y] = false;
    }

    public static boolean isOver(Point head) {
        int row = head.x + dx[dir];
        int column = head.y + dy[dir];
        return !isInRange(row, column) || board[row][column];
    }

    public static boolean isInRange(int row, int column) {
        return row >= 0 && column >= 0 && row < size && column < size;
    }
}