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
		//  data为待排序的数组引用
		for (int i = data.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (data[j + 1] < data[j]) {
					swap(j, j + 1);  //  交换两个数
				}
			}
		}
	}
	
	/**
	 * 改进版的冒泡算法排序
	 * 当剩下的序列已经排好序了，则不再进行排序
	 */
	public void improveSort() {
		if (isNullOrEmpty()) {
			return;
		}
		boolean sign = true;  //  标志位，初始化为true
		for (int i = data.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (data[j + 1] < data[j]) {
					swap(j, j + 1);
					sign = false;  //  如果发生交换，说明数组仍为无序，置标志位为false
				}
			}
			//  如果标志位为true，说明上一次循环中没有交换发生，排序可以结束了
			if (sign) {
				return;
			}
		}
	}
	
}
