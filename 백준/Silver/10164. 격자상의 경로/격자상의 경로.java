import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int row, column, circle;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer condition = new StringTokenizer(input.readLine());
        row = Integer.parseInt(condition.nextToken());
        column = Integer.parseInt(condition.nextToken());
        circle = Integer.parseInt(condition.nextToken());

        int result = circle == 0 || isStartOrEnd()
                ? explore(new Point(0, 0), new Point(row - 1 , column - 1))
                : explore(new Point(0, 0), getMark()) * explore(getMark(), new Point(row - 1, column - 1));

        System.out.println(result);
    }

    public static int explore(Point start, Point end) {
        int tmpRow = end.x - start.x + 1;
        int tmpColumn = end.y - start.y + 1;
        int[][] dp = new int[tmpRow][tmpColumn];
        Arrays.fill(dp[0] , 1);
        for (int i = 0; i < tmpRow; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < tmpRow; i++) {
            for (int j = 1; j < tmpColumn; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[tmpRow - 1][tmpColumn - 1];
    }


    public static Point getMark() {
        int x = circle % column == 0 ? circle / column - 1 : circle / column;
        int y = circle % column == 0 ? column - 1 : circle % column - 1;

        return new Point(x, y);
    }

    public static boolean isStartOrEnd() {
        return getMark().distance(0, 0) == 0 || getMark().distance(row - 1, column - 1) == 0;
    }
}