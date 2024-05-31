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

        int count = 0;
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String user = input.readLine();
            if (!set.contains(user)) {
                set.add(user);
                list.add(user);
            }

            if (list.size() == required) {
                count++;
                list.clear();
            }
        }

        System.out.println(count);
    }
}