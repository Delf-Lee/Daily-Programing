package codingtest.aceproject2019summerintern;

import java.util.Arrays;

class Solution3 {

	public int solution(int n, final int maxHp, int[] times, int[] effects) {
		int[] potionEffects = new int[times[n - 1] + 3];
		for (int i = 0; i < times.length; i++) {
			potionEffects[times[i] + 1] = effects[i];
		}

		int tmp = 0;
		for (int i = 0; i < potionEffects.length - 1; i++) {
			tmp += potionEffects[i];
			potionEffects[i] = tmp;
		}

		System.out.println(Arrays.toString(potionEffects));
		int result = 0;
		int hp = 0;
		for (int i = 0; i < potionEffects.length - 2; i++) {
			int calcHp = hp + potionEffects[i];
			hp = calcHp < 0 ? 0 : calcHp > maxHp ? maxHp : calcHp;
			System.out.print(hp + " ");
			if (hp == 0 || hp == maxHp) {
				result++;
			}
		}

		return result;
	}

	class YoungHee {
		private int hp;
		private final int maxHp;
		private int potionEffect;
		private int curTime = 0;

		private int timeZeroHp = 0;
		private int timeFullHp = 0;

		public int getTimeFullHp() {
			return timeFullHp;
		}

		public int getTimeZeroHp() {
			return timeZeroHp;
		}

		public YoungHee(int maxHp) {
			this.maxHp = maxHp;
		}

		public void drinkPotion(int n) {
			potionEffect += n;
		}

		public void applyPotionEffect(int now) {
			for (int i = curTime; i <= now; i++) {
				int calcHp = hp + potionEffect;
				hp = calcHp < 0 ? 0 : calcHp > maxHp ? maxHp : calcHp;
				System.out.printf("i = %d, potionEffect = %d, calcHp = %d, hp = %d\n", i, potionEffect, calcHp, hp);

				if (isHpFull()) {
					timeFullHp++;
				}
				if (isHpZero()) {
					timeZeroHp++;
				}
			}
			curTime = now + 1;
		}

		private boolean isHpFull() {
			return hp == maxHp;
		}

		private boolean isHpZero() {
			return hp == 0;
		}
	}


	public static void main(String[] args) {
		System.out.println(new Solution3().solution(5, 10, new int[]{1, 5, 7, 10, 11}, new int[]{4, -6, -1, 4, 1}));
	}
}