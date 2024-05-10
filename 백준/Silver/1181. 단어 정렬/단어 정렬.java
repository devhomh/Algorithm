import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int lineNum = Integer.parseInt(br.readLine());

        String[] arr = new String[lineNum];

        for (int i = 0; i < lineNum; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1.length() == o2.length()){
                return o1.compareTo(o2);
            }

            return o1.length() - o2.length();
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if(i == 0) {
                sb.append(arr[i]).append("\n");
                continue;
            }
            
            if(arr[i].equals(arr[i-1])) {
                continue;    
            }
            
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }
}
