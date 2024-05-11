import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[num + 1];
        arr[0] = arr[1] = true;
        for (int i = 2; i * i <= num; i++) {
            if (!arr[i]) {
                for (int j = i * i; j <= num; j += i) {
                    arr[j] = true;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < arr.length; i++) {
            if (!arr[i]) {
                list.add(i);
            }
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;

        while (true) {
            if (sum < num) {
                if (end == list.size()) {
                    break;
                }

                sum += list.get(end++);
            } else {
                sum -= list.get(start++);
            }

            if (sum == num) {
                count++;
            }
        }

        System.out.println(count);
    }
}