import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int num;
    static String[] inequality;
    static boolean[] visit = new boolean[10];
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(input.readLine());
        inequality = input.readLine().split(" ");

        for (int i = 0; i < 10; i++) {
            visit[i] = true;
            dfs(i, 0, i + "");
            visit[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }

    public static void dfs(int start, int count, String result) {
        if (count == num) {
            list.add(result);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visit[i]) {
                if (inequality[count].equals(">")) {
                    if (start > i) {
                        visit[i] = true;
                        dfs(i, count + 1, result + i);
                        visit[i] = false;
                    }
                } else {
                    if (start < i) {
                        visit[i] = true;
                        dfs(i, count + 1, result + i);
                        visit[i] = false;
                    }
                }
            }
        }
    }
}