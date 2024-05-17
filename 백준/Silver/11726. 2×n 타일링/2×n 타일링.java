import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        int[] board = new int[1001];
        board[1] = 1;
        board[2] = 2;

        for (int i = 3; i <= num; i++) {
            board[i] = (board[i - 1] + board[i - 2]) % 10007;
        }

        System.out.println(board[num]);
    }
}