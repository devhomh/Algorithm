import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] owned;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer condition = new StringTokenizer(input.readLine());
        int landNum = Integer.parseInt(condition.nextToken());
        int duckNum = Integer.parseInt(condition.nextToken());

        StringBuilder result = new StringBuilder();
        owned = new boolean[landNum + 1];
        for (int i = 0; i < duckNum; i++) {
            int duck = Integer.parseInt(input.readLine());
            result.append(search(duck)).append("\n");
        }

        System.out.println(result);
    }

    public static int search(int duck) {
        int land = duck;
        int tmp = 0;
        while (land != 1) {
            if (owned[land]) {
                tmp = land;
            }

            land /= 2;
        }

        if (tmp == 0) {
            owned[duck] = true;
            return 0;
        }

        return tmp;
    }
}