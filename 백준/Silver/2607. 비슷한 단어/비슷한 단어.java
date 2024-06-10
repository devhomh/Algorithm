import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        String first = input.readLine();
        Map<Character, Integer> composition = new HashMap<>();
        for (int i = 0; i < first.length(); i++) {
            composition.put(first.charAt(i), composition.getOrDefault(first.charAt(i), 0) + 1);
        }

        int count = 0;
        for (int i = 0; i < num - 1; i++) {
            String compare = input.readLine();
            if (isSimilar(composition, first, compare)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isSimilar(Map<Character, Integer> original, String standard, String compare) {
        if (standard.equals(compare)) {
            return true;
        }

        int check = 0;
        Map<Character, Integer> copy = new HashMap<>(original);
        for (int i = 0; i < compare.length(); i++) {
            char alphabet = compare.charAt(i);
            if (copy.containsKey(alphabet) && copy.get(alphabet) > 0) {
                copy.put(alphabet, copy.get(alphabet) - 1);
                check++;
            }
        }

        if (standard.length() == compare.length() + 1) {
            return check == compare.length();
        } else if (standard.length() == compare.length() - 1) {
            return check == standard.length();
        } else if (standard.length() == compare.length()) {
            return check == standard.length() || check == standard.length() - 1;
        }

        return false;
    }
}