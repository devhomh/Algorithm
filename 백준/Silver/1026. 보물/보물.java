import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());

        Integer[] firstArr = new Integer[num];
        Integer[] lastArr = new Integer[num];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            firstArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            lastArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(firstArr);
        Arrays.sort(lastArr, Collections.reverseOrder());

        int result = 0;
        for (int i = 0; i < num; i++) {
            result += firstArr[i] * lastArr[i];
        }

        System.out.println(result);
    }
}
