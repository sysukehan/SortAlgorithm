package bubbleSort;

import main.BaseSortClass;

/**
 * 冒泡排序
 * In-place sort and stable sort
 * 最差时间复杂度O(N^2)，最好的时间复杂度O(N)
 * @author kehan
 *
 */
public class BubbleSort extends BaseSortClass {
	
	/**
	 * 原始的冒泡算法排序
	 */
	public void sort() {
		if (isNullOrEmpty()) {
			return;
		}
		for (int i = data.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (data[j + 1] < data[j]) {
					swap(j, j + 1);
				}
			}
		}
	}
	
	/**
	 * 改进版的冒泡算法排序
	 * 当剩下的序列已经排好序了，则不再进行排序
	 */
	public void improveSort() {
		boolean sign = true;
		if (isNullOrEmpty()) {
			return;
		}
		for (int i = data.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (data[j + 1] < data[j]) {
					swap(j, j + 1);
					sign = false;
				}
			}
			if (sign) {
				return;
			}
		}
	}
	
}
