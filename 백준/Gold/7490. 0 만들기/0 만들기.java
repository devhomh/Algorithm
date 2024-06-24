import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static String[] symbols = {"+", "-", " "};
    static List<String> list;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine());
        for (int i = 0; i < testCase; i++) {
            list = new ArrayList<>();
            int num = Integer.parseInt(input.readLine());
            solution( "1", 1, num);
            Collections.sort(list);
            list.forEach(exp -> result.append(exp).append("\n"));
            result.append("\n");
        }

        System.out.println(result);
    }

    public static void solution(String expression, int start, int count) {
        if (count == start) {
            String modified = expression.replace(" ", "");
            if (calculate(modified) == 0) {
               list.add(expression);
            }

            return;
        }


        for (int i = 0; i < 3; i++) {
            solution(expression + symbols[i] + (start + 1),  start + 1, count);
        }
    }

    public static int calculate(String expression) {
        StringTokenizer st = new StringTokenizer(expression, "-|+", true);
        int cal = Integer.parseInt(st.nextToken());
        while (st.hasMoreTokens()) {
            String symbol = st.nextToken();
            if (symbol.equals("+")) {
                cal += Integer.parseInt(st.nextToken());
            } else {
                cal -= Integer.parseInt(st.nextToken());
            }
        }

        return cal;
    }
}