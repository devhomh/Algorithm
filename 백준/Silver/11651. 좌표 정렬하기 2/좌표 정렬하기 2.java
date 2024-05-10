import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int lineNum = Integer.parseInt(br.readLine());

        int[][] arr = new int[lineNum][2];

        for (int i = 0; i < lineNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr,
                (a1, a2) -> a1[1] == a2[1]
                        ? a1[0] - a2[0]
                        : a1[1] - a2[1]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lineNum; i++) {
            sb.append(arr[i][0])
                    .append(" ")
                    .append(arr[i][1])
                    .append("\n");
        }

        System.out.println(sb);
    }
}