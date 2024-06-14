import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Consulting {
        int period;
        int payment;

        public Consulting(int period, int payment) {
            this.period = period;
            this.payment = payment;
        }
    }

    static boolean[] schedule;
    static int num, result;
    static List<Consulting> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(input.readLine());
        schedule = new boolean[num];
        StringTokenizer line;
        for (int i = 0; i < num; i++) {
            line = new StringTokenizer(input.readLine());
            int period = Integer.parseInt(line.nextToken());
            int payment = Integer.parseInt(line.nextToken());
            list.add(new Consulting(period, payment));
        }

        dfs(0, 0);
        System.out.println(result);
    }

    public static void dfs(int last, int sum) {
        if (last >= num) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = last; i < list.size(); i++) {
            Consulting consulting = list.get(i);
            if (i + consulting.period <= num) {
                for (int j = i; j < i + consulting.period; j++) {
                    schedule[j] = true;
                }

                dfs(i + consulting.period, sum + consulting.payment);

                for (int j = i; j < consulting.period; j++) {
                    schedule[j] = false;
                }
            } else {
                result = Math.max(result, sum);
            }
        }
    }
}