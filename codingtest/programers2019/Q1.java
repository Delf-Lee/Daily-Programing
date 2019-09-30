package codingtest.programers2019;

import java.util.Arrays;

/**
 * @author delf
 */
public class Q1 {
	private final static int LIMIT = 200_000_000;

	public int solution(int[] goods, int[] boxes) {
		int answer = 0;

		/*int[] boxSizeMinMax = getMinMax(boxes);
		int boxMinSize = boxSizeMinMax[0];
		int boxMaxSize = boxSizeMinMax[1];

		int[] goodsSizeMinMax = getMinMax(goods);
		int goodsMinSize = goodsSizeMinMax[0];
		int goodsMaxSize = goodsSizeMinMax[1];

		System.out.println("goodsMinSize " + goodsMinSize);
		int tooSmallBoxCnt = 0;
		for (int boxSize : boxes) {
			if (boxSize < goodsMinSize) {
				tooSmallBoxCnt++;
			}
		}

		System.out.println("boxMaxSize " + boxMaxSize);
		int tooBigGoodsCnt = 0;
		for (int goodsSize : goods) {
			if (goodsSize < boxMaxSize) {
				tooBigGoodsCnt++;
			}
		}

		System.out.println(tooSmallBoxCnt);
		System.out.println(tooBigGoodsCnt);

		answer = boxes.length - tooSmallBoxCnt - tooBigGoodsCnt;

		*//*int boxMaxSize = 1;
		int boxMinSize = LIMIT;
		for (int boxSize : boxes) {
			if (boxSize > boxMaxSize) {
				boxMaxSize = boxSize;
			}

			if (boxSize < boxMinSize) {
				boxMinSize = boxSize;
			}
		}*/

		Arrays.sort(goods);
		Arrays.sort(boxes);

		System.out.println(Arrays.toString(goods));
		System.out.println(Arrays.toString(boxes));
		int cnt = 0;

		int goodsIdx = 0;
		int boxesIdx = 0;

		int endIdx = Math.min(goods.length, boxes.length);
		for (int i = 0; i < endIdx; i++) {
			if (boxes[boxesIdx++] < goods[goodsIdx]) {
				continue;
			}
			goodsIdx++;
			cnt++;
		}

		return cnt;
	}


	public static void main(String[] args) {
		// System.out.println(new Q1().solution(new int[]{200, 201, 9, 7, 5}, new int[]{3,4, 14, 80, 119, 39}));
		System.out.println(new Q1().solution(new int[]{2, 100, 100, 100, 51}, new int[]{1, 100, 100, 100, 50}));
	}
}
