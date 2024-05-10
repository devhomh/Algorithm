import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String line = br.readLine();

        while (!line.equals("0")) {
            st = new StringTokenizer(line);
            int num = Integer.parseInt(st.nextToken());

            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }


            backtrack(arr, 0, 0, new int[6]);
            result.append("\n");

            line = br.readLine();
        }

        System.out.println(result);
    }

    private static void backtrack(int[] arr, int count, int index, int[] current) {
        if (count == 6) {
            for (int num : current) {
                result.append(num).append(" ");
            }
            result.append("\n");
            return;
        }

        for (int i = index; i < arr.length; i++) {
            current[count] = arr[i];
            backtrack(arr, count + 1, i + 1, current);
        }
    }
}