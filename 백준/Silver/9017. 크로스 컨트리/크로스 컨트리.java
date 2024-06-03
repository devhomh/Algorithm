import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            int num = Integer.parseInt(input.readLine());
            StringTokenizer line = new StringTokenizer(input.readLine());
            // 선수들의 점수
            int[] ranking = new int[num];

            // 팀이 6명이 되는지 확인하는 맵
            Map<Integer, Integer> countingMap = new HashMap<>();
            for (int j = 0; j < num; j++) {
                int tmp = Integer.parseInt(line.nextToken());
                ranking[j] = tmp;
                countingMap.put(tmp, countingMap.getOrDefault(tmp, 0) + 1);
            }

            int score = 1;
            Map<Integer, Integer> scoreMap = new HashMap<>();
            Map<Integer, Integer> fifthMap = new HashMap<>();
            Map<Integer, Integer> tmpMap = new HashMap<>();
            for (int team : ranking) {
                if (countingMap.get(team) == 6) {
                    tmpMap.put(team, tmpMap.getOrDefault(team, 0) + 1);

                    if (tmpMap.get(team) <= 4) {
                        scoreMap.put(team, scoreMap.getOrDefault(team, 0) + score);
                    }

                    if (tmpMap.get(team) == 5) {
                        fifthMap.put(team, score);
                    }

                    score++;
                }
            }

            int winner = 0;
            int total = Integer.MAX_VALUE;
            int fifthMember = Integer.MAX_VALUE;
            for (int team : tmpMap.keySet()) {
                if (total == scoreMap.get(team) && fifthMap.get(team) < fifthMember) {
                    fifthMember = fifthMap.get(team);
                    total = scoreMap.get(team);
                    winner = team;
                }

                if (total > scoreMap.get(team)) {
                    fifthMember = fifthMap.get(team);
                    total = scoreMap.get(team);
                    winner = team;
                }
            }
            result.append(winner).append("\n");
        }

        System.out.println(result);
    }
}