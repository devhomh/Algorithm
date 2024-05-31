import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer condition = new StringTokenizer(input.readLine());
        int num = Integer.parseInt(condition.nextToken());
        String game = condition.nextToken();

        int required;
        if (game.equals("Y")) {
            required = 1;
        } else if (game.equals("F")) {
            required = 2;
        } else {
            required = 3;
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < num; i++) {
            set.add(input.readLine());
        }

        System.out.println(set.size() / required);
    }
}