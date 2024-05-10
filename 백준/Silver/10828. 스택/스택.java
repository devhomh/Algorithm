import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();

        int lineNum = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < lineNum; i++) {
            String line = br.readLine();

            if (line.startsWith("push")) {
                int num = Integer.parseInt(line.split(" ")[1]);
                stack.push(num);
            }

            if (line.startsWith("pop")) {
                result.append(stack.isEmpty() ? -1 + "\n" : stack.pop() + "\n");
            }

            if (line.startsWith("size")) {
                result.append(stack.isEmpty() ? 0 + "\n" : stack.size() + "\n");
            }

            if (line.startsWith("empty")) {
                result.append(stack.isEmpty() ? 1 + "\n" : 0 + "\n");
            }

            if (line.startsWith("top")) {
                result.append(stack.isEmpty() ? -1 + "\n" : stack.peek() + "\n");
            }
        }

        System.out.println(result);
    }
}
