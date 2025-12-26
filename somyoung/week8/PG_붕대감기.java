// PG / 붕대 감기 / Lv. 1
package somyoung.week8;

class PG_붕대감기 {
    public static int solution(int[] bandage, int health, int[][] attacks) {
        int time = attacks[attacks.length - 1][0]; // 몬스터의 마지막 공격이 최종 시간
        int sucess = 0; // 연속 공격
        int t = bandage[0], x = bandage[1], y = bandage[2]; // 시전 시간, 초당 회복량, 추가 회복량
        int current = health; // 현재 체력
        int index = 0; // 공격 배열 인덱스

        for (int s = 1; s <= time; s++) {
            // 몬스터 공격 시
            if (s == attacks[index][0]) {
                // 기술 초기화
                t = bandage[0];
                sucess = 0;

                current -= attacks[index][1];
                if (current <= 0) return -1; // 공격 후 체력이 0 이하면 -1 return

                index++;
            } else { // 몬스터 공격 X
                if (t > 0) {
                    t -= 1;
                    sucess++;

                    // 현재 체력 + 회복이 최대 체력 이상일 때
                    if (current + x >= health) {
                        current = health; // 현재 체력이 최대 체력이 됨
                    } else { // 현재 체력 + 회복이 최대 체력 미만
                        current += x;
                    }
                }

                // t초 연속으로 붕대를 감는 데 성공한다면 y만큼의 체력을 추가로 회복
                if (bandage[0] == sucess) {
                    if (current + y >= health) {
                        current = health;
                    } else {
                        current += y;
                    }

                    // 기술 초기화
                    t = bandage[0];
                    sucess = 0;
                }
            }
        }

        return current;
    }

    // 테스트 케이스
    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 1, 5}, 30, new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}}));
        System.out.println(solution(new int[]{3, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}}));
        System.out.println(solution(new int[]{4, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}}));
        System.out.println(solution(new int[]{1, 1, 1}, 5, new int[][]{{1, 2}, {3, 2}}));

    }
}
