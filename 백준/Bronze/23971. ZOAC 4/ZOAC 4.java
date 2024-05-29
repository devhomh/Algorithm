import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(input.readLine());
        int row = Integer.parseInt(line.nextToken());
        int column = Integer.parseInt(line.nextToken());
        int rowDiff = Integer.parseInt(line.nextToken());
        int columnDiff = Integer.parseInt(line.nextToken());

        int count = 0;
        for (int i = 0; i < row; i+= rowDiff + 1) {
            for (int j = 0; j < column; j += columnDiff + 1) {
                count++;
            }
        }

        System.out.println(count);
    }
}