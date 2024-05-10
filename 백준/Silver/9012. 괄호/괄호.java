import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        String line;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            line = br.readLine();
            result.append(isVPS(line)).append("\n");
        }

        System.out.println(result);
    }

    public static String isVPS(String line) {
        if (line.length() % 2 == 1) {
            return "NO";
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            char bracket = line.charAt(i);
            if (bracket == '(') {
                stack.push(bracket);
            } else if (stack.isEmpty()) {
                return "NO";
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }
}