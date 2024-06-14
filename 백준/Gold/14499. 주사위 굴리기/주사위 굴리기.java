import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Dice {
        int[] arr;

        public Dice() {
            this.arr = new int[6];
        }

        public int getBottom() {
            return arr[5];
        }

        public int getTop() {
            return arr[2];
        }
        public void setBottom(int num) {
            arr[5] = num;
        }

        public void move(int dir) {
            int tmp = arr[5];
            switch (dir) {
                case 0 :
                    arr[5] = arr[3];
                    arr[3] = arr[2];
                    arr[2] = arr[1];
                    arr[1] = tmp;
                    break;
                case 1 :
                    arr[5] = arr[1];
                    arr[1] = arr[2];
                    arr[2] = arr[3];
                    arr[3] = tmp;
                    break;
                case 2 :
                    arr[5] = arr[4];
                    arr[4] = arr[2];
                    arr[2] = arr[0];
                    arr[0] = tmp;
                    break;
                case 3 :
                    arr[5] = arr[0];
                    arr[0] = arr[2];
                    arr[2] = arr[4];
                    arr[4] = tmp;
                    break;
            }
        }
    }
    static int row, column;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(input.readLine());
        row = Integer.parseInt(line.nextToken());
        column = Integer.parseInt(line.nextToken());
        int diceRow = Integer.parseInt(line.nextToken());
        int diceColumn = Integer.parseInt(line.nextToken());
        int cmdNum = Integer.parseInt(line.nextToken());

        int[][] map = new int[row][column];
        for (int i = 0; i < row; i++) {
            line = new StringTokenizer(input.readLine());
            for (int j = 0; j < column; j++) {
                map[i][j] = Integer.parseInt(line.nextToken());
            }
        }

        StringBuilder result = new StringBuilder();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        Dice dice = new Dice();
        line = new StringTokenizer(input.readLine());
        for (int i = 0; i < cmdNum; i++) {
            int dir = Integer.parseInt(line.nextToken()) - 1;
            int nextRow = diceRow + dx[dir];
            int nextColumn = diceColumn + dy[dir];
            if (isInRange(nextRow, nextColumn)) {
                int floorNum = map[nextRow][nextColumn];
                dice.move(dir);
                if (floorNum == 0) {
                    map[nextRow][nextColumn] = dice.getBottom();
                } else {
                    dice.setBottom(floorNum);
                    map[nextRow][nextColumn] = 0;
                }

                result.append(dice.getTop()).append("\n");
                diceRow = nextRow;
                diceColumn = nextColumn;
            }
        }

        System.out.println(result);
    }

    public static boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x < row && y < column;
    }
}