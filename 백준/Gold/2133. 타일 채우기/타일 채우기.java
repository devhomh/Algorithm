import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        int[] board = new int[num + 1];
        board[0] = 1;

        for (int i = 2; i <= num; i += 2) {
            board[i] = board[i - 2] * 3;
            for (int j = i - 4; j >= 0; j -= 2) {
                board[i] += board[j] * 2;
            }
        }

        System.out.println(board[num]);
    }
}