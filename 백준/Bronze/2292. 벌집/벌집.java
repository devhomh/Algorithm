import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        
        if (num == 1) {
            System.out.println(1);
            return;
        }

        int count = 0;
        int total = 1;
        while (total < num) {
            total += 6 * count++;
        }

        System.out.println(count);
    }
}