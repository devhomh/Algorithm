import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<String> leftStack = new Stack<>();
        Stack<String> rightStack = new Stack<>();

        String[] arr = br.readLine().split("");
        for (String word : arr) {
            leftStack.push(word);
        }

        int cmdNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < cmdNum; i++) {
            String command = br.readLine();

            if(command.startsWith("L") && !leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            }

            if(command.startsWith("D") && !rightStack.isEmpty()) {
                leftStack.push(rightStack.pop());
            }

            if (command.startsWith("B") && !leftStack.isEmpty()) {
                leftStack.pop();
            }

            if (command.startsWith("P")) {
                String num = command.split(" ")[1];
                leftStack.push(num);
            }
        }

        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }

        StringBuilder result = new StringBuilder();

        while (!rightStack.isEmpty()) {
            result.append(rightStack.pop());
        }

        System.out.println(result);
    }
}
