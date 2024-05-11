import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] arr = new boolean[1000000 + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr[0] = arr[1] = true;
        for (int i = 2; i * i < arr.length; i++) {
            if (!arr[i]) {
                for (int j = i * i; j < arr.length; j += i) {
                    arr[j] = true;
                }
            }
        }

        int num = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        while (num != 0) {
            result.append(solution(num)).append("\n");
            num = Integer.parseInt(br.readLine());
        }

        System.out.println(result);
    }

    public static String solution(int num) {
        for (int i = 3; i < arr.length; i++) {
            if (!arr[i] && !arr[num - i]) {
                return num + " = " + i + " + " + (num - i);
            }
        }

        return "Goldbach's conjecture is wrong.";
    }
}