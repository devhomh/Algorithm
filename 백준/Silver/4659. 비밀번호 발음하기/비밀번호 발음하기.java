import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        String line = input.readLine();
        while (!line.equals("end")) {
            result.append("<")
                    .append(line)
                    .append(">")
                    .append(isAcceptable(line) ? " is acceptable." : " is not acceptable.")
                    .append("\n");

            line = input.readLine();
        }

        System.out.println(result);
    }

    public static boolean isAcceptable(String password) {
        for (int i = 0; i < password.length() - 2; i++) {
            String part = password.substring(i, i + 3);
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (part.charAt(j) == 'a'
                        || part.charAt(j) == 'e'
                        || part.charAt(j) == 'i'
                        || part.charAt(j) == 'o'
                        || part.charAt(j) == 'u') {
                    count++;
                }
            }

            if (count == 0 || count == 3) {
                return false;
            }
        }

        char current = password.charAt(0);
        for (int i = 1; i < password.length(); i++) {
            char next = password.charAt(i);
            if (next != 'e' && next != 'o' && current == next) {
                return false;
            }
            
            current = next;
        }

        return password.contains("a")
                || password.contains("e")
                || password.contains("i")
                || password.contains("o")
                || password.contains("u");
    }
}