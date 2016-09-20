package main;

import util.PrintUtil;

/**
 * 排序算法类的基类，提供一些共同的方法
 * @author Administrator
 *
 */
public class BaseSortClass {

	public int[] data;
	
	public BaseSortClass() {
		
	}
	
	public BaseSortClass(int[] data) {
		this.data = data;
	}
	
	public void setData(int[] data) {
		this.data = data;
	}
	
	public int[] getData() {
		return this.data;
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
	
	public boolean isNullOrEmpty() {
		return data == null || data.length == 0;
	}
	
	/**
	 * 交换数组中指定位置两个元素的值
	 * @param i
	 * @param j
	 */
	public void swap(int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
	public int getMax() {
		int result = data[0];
		for (int i = 1; i < data.length; i++) {
			if (data[i] > result) {
				result = data[i];
			}
		}
		return result;
	}
}
