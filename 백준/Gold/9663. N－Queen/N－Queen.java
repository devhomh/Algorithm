import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int result;

    public static int num;

    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());

        arr = new int[num];

        backTracking(0);

        System.out.println(result);
    }

    public static void backTracking(int count) {
        if (count == num) {
            result++;
            return;
        }

        for (int i = 0; i < num; i++) {
            arr[count] = i;

            if (possible(count)) {
                backTracking(count + 1);
            }
        }
    }

    public static boolean possible(int column) {
        for (int i = 0; i < column; i++) {
            if (arr[column] == arr[i]) {
                return false;
            }

            else if(Math.abs(column - i) == Math.abs(arr[column] - arr[i])) {
                return false;
            }
        }

        return true;
    }
}