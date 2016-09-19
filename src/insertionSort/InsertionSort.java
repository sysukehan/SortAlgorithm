package insertionSort;

import main.BaseSortClass;

/**
 * 插入排序
 * stable sort、In-place sort
 * @author kehan
 *
 */
public class InsertionSort extends BaseSortClass {
	
	/**
	 * 直接插入排序
	 * 最优时间复杂度为O(N^2)，最差时间复杂度为O(N)，平均时间复杂度为O(N^2)
	 */
	public void sort() {
		if (isNullOrEmpty()) {
			return;
		}
		for (int key = 1; key < data.length; key++) {
			for (int i = key; i > 0; i--) {
				if (data[i] < data[i - 1]) {
					swap(i - 1, i);
				} else {
					break;
				}
			}
		}
	}
	
	/**
	 * 二分插入排序
	 * 最优时间复杂度为O(N^2)，最差时间复杂度为O(N)，平均时间复杂度为O(N^2)
	 */
	public void binaryInsertSort() {
		if (isNullOrEmpty()) {
			return;
		}
		for (int key = 1; key < data.length; key++) {
			binarySort(key);
//			print();
		}
	}
	
	/**
	 * 二分查找key下标的值应该插入在哪个位置并插入
	 * @param key
	 */
	private void binarySort(int key) {
		int temp = data[key];
		int beginPos = 0;
		int endPos = key - 1;
		while (endPos - beginPos > 1) {
			int middle = (beginPos + endPos) / 2;
			if (data[middle] < temp) {
				beginPos = middle;
			} else {
				endPos = middle;
			}
//			System.out.println("beginPos:" + beginPos + " endPos:" + endPos);
		}
		if (temp < data[beginPos]) {
			moveData(beginPos, key);
		} else if (temp < data[endPos]) {
			moveData(endPos, key);
		} else {
			moveData(endPos + 1, key);
		}
	}
	
	/**
	 * 将数组中从begin到end位置的数循环右移一位
	 * @param begin
	 * @param end
	 */
	private void moveData(int begin, int end) {
		int temp = data[end];
		for (int i = end; i > begin; i--) {
			data[i] = data[i - 1];
		}
		data[begin] = temp;
	}
	
	/**
	 * 希尔排序
	 * 最优时间复杂度为O(N^2)，最差时间复杂度为O(N)，平均时间复杂度为O(N^1.3)，在N较小时速度较快
	 */
	public void shellSort() {
		for (int cap = data.length / 2; cap > 0; cap = cap / 2) {
			for (int i = 0; i < cap; i++) {
				for (int key = i + cap; key < data.length; key = key + cap) {
					for (int j = key - cap; j >= 0; j = j - cap) {
						if (data[j + cap] < data[j]) {
							swap(j + cap, j);
						}
					}
				}
			}
		}
	}
}
