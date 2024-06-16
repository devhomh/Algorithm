import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int[][] gears;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        gears = new int[4][8];
        for (int i = 0; i < 4; i++) {
            gears[i] = Stream.of(input.readLine().split(""))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        }

        int cmdNum = Integer.parseInt(input.readLine());
        StringTokenizer cmd;
        for (int i = 0; i < cmdNum; i++) {
            cmd = new StringTokenizer(input.readLine());
            int num = Integer.parseInt(cmd.nextToken());
            int dir = Integer.parseInt(cmd.nextToken());

            work(num, dir);
        }

        int result = 0;
        for (int i = 0; i < 4; i++) {
            result += gears[i][0] == 0 ? 0 : (int) Math.pow(2, i);
        }

        System.out.println(result);
    }

    // 오른쪽 톱니 : 2
    // 왼쪽 톱니 : 6
    public static void work(int num, int dir) {
        int firstRight = gears[0][2];
        int secondLeft = gears[1][6];
        int secondRight = gears[1][2];
        int thirdLeft = gears[2][6];
        int thirdRight = gears[2][2];
        int lastLeft = gears[3][6];

        switch (num - 1) {
            case 0 :
                rotate(dir, gears[0]);
                if (firstRight != secondLeft) {
                    rotate(dir * -1, gears[1]);
                    if (secondRight != thirdLeft) {
                        rotate(dir, gears[2]);
                        if (thirdRight != lastLeft) {
                            rotate(dir * -1, gears[3]);
                        }
                    }
                }

                break;
            case 1 :
                rotate(dir, gears[1]);
                if (firstRight != secondLeft) {
                    rotate(dir * -1, gears[0]);
                }

                if (secondRight != thirdLeft) {
                    rotate(dir * -1, gears[2]);
                    if (thirdRight != lastLeft) {
                        rotate(dir, gears[3]);
                    }
                }

                break;
            case 2 :
                rotate(dir, gears[2]);
                if (secondRight != thirdLeft) {
                    rotate(dir * -1, gears[1]);
                    if (firstRight != secondLeft) {
                        rotate(dir, gears[0]);
                    }
                }

                if (thirdRight != lastLeft) {
                    rotate(dir * -1, gears[3]);
                }

                break;
            default:
                rotate(dir, gears[3]);
                if (thirdRight != lastLeft) {
                    rotate(dir * -1, gears[2]);
                    if (secondRight != thirdLeft) {
                        rotate(dir, gears[1]);
                        if (firstRight != secondLeft) {
                            rotate(dir * -1, gears[0]);
                        }
                    }
                }

                break;
        }
    }

    public static void rotate(int dir, int[] arr) {
        if (dir == 1) {
            clockwise(arr);
        } else {
            counterClockwise(arr);
        }
    }

    public static void clockwise(int[] arr) {
        int tmp = arr[0];
        arr[0] = arr[7];
        arr[7] = arr[6];
        arr[6] = arr[5];
        arr[5] = arr[4];
        arr[4] = arr[3];
        arr[3] = arr[2];
        arr[2] = arr[1];
        arr[1] = tmp;
    }

    public static void counterClockwise(int[] arr) {
        int tmp = arr[0];
        arr[0] = arr[1];
        arr[1] = arr[2];
        arr[2] = arr[3];
        arr[3] = arr[4];
        arr[4] = arr[5];
        arr[5] = arr[6];
        arr[6] = arr[7];
        arr[7] = tmp;
    }
}