import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Country {
        int num;
        int gold;
        int silver;
        int bronze;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Country country = (Country) o;
            return gold == country.gold && silver == country.silver && bronze == country.bronze;
        }

        @Override
        public int hashCode() {
            return Objects.hash(gold, silver, bronze);
        }

        public Country(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(input.readLine());
        int num = Integer.parseInt(line.nextToken());
        int target = Integer.parseInt(line.nextToken());
        PriorityQueue<Country> ranking = new PriorityQueue<>(
                (c1, c2) -> c1.gold == c2.gold
                        ? c1.silver == c2.silver
                            ? c2.bronze - c1.bronze
                            : c2.silver - c1.silver
                        : c2.gold - c1.gold);

        for (int i = 0; i < num; i++) {
            line = new StringTokenizer(input.readLine());
            int country = Integer.parseInt(line.nextToken());
            int gold = Integer.parseInt(line.nextToken());
            int silver = Integer.parseInt(line.nextToken());
            int bronze = Integer.parseInt(line.nextToken());
            ranking.offer(new Country(country, gold, silver, bronze));
        }

        int count = 1;
        int result = 1;
        Country current = ranking.poll();
        while (!ranking.isEmpty() && current.num != target) {
            count++;
            if (!current.equals(ranking.peek())) {
               result = count;
            }
            current = ranking.poll();
        }

        System.out.println(result);
    }
}