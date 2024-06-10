import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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
        zero = zero / 2;
        one = one / 2;
        String[] arr = num.split("");
        for (int i = 0; i < arr.length; i++) {
            if (one != 0 && arr[i].equals("1")) {
                arr[i] = "-1";
                one--;
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (zero != 0 && arr[i].equals("0")) {
                arr[i] = "-1";
                zero--;
            }
        }

        StringBuilder result = new StringBuilder();
        Arrays.stream(arr).filter(e -> !e.equals("-1")).forEach(result::append);

        System.out.println(result);
    }
}