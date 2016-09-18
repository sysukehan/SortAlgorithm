package bubbleSort;

import util.PrintUtil;

/**
 * 冒泡排序
 * In-place sort and stable sort
 * 最差时间复杂度O(N^2)，最好的时间复杂度O(N)
 * @author kehan
 *
 */
public class BubbleSort {

	private int[] data;
	
	public BubbleSort(int[] arrays) {
		this.data = arrays;
	}
	
	public void setArrays(int[] arrays) {
		this.data = arrays;
	}
	
	public int[] getArrays() {
		return data;
	}
	
	/**
	 * 输出数组
	 */
	public void print() {
		if (isNullOrEmpty()) {
			PrintUtil.printMessage("null");
		} else {
			PrintUtil.printArrays(data);
		}
	}
	
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
	
	/**
	 * 检查待排序的数组是否为空或长度为0
	 * @return
	 */
	private boolean isNullOrEmpty() {
		return data == null || data.length == 0;
	}
	
	/**
	 * 交换数组中指定位置两个元素的值
	 * @param i
	 * @param j
	 */
	private void swap(int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
}
