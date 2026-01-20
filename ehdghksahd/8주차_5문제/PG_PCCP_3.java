import java.util.*;

https://school.programmers.co.kr/learn/courses/30/lessons/250137
// 붕대 감기

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        Map<Integer, Integer> m = new HashMap<>(); // 몬스터 정보 저장, 한번에 두명의 몬스터 안만나기 때문에 map 사용
        for(int i = 0; i < attacks.length; i++){
            m.put(attacks[i][0], attacks[i][1]);
        }
        int time = bandage[0]; // 시전시간
        int heal = bandage[1]; // 초당 회복량
        int bonus = bandage[2]; // 추가 회복량

        int last = attacks[attacks.length - 1][0]; // 마지막 몬스터 공격 시간

        int chain = 0; // 연속 성공 여부

        int curHealth = health; // 현재 체력

        for(int i = 1; i <= last; i++){ // 1초 부터 마지막 몬스터 공격 시간 까지
            if(!m.containsKey(i)) {
                curHealth += heal;
                if(curHealth > health) curHealth = health; // 최대체력 오버 시
                chain++;
                if(chain == time) {
                    curHealth += bonus;
                    if(curHealth > health) curHealth = health; // 최대체력 오버 시
                    chain = 0;
                }
            }
            else {
                chain = 0;
                int dmg = m.get(i);
                curHealth -= dmg;
                if(curHealth <= 0) return -1;

            }
        }

        return curHealth;
    }
}