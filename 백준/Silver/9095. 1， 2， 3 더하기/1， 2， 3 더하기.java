import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        int[] arr = new int[11];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;

        for (int i = 3; i < arr.length; i++) {
            arr[i] = arr[i - 3] + arr[i - 2] + arr[i - 1];
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < testCase; i++) {
            int num = Integer.parseInt(br.readLine());
            result.append(arr[num - 1]).append("\n");
        }

        System.out.println(result);
    }
}