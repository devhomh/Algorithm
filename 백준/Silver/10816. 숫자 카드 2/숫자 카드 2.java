import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line;

        int firstLineNum = Integer.parseInt(br.readLine());
        line = new StringTokenizer(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < firstLineNum; i++) {
            int key = Integer.parseInt(line.nextToken());
            
            map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
        }
        
        int secondLineNum = Integer.parseInt(br.readLine());
        line = new StringTokenizer(br.readLine());
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < secondLineNum; i++) {
            int num = Integer.parseInt(line.nextToken());
            result.append(map.getOrDefault(num, 0)).append(" ");
        }

        System.out.println(result);
    }
}