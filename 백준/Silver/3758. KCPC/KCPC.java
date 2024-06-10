import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static class Stat {
        public int[] getScores() {
            return scores;
        }

        public void setScores(int[] scores) {
            this.scores = scores;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getLastSubmit() {
            return lastSubmit;
        }

        public void setLastSubmit(int lastSubmit) {
            this.lastSubmit = lastSubmit;
        }

        int[] scores;
        int count;
        int lastSubmit;

        public Stat(int[] scores, int count, int lastSubmit) {
            this.scores = scores;
            this.count = count;
            this.lastSubmit = lastSubmit;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(input.readLine());
        StringTokenizer line;
        Map<Integer, Stat> map;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            line = new StringTokenizer(input.readLine());
            int teamNum = Integer.parseInt(line.nextToken());
            int problemNum = Integer.parseInt(line.nextToken());
            int target = Integer.parseInt(line.nextToken());
            int entryNum = Integer.parseInt(line.nextToken());

            map = new HashMap<>();
            for (int j = 1; j <= teamNum; j++) {
                map.put(j, new Stat(new int[problemNum], 0, 0));
            }

            for (int j = 0; j < entryNum; j++) {
                line = new StringTokenizer(input.readLine());
                int id = Integer.parseInt(line.nextToken());
                int num = Integer.parseInt(line.nextToken());
                int score = Integer.parseInt(line.nextToken());

                Stat stat = map.get(id);
                int[] scores = stat.getScores();
                scores[num - 1] = Math.max(scores[num - 1], score);
                stat.setCount(stat.getCount() + 1);
                stat.setScores(scores);
                stat.setLastSubmit(j);
                map.put(id, stat);
            }

            Map<Integer, Stat> finalMap = map;
            List<Integer> rankings = map.keySet().stream().sorted((t1, t2) -> {
                if (IntStream.of(finalMap.get(t1).getScores()).sum()
                        == IntStream.of(finalMap.get(t2).getScores()).sum()) {
                    if (finalMap.get(t1).getCount() == finalMap.get(t2).getCount()) {
                        return finalMap.get(t1).getLastSubmit() - finalMap.get(t2).getLastSubmit();
                    } else {
                        return finalMap.get(t1).getCount() - finalMap.get(t2).getCount();
                    }
                } else {
                    return IntStream.of(finalMap.get(t2).getScores()).sum() - IntStream.of(finalMap.get(t1).getScores()).sum();
                }
            }).collect(Collectors.toList());

            for (int j = 0; j < rankings.size(); j++) {
                if (rankings.get(j) == target) {
                    result.append(j + 1).append("\n");
                }
            }
        }

        System.out.println(result);
    }
}