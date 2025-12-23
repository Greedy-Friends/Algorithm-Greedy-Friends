class Solution {
	public int solution(int[] bandage, int health, int[][] attacks) {
		int t = bandage[0];
		int x = bandage[1];
		int y = bandage[2];

		int maxHealth = health;
		int currentHealth = health;
		int combo = 0;

		int attackIdx = 0;
		int lastAttackTime = attacks[attacks.length - 1][0];

		for (int time = 1; time <= lastAttackTime; time++) {
			if (attackIdx < attacks.length && attacks[attackIdx][0] == time) {
				// 공격 받음
				currentHealth -= attacks[attackIdx][1];
				combo = 0;
				attackIdx++;

				// 체력이 0 이하면 사망
				if (currentHealth <= 0) {
					return -1;
				}
			} else {
				currentHealth += x;
				combo++;

				if (combo == t) {
					currentHealth += y;
					combo = 0;
				}

				// 최대 체력 초과 불가
				if (currentHealth > maxHealth) {
					currentHealth = maxHealth;
				}
			}
		}

		return currentHealth;
	}
}