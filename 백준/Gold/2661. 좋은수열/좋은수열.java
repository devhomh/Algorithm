import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        backTracking("");
    }

    public static void backTracking(String result) {
        if (result.length() == num) {
            System.out.println(result);
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            if (isGood(result + i)) {
                backTracking(result + i);
            }
        }
    }

    public static boolean isGood(String result) {
        int length = result.length() / 2;

        for (int i = 1; i <= length; i++) {
            if (result.substring(result.length() - i)
                    .equals(result.substring(result.length() - i * 2, result.length() - i))){
                return false;
            }
        }

        return true;
    }
}