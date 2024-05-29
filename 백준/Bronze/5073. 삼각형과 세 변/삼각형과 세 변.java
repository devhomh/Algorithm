import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line;
        int[] triangle = new int[3];
        StringBuilder result = new StringBuilder();
        while (true) {
            line = new StringTokenizer(input.readLine());
            for (int i = 0; i < 3; i++) {
                triangle[i] = Integer.parseInt(line.nextToken());
            }

            if (triangle[0] == 0) {
                break;
            }

            Arrays.sort(triangle);
            
            if (triangle[2] >= triangle[0] + triangle[1]){
                result.append("Invalid").append("\n");
                continue;
            }
            if (triangle[0] == triangle[1] && triangle[1] == triangle[2]) {
                result.append("Equilateral").append("\n");
            } else if (triangle[0] == triangle[1] || triangle[1] == triangle[2] || triangle[0] == triangle[2]) {
                result.append("Isosceles").append("\n");
            } else {
                result.append("Scalene").append("\n");
            }
        }

        System.out.println(result);
    }
}