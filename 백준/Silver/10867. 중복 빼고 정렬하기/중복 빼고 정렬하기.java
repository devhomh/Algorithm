import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int lineNum = Integer.parseInt(br.readLine());

        StringTokenizer line = new StringTokenizer(br.readLine());
        int[] arr = new int[lineNum];
        for (int i = 0; i < lineNum; i++) {
            arr[i] = Integer.parseInt(line.nextToken());
        }

        Arrays.sort(arr);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if(i == 0) {
                result.append(arr[i]).append(" ");
                continue;
            }

            if(arr[i] == arr[i - 1]){
                continue;
            }

            result.append(arr[i]).append(" ");
        }

        System.out.println(result);
    }
}