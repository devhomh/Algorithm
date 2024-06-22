import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());

        int value = 0;
        map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char alphabet = (char) (65 + i);
            String key =  Character.toString(alphabet);
            map.put(key, ++value);
            map.put(key.toLowerCase(), ++value);
        }

        PriorityQueue<String> queue = new PriorityQueue<>(naturalSort());
        for (int i = 0; i < num; i++) {
            queue.offer(input.readLine());
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            result.append(queue.poll()).append("\n");
        }

        System.out.println(result);
    }

    private static Comparator<String> naturalSort() {
        return (s1, s2) -> {
            List<String> one = getUnits(s1);
            List<String> another = getUnits(s2);

            int idx = 0;
            while (idx < Math.min(one.size(), another.size())) {
                String onePart = one.get(idx);
                String anotherPart = another.get(idx);

                // 두 파트가 다를 때
                if (!onePart.equals(anotherPart)) {
                    // 둘다 숫자일 경우 숫자가 작은 쪽으로 정렬
                    if (isNumber(onePart.charAt(0)) && isNumber(anotherPart.charAt(0))) {
                        BigInteger bigOne = new BigInteger(onePart);
                        BigInteger bigAnother = new BigInteger(anotherPart);

                        // 숫자 value 가 같을 경우 숫자 문자열의 길이가 짧은 쪽으로 정렬
                        return bigOne.equals(bigAnother)
                                ? onePart.length() - anotherPart.length()
                                : bigOne.compareTo(bigAnother);
                    }

                    // 둘중 하나가 숫자일 경우 숫자인 쪽으로 정렬
                    if (isNumber(onePart.charAt(0))) {
                        return -1;
                    }

                    if (isNumber(anotherPart.charAt(0))) {
                        return 1;
                    }

                    // 알파벳 value 가 작은 쪽으로 정렬
                    return map.get(onePart) - map.get(anotherPart);
                }

                idx++;
            }

            return one.size() - another.size();
        };
    }

    public static List<String> getUnits(String input) {
        List<String> list = new ArrayList<>();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char part = input.charAt(i);
            // 숫자가 나오기 시작하면 number 에 추가
            if (Character.isDigit(part)) {
                number.append(part);
            }else {
                // 알파벳일때 전까지의 숫자가 있을 경우, list 에 추가
                if (number.length() != 0) {
                    list.add(number.toString());
                    number = new StringBuilder();
                }

                // 알파벳은 리스트에 추가
                list.add(Character.toString(part));
            }
        }

        if (number.length() != 0) {
            list.add(number.toString());
        }

        return list;
    }

    public static boolean isNumber(char part) {
        return part >= '0' && part <= '9';
    }
}