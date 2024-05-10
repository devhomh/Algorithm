import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int lineNum = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int count = 1;
        boolean possible = true;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < lineNum; i++) {
            int num = Integer.parseInt(br.readLine());

            if (stack.isEmpty()) {
                if (count > num) {
                    possible = false;
                    break;
                }
            } else {
                if (stack.peek() > num) {
                    possible = false;
                    break;
                }
            }

            while (count <= num) {
                stack.push(count);
                result.append("+").append("\n");
                count++;
            }
            stack.pop();
            result.append("-").append("\n");
        }

        System.out.println(possible ? result : "NO");
    }
}