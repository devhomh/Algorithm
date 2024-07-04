import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer line;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        line = new StringTokenizer(input.readLine());
        int total = Integer.parseInt(line.nextToken());
        int maxBlack = Integer.parseInt(line.nextToken());
        int minWhite = Integer.parseInt(line.nextToken());
        char[] road = input.readLine().toCharArray();

        int start = 0;
        int end = 0;
        int white = 0;
        int black = 0;
        int result = 0;
        while (true) {
            if (white >= minWhite && black <= maxBlack) {
                result = Math.max(end - start, result);
            }

            if (end == total) {
                break;
            }

            if (road[end] == 'B') {
                if (black < maxBlack) {
                    black++;
                    end++;
                } else {
                    if (road[start] == 'B') {
                        black--;
                    } else {
                        white--;
                    }

                    start++;
                }
            } else {
                white++;
                end++;
            }
        }

        System.out.println(result);
    }
}