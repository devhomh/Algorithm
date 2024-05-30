import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String word = input.readLine().toUpperCase();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char alphabet = word.charAt(i);
            if (i == 0) {
                map.put(alphabet, 1);
            } else if (!map.containsKey(alphabet)) {
                map.put(alphabet, 1);
            } else {
                map.replace(alphabet, map.get(alphabet), map.get(alphabet) + 1);
            }
        }

        int max = Collections.max(map.values());
        int duplicate = 0;
        for (int count : map.values()) {
            if (max == count) {
                duplicate++;
            }
        }

        if (duplicate >= 2) {
            System.out.println("?");
        } else {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() == max) {
                    System.out.println(entry.getKey());
                }
            }
        }
    }
}