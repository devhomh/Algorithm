import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String num = input.readLine();

        int result = 0;
        int pointer = 0;
        while (true) {
            String tmp = String.valueOf(++result);
            for (int i = 0; i < tmp.length(); i++) {
                if (num.charAt(pointer) == tmp.charAt(i)) {
                    pointer++;
                }

                if (pointer == num.length()) {
                    System.out.println(result);
                    return;
                }
            }
        }
    }
}