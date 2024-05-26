import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer condition = new StringTokenizer(input.readLine());
        long up = Integer.parseInt(condition.nextToken());
        long down = Integer.parseInt(condition.nextToken());
        long length = Integer.parseInt(condition.nextToken());
        
        long day = up - down;
        long target = length - down;
        System.out.println(target % day != 0
                ? target / day + 1
                : target / day);
    }
}