import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int maxStoreNum;
    static ArrayList<Point> storeList = new ArrayList<>();
    static ArrayList<Point> homeList = new ArrayList<>();
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        maxStoreNum = Integer.parseInt(st.nextToken());

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++) {
                int place = Integer.parseInt(st.nextToken());
                if (place == 1) {
                    homeList.add(new Point(i, j));
                }
                else if (place == 2) {
                    storeList.add(new Point(i, j));
                }
            }
        }
        visited = new boolean[storeList.size()];


        dfs(0, 0);

        System.out.println(result);
    }

    public static void dfs(int depth, int start) {
        if (depth == maxStoreNum) {
            int sum = 0;

            for (int i = 0; i < homeList.size(); i++) {
                int minDistance = Integer.MAX_VALUE;

                for (int j = 0; j < storeList.size(); j++) {
                    if (visited[j]) {
                        minDistance = Math.min(minDistance, getDistance(i, j));
                    }
                }

                sum += minDistance;
            }

            result = Math.min(result, sum);
            return;
        }

        for (int i = start; i < storeList.size(); i++) {
            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }
    }

    public static int getDistance(int homeIndex, int storeIndex) {
        return Math.abs(homeList.get(homeIndex).x - storeList.get(storeIndex).x)
                + Math.abs(homeList.get(homeIndex).y - storeList.get(storeIndex).y);
    }
}