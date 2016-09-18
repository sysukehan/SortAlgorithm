package insertionSort;

import util.PrintUtil;

/**
 * 插入排序
 * stable sort、In-place sort
 * @author kehan
 *
 */
public class InsertionSort {
	
	private int[] data;
	
	public InsertionSort(int[] data) {
		this.data = data;
	}
	
	public InsertionSort() {
		
	}
	
	/**
	 * 直接插入排序
	 * 最优时间复杂度为O(N^2)，最差时间复杂度为O(N)，平均时间复杂度为O(N^2)
	 */
	public void sort() {
		if (isEmptyOrNull()) {
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
		if (isEmptyOrNull()) {
			return;
		}
		for (int key = 1; key < data.length; key++) {
			binarySort(key);
//			print();
		}
	}
	
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
	
	public void print() {
		PrintUtil.printArrays(data);
	}
	
	public void setArrays(int[] arrays) {
		data = arrays;
	}
	
	public int[] getArrays() {
		return data;
	}
	
	private void swap(int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
	private boolean isEmptyOrNull() {
		return data == null || data.length == 0;
	}
}
