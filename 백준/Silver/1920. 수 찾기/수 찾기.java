import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int countArr = Integer.parseInt(br.readLine());

        int[] arr = new int[countArr];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < countArr; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int countFindArr = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < countFindArr; i++) {
            int result = Arrays.binarySearch(arr, Integer.parseInt(st.nextToken()));
            sb.append(result < 0 ? 0 + "\n" : 1 + "\n");
        }

        System.out.println(sb);
    }
}
