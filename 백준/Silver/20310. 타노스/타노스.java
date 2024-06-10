import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String num = input.readLine();
        int zero = 0;
        int one;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '0') {
                zero++;
            }
        }

        one = num.length() - zero;
        String result = "0".repeat(Math.max(0, zero / 2)) +
                "1".repeat(Math.max(0, one / 2));

        System.out.println(result);
    }
}