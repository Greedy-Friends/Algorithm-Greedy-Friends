package week8.pccp1;

/**
 * 게임 캐릭터가 몬스터 공격을 받으면서
 * 붕대 감기 스킬로 체력 회복
 *
 * 붕대 감기 스킬:
 * - 1초마다 x만큼 회복
 * - t초 연속 성공 시 y 추가 회복
 * - 공격받으면 캔슬 (연속 시간 초기화)
 *
 * 체력이 최대 체력을 넘을 수 없음
 * 체력이 0 이하가 되면 사망 (-1 반환)
 *
 * 최종 남은 체력은?
 */
// https://school.programmers.co.kr/learn/courses/30/lessons/250137
// [PCCP 기출문제] 1번 / 붕대 감기
class Solution {

    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];  // 시전 시간
        int x = bandage[1];  // 1초당 회복량
        int y = bandage[2];  // 추가 회복량

        int maxHealth = health;      // 최대 체력
        int currentHealth = health;  // 현재 체력
        int consecutiveTime = 0;     // 연속 시간

        // 마지막 공격 시간
        int endTime = attacks[attacks.length - 1][0];
        int attackIndex = 0;  // 현재 공격 인덱스

        // 1초부터 마지막 공격까지
        for (int time = 1; time <= endTime; time++) {

            // 이 시간에 공격이 있는지 확인
            if (attackIndex < attacks.length && attacks[attackIndex][0] == time) {
                // 피해 입음
                currentHealth -= attacks[attackIndex][1];

                // 사망 체크
                if (currentHealth <= 0) return -1;

                // 연속 시간 초기화
                consecutiveTime = 0;
                // 다음 공격으로
                attackIndex++;

            } else {
                // 공격 없음 → 회복
                currentHealth += x;
                consecutiveTime++;

                // 연속 성공 체크
                if (consecutiveTime == t) {
                    currentHealth += y;  // 추가 회복
                    consecutiveTime = 0; // 초기화
                }

                // 최대 체력 제한
                if (currentHealth > maxHealth) {
                    currentHealth = maxHealth;
                }
            }
        }

        return currentHealth;
    }
}
