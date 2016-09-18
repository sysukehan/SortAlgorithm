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
	
	/**
	 * 直接插入排序
	 */
	public void sort() {
		if (isEmptyOrNull()) {
			return;
		}
		if (data.length <= 1) {
			return;
		}
		for (int key = 0; key < data.length; key++) {
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
	 */
	public void binaryInsertSort() {
		
	}
	
	/**
	 * 希尔排序
	 */
	public void shellSort() {
		
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
