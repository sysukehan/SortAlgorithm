package selectionSort;

import util.PrintUtil;

/**
 * 选择排序
 * @author Administrator
 *
 */
public class SelectionSort {

	private int[] data;
	
	public SelectionSort() {
		
	}
	
	public SelectionSort(int[] data) {
		this.data = data;
	}
	
	public void setArrays(int[] data) {
		this.data = data;
	}
	
	public int[] getArrays() {
		return data;
	}
	
	public void print() {
		PrintUtil.printArrays(data);
	}
	
	/**
	 * 直接选择排序
	 */
	public void straightSelectSorting() {
		int pos = 0;
		for (int i = 0; i < data.length; i++) {
			pos = i;
			for (int j = i + 1; j < data.length; j++) {
				if (data[j] < data[pos]) {
					pos = j;
				}
			}
			swap(i, pos);
		}
	}
	
	/**
	 * 树形选择排序，又称锦标赛排序
	 */
	public void tournamentSort() {
		
	}
	
	/**
	 * 堆排序（小根堆）
	 */
	public void heapSort() {
		
	}
	
	private void swap(int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
}
