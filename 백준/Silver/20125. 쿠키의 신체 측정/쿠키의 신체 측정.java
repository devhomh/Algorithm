import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());

        boolean heartFind = false;
        int row = 0;
        int column = 0;
        StringBuilder result = new StringBuilder();
        String[][] board = new String[num][num];
        for (int i = 0; i < num; i++) {
            String line = input.readLine();
            for (int j = 0; j < num; j++) {
                board[i][j] = Character.toString(line.charAt(j));
                if (!heartFind && Character.toString(line.charAt(j)).equals("*")) {
                    heartFind = true;
                    row = i + 1;
                    column = j;
                    result.append(i + 2).append(" ").append(j + 1).append("\n");
                }
            }
        }

        int[] length = new int[5];
        for (int i = row; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (i == row && j < column && board[i][j].equals("*")) {
                    length[0]++;
                }

                if (i == row && j > column && board[i][j].equals("*")) {
                    length[1]++;
                }

                if (i > row && j == column && board[i][j].equals("*")) {
                    length[2]++;
                }

                if (i > row && j == column - 1 && board[i][j].equals("*")) {
                    length[3]++;
                }

                if (i > row && j == column + 1 && board[i][j].equals("*")) {
                    length[4]++;
                }
            }
        }

        Arrays.stream(length).forEach(element -> result.append(element).append(" "));
        System.out.println(result);
    }
}