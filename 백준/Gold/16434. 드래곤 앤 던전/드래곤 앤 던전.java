import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Room {
        int type;
        long atk;
        long life;

        public Room(int type, long atk, long life) {
            this.type = type;
            this.atk = atk;
            this.life = life;
        }
    }
    static StringTokenizer line;
    static int roomNum;
    static Room[] rooms;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        line = new StringTokenizer(input.readLine());
        roomNum = Integer.parseInt(line.nextToken());
        long atk = Integer.parseInt(line.nextToken());


        rooms = new Room[roomNum];
        for (int i = 0; i < roomNum; i++) {
            line = new StringTokenizer(input.readLine());
            int type = Integer.parseInt(line.nextToken());
            int roomAtk = Integer.parseInt(line.nextToken());
            int life = Integer.parseInt(line.nextToken());
            rooms[i] = new Room(type, roomAtk, life);
        }

        long min = 1;
        long max = Long.MAX_VALUE;
        while (min + 1 < max) {
            long mid = (max + min) / 2;
            if (canWin(mid, atk)) {
                max = mid;
            } else {
                min = mid;
            }
        }

        System.out.println(canWin(min, atk) ? min : min + 1);
    }

    public static boolean canWin(long maxHp, long atk) {
        long curHp = maxHp;
        for (int i = 0; i < roomNum; i++) {
            Room room = rooms[i];
            long monster = room.life;
            if (room.type == 1) {
                // 몬스터 피가 0이 될때까지 때려야 되는 횟수
                long count = monster % atk == 0 ? monster / atk : monster / atk + 1;

                // 몬스터가 때려야되는 총 공격력보다 현재 hp가 크다면 다음 방으로, 아니면 실패
                if (curHp > (count - 1) * room.atk) {
                    curHp -= (count - 1) * room.atk;
                } else {
                    return false;
                }
            } else {
                // 포션 공격력 만큼 더하기
                atk += room.atk;
                // 최대 체력보다 크면 최대 체력만큼 피 회복
                curHp = Math.min(maxHp, curHp + room.life);
            }
        }

        return true;
    }
}