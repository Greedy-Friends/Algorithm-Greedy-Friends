package week8;

class PG_붕대감기 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int healTime = bandage[0]; // 붕대감기 시전 시간
        int healPerSec = bandage[1]; // 1초당 회복량
        int plusHeal = bandage[2]; // 추가 회복량
        int currentHealth = health; // 현재 체력
        int lastDamage = 0; // 마지막으로 공격 당한 시간
        int turm = 0; // 공격 당하기까지의 텀

        for(int[] attack: attacks){
            if(currentHealth<=0){ // 현재 체력이 0 이하라면 죽었음
                return -1;
            }
            turm = attack[0] - lastDamage - 1; // 마지막으로 공격 당하고 얼마나의 시간이 지나고 공격을 당하는가(해당 시간에는 회복 불가: -1)

            lastDamage = attack[0]; // 마지막으로 공격 당한 시간 갱신

            int plusCount = turm / healTime; // 추가 회복 횟수

            currentHealth = currentHealth + turm * healPerSec + plusHeal * plusCount; // 현재 체력 + 붕대 감은 시간 + 추가 회복량

            if(currentHealth >= health){ // 최대 체력을 넘어갈 수 없음
                currentHealth = health;
            }
            currentHealth -= attack[1]; // 데미지 받음

            if(currentHealth <= 0){
                return -1;
            }
        }
        return currentHealth;
    }
}