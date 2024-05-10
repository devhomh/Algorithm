import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            String func = br.readLine();
            int num = Integer.parseInt(br.readLine());
            Deque<Integer> deque = getDeque(br.readLine());

            result.append(getResult(func, deque)).append("\n");
        }

        System.out.println(result);
    }

    private static Deque<Integer> getDeque(String line) {
        if (line.equals("[]")) {
            return new LinkedList<>();
        }

        String[] arr = line.replace("[", "")
                .replace("]", "")
                .split(",");

        Deque<Integer> deque = new LinkedList<>();
        for (String s : arr) {
            deque.offer(Integer.parseInt(s));
        }

        return deque;
    }

    private static String getResult(String func, Deque<Integer> deque) {
        boolean isReverse = false;
        for (int i = 0; i < func.length(); i++) {
            char command = func.charAt(i);

            if (command == 'R') {
                isReverse = !isReverse;
            }

            if (command == 'D') {
                if (deque.isEmpty()) {
                    return "error";
                }

                if (isReverse) {
                    deque.removeLast();
                } else {
                    deque.removeFirst();
                }
            }
        }

        if (deque.isEmpty()) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        result.append("[");
        if (isReverse) {
            while (deque.size() != 1) {
                result.append(deque.removeLast()).append(",");
            }
            result.append(deque.removeLast());
        } else {
            while (deque.size() != 1) {
                result.append(deque.removeFirst()).append(",");
            }
            result.append(deque.removeFirst());
        }
        result.append("]");

        return result.toString();
    }
}
